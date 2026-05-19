package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC { // class này để làm việc với database
    private static final String URL = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=JAV20301;encrypt=true;trustServerCertificate=true";
    private static final String USER = "SA"; // tên tài khoản kết nối
    private static final String PASS = "Vinaboy00"; // password kết nối của DB

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Error connect DB: " + e.getMessage(), e);
        }
    }
}
