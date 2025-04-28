package catalogo.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/ucb_almacen?user=ucb&password=Tarija2025";
        return DriverManager.getConnection(url);
    }
}
