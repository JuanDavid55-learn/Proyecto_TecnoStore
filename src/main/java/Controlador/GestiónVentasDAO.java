package Controlador;

import Modelo.celulares;
import Modelo.detalle_ventas;
import Modelo.ventas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class GestiónVentasDAO implements GestiónVentas {

    ConexiónDB c = new ConexiónDB();

    @Override
    public int RegistrarVenta(ventas v) {
        String sql = "INSERT INTO ventas (id_cliente, fecha, total) VALUES (?,?,?)";
        int idGenerado = -1;

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, v.getId_cliente());
            ps.setString(2, v.getFecha());
            ps.setDouble(3, v.getTotal());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idGenerado;
    }

    @Override
    public double CalcularTotal(celulares cel, int cantidadVendida) {
        return cel.getPrecio() * cantidadVendida;
    }

    @Override
    public double CalcularVenta_Totl_Mas_IVA(ventas v, int id) {
        double totalConIVA = v.getTotal() * 1.19;
        return totalConIVA;
    }

    @Override
    public int ActualizarStock(celulares cel, int id) {
        int cantidadVendida;
        int nuevoStock;
        while (true) {
            System.out.println("Ingrese la cantidad vendida:");
            cantidadVendida = new Scanner(System.in).nextInt();
            nuevoStock = cel.getStock() - cantidadVendida;
            if (nuevoStock < 0) {
                System.out.println("Error: la cantidad supera el stock disponible (" + cel.getStock() + "). Intente nuevamente.");
            } else {
                break;
            }
        }
        String sql = "UPDATE celulares SET stock=? WHERE id=?";
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Stock actualizado. Nuevo stock: " + nuevoStock);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cantidadVendida;
    }

    @Override
    public void GuardarDetalleVenta(detalle_ventas dv) {
        String sql = "INSERT INTO detalle_ventas (id_venta, id_celular, cantidad, subtotal) VALUES (?,?,?,?)";
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getId_venta());
            ps.setInt(2, dv.getId_celular());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getSubtotal());
            ps.executeUpdate();
            System.out.println("Detalle de venta guardado con éxito.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void generarReporteVentas() {
        String sql = """
        SELECT v.id AS venta_id, v.id_cliente, v.fecha,
        v.total, d.id_celular, d.cantidad, d.subtotal, 
        c.modelo FROM ventas v
        LEFT JOIN detalle_ventas d ON v.id = d.id_venta
        LEFT JOIN celulares c ON d.id_celular = c.id;
        """;
        try (Connection con = c.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql); BufferedWriter bw = new BufferedWriter(new FileWriter("reporte_ventas.txt"))) {

            bw.write("\n\nREPORTE DE VENTAS\n\n");

            while (rs.next()) {
                int ventaId = rs.getInt("venta_id");
                int idCliente = rs.getInt("id_cliente");
                String fecha = rs.getString("fecha");
                double total = rs.getDouble("total");

                int idCelular = rs.getInt("id_celular");
                String modelo = rs.getString("modelo");
                int cantidad = rs.getInt("cantidad");
                double subtotal = rs.getDouble("subtotal");

                bw.write("Venta ID: " + ventaId
                        + " | Cliente: " + idCliente
                        + " | Fecha: " + fecha
                        + " | Total: " + total + "\n");

                if (idCelular != 0) {
                    bw.write("Celular ID: " + idCelular
                            + " | Modelo: " + modelo
                            + " | Cantidad: " + cantidad
                            + " | IVA aplicado: 19%"
                            + " | Subtotal: " + subtotal + "\n");
                }
                bw.write("\n");
            }

            System.out.println("Reporte generado en reporte_ventas.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void VerReporteVentas() {
        try (BufferedReader br = new BufferedReader(new FileReader("reporte_ventas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public ArrayList<String> top3CelularesMasVendidos() {
        ArrayList<String> celsMasVendidos = new ArrayList<>();
        String sql = """
        SELECT c.modelo, SUM(d.cantidad) AS total_vendidos
        FROM detalle_ventas d INNER JOIN celulares c 
        ON d.id_celular = c.id GROUP BY c.modelo
        ORDER BY total_vendidos DESC LIMIT 3;
        """;
        try (Connection con = c.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String modelo = rs.getString("modelo");
                int vendidos = rs.getInt("total_vendidos");
                celsMasVendidos.add(modelo + " - Vendidos: " + vendidos);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return celsMasVendidos;
    }

    @Override
    public Map<String, Double> ventasTotalesPorMes() {
        ArrayList<ventas> totalXMes = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ventas");
            while (rs.next()) {
                ventas v = new ventas(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("fecha"),
                        rs.getDouble("total")
                );
                totalXMes.add(v);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Map<String, Double> ventasPorMes = totalXMes.stream()
                .collect(Collectors.groupingBy(v -> v.getFecha().substring(0, 7), Collectors.summingDouble(ventas::getTotal)));
        return ventasPorMes;
    }
}
