
package auth;

import java.sql.*;

public class AuthDAO {
   private Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/attendance_db";
        String user = "root";   // adjust if needed
        String password = "";   // adjust if needed
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to DB successfully!");
        return conn;
    }

    public String login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        String lecturerName = null;
        try (Connection conn = connect();    
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                lecturerName = rs.getString("FullName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lecturerName;
    } 
    public void testConnection() {
    try (Connection conn = connect()) {
        System.out.println("✅ DB responded: " + conn.getCatalog());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
