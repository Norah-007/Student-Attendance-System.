
package auth;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    private static final String URL = "jdbc:mysql://localhost:3306/attendance_db";
    private static final String USER = "root";       // change if needed
    private static final String PASSWORD = "";       // your MySQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
