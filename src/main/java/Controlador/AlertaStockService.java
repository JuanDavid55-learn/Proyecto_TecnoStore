package Controlador;

import MODELO.Gama;
import Modelo.celulares;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlertaStockService {
    ConexiónDB c = new ConexiónDB();
    
    public ArrayList<celulares> ListarCelStockBajo() {
        ArrayList<celulares> celsStockBajo = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM celulares WHERE stock < 5");
            while (rs.next()) {
                Gama gama = Gama.valueOf(rs.getString(5).toUpperCase());
                celsStockBajo.add(new celulares(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), gama, rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return celsStockBajo;
    }
    
    public void generarReporteVentas() {
        String sql = """
        SELECT c.id AS celular_id, c.modelo, c.stock, c.precio,
        m.nombre AS marca FROM celulares c
        LEFT JOIN marcas m ON m.id = c.id_marca;
        """;
        try (Connection con = c.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql); BufferedWriter bw = new BufferedWriter(new FileWriter("stock_bajo.txt"))) {

            bw.write("\n\n--- ALERTA DE STOCK BAJO --\n\n");

            while (rs.next()) {
                int celularId = rs.getInt("celular_id");
                String modelo = rs.getString("modelo");
                int stock = rs.getInt("stock");
                double precio = rs.getDouble("precio");
                double marca = rs.getDouble("marca");

                bw.write("Celular ID: " + celularId
                        + " | Modelo: " + modelo
                        + " | Stock: " + stock
                        + " | Precio: " + precio
                        + " | Subtotal: " + marca + "\n");
                bw.write("\n");
            }

            System.out.println("Reporte generado en stock_bajo.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void VerReporteVentas() {
        try (BufferedReader br = new BufferedReader(new FileReader("stock_bajo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
