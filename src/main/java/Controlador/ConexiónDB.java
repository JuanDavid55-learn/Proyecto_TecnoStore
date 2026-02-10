package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiónDB {
    public Connection conectar() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tecnostore_db", "juanda", "juanda");
//            c=DriverManager.getConnection("jdbc:mysql://"+ip+"/"+database,user,password);
            System.out.println("Conexion exitosa\n********************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
