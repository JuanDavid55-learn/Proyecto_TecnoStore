package Controlador;

import Controlador.ConexiónDB;
import Modelo.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionMarcasDAO implements GestionMarcas{
    ConexiónDB c = new ConexiónDB();

    
    @Override
    public void RegistrarMarca(Marca m) {
        String sql = "INSERT INTO marcas (nombre) VALUES (?)";

        try(Connection con = c.conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    @Override
    public void EliminarMarca(int id) {
        try (Connection con = c.conectar()) {
            //La usamos cuando queremos hacer una inserción o modificacion a la base de datos.
            PreparedStatement ps = con.prepareStatement("delete from marcas where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el area?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("Se ha eliminado la marca");
            } else {
                System.out.println("Se ha cancelado la eliminacion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    @Override
    public ArrayList<Marca> ListarMarcas() {
        ArrayList<Marca> marcas = new ArrayList<>();
        try (Connection con = c.conectar()) {
            //creo el statement para que quede listo cuando quiera escribir en sql
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from marcas");
            while (rs.next()) {
                marcas.add(new Marca(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return marcas;
    }
}
