
package att;

import java.sql.*;
import java.util.*;
import auth.DBConn;

public class CourseDAO {
    private Connection conn;
    
    public CourseDAO() {
        this.conn = DBConn.getConnection();
    }
    
    public List<Course> getCoursesByLecturer(String lecturerName) {
    List<Course> courses = new ArrayList<>();
    try {
        String sql = "SELECT c.course_id, c.course_name " +
                     "FROM courses c " +
                     "JOIN users u ON c.lecturer_id = u.user_id " +
                     "WHERE u.FullName = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, lecturerName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            courses.add(new Course(rs.getInt("course_id"), rs.getString("course_name")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return courses;
}

    
}
