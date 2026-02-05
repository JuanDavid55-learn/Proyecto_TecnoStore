package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiónDB {
    public Connection conectar() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/campusan", "campus2023", "campus2023");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
