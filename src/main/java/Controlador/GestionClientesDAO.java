package Controlador;

import Modelo.clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GestionClientesDAO implements GestionClientes {

    ConexiónDB c = new ConexiónDB();

    @Override
    public void RegistrarCliente(clientes cli) {
        String sql = "INSERT INTO clientes (nombre, identificacion, correo, telefono) VALUES (?,?,?,?)";

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getIdentificacion());
            ps.setString(3, cli.getCorreo());
            ps.setString(4, cli.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ActualizarCliente(clientes cli, int id) {
        String sql = "UPDATE clientes SET nombre=?, identificacion=?, correo=?, telefono=? WHERE id=?";

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getIdentificacion());
            ps.setString(3, cli.getCorreo());
            ps.setString(4, cli.getTelefono());
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.println("Se ha realizado la actualizacion");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void EliminarCliente(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("DELETE from clientes where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el cliente?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("Se ha eliminado el cliente");
            } else {
                System.out.println("Se ha cancelado la eliminacion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<clientes> ListarClientes() {
        ArrayList<clientes> LosClientes = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from clientes");
            while (rs.next()) {
                LosClientes.add(new clientes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return LosClientes;
    }

    @Override
    public clientes BuscarCliente(int id) {
        clientes cli = new clientes();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE id=" + id);
            while (rs.next()) {
                cli.setId(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setIdentificacion(rs.getString(3));
                cli.setCorreo(rs.getString(4));
                cli.setTelefono(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cli;
    }

    @Override
    public ArrayList<String> ListarClientesResum() {
        ArrayList<String> listCliResm = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, nombre FROM clientes");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                listCliResm.add("ID: " + id + "|  Nombre: " + nombre + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listCliResm;
    }

    @Override
    public String pedirCorreoFormato() {
        String correo;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        while (true) {
            System.out.println("Ingrese el correo del cliente:");
            correo = new Scanner(System.in).nextLine();
            if (correo.matches(regex)) {
                break;
            } else {
                System.out.println("Formato invalido, intentelo de nuevo.");
            }
        }
        return correo;
    }

    @Override
    public String validarIdenUnica() {
        String identificacion;
        while (true) {
            System.out.print("Ingrese la identificación del cliente: ");
            identificacion = new Scanner(System.in).nextLine();
            try (Connection con = c.conectar()) {
                PreparedStatement ps = con.prepareStatement("SELECT 1 FROM clientes WHERE identificacion = ? LIMIT 1");
                ps.setString(1, identificacion);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    return identificacion;
                } else {
                    System.out.println("Identificacion registrada, intente de nuevo.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
}
