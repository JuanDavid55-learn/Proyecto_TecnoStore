package Controlador;

import MODELO.Gama;
import Modelo.celulares;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionarCelularesDAO implements GestionarCelulares{
    ConexiónDB c = new ConexiónDB();
    
    @Override
    public void RegistrarCelular(celulares cel) {
        String sql = "INSERT INTO celulares (id_marca, modelo, sistema_operativo, gama, stock, precio) VALUES (?,?,?,?,?,?)";

        try(Connection con = c.conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cel.getId_marca());
            ps.setString(2, cel.getModelo());
            ps.setString(3, cel.getSistema_operativo());
            ps.setString(4, cel.getGama().name());
            ps.setInt(5, cel.getStock());
            ps.setInt(6, cel.getPrecio());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ActualizarCelular(celulares cel, int id) {
        String sql = "UPDATE celulares SET stock=?, precio=? WHERE id=?";
        
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cel.getStock());
            ps.setInt(2, cel.getPrecio());
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Se ha realizado la actualizacion");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void EliminarCelular(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("DELETE from celulares where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Celular?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("Se ha eliminado el celular");
            } else {
                System.out.println("Se ha cancelado la eliminacion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<celulares> ListarCelulares() {
        ArrayList<celulares> LosCelulares = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from celulares");
            while (rs.next()) {
                Gama gama = Gama.valueOf(rs.getString(5).toUpperCase());
                LosCelulares.add(new celulares(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), gama, rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return LosCelulares;
    }

    @Override
    public celulares BuscarCelular(int id) {
        celulares cel = new celulares();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM celulares WHERE id=" + id);
            while (rs.next()) {
                Gama gama = Gama.valueOf(rs.getString(5).toUpperCase());
                
                cel.setId(rs.getInt(1));
                cel.setId_marca(rs.getInt(2));
                cel.setModelo(rs.getString(3));
                cel.setSistema_operativo(rs.getString(4));
                cel.setGama(gama);
                cel.setStock(rs.getInt(6));
                cel.setPrecio(rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cel;
    }
}
