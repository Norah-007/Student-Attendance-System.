
package eligibility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import auth.DBConn;

public class EligibilityDAO {
    
    public double calculateAttendancePercentage(int studentId, int courseId) {
        String sql = "SELECT status FROM attendance WHERE student_id=? AND course_id=? AND date <= CURDATE()";
        int totalDays = 0;
        double score = 0;

        try (Connection conn = DBConn.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                totalDays++;
                String status = rs.getString("status");
                if ("present".equalsIgnoreCase(status)) {
                    score += 1;
                } else if ("late".equalsIgnoreCase(status)) {
                    score += 0.5;
                }
                // absent → +0
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (totalDays == 0) ? 0 : (score / totalDays) * 100;
    }

    public boolean isEligible(int studentId, int courseId) {
        return calculateAttendancePercentage(studentId, courseId) >= 75.0;
    }
    
}
