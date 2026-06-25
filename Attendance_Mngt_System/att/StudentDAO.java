
package att;

import java.sql.*;
import java.util.*;
import auth.DBConn;

public class StudentDAO {
    private Connection conn;
    
    public StudentDAO() {
        this.conn = DBConn.getConnection();
    }
    
    public List<Student> getStudentsByCourse(int courseId) {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.student_id, s.name " +
                         "FROM students s " +
                         "JOIN student_courses sc ON s.student_id = sc.student_id " +
                         "JOIN courses c ON sc.course_id = c.course_id " +
                         "WHERE c.course_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("name")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
