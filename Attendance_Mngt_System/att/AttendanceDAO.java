package att;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import auth.DBConn;
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;// needed for getDateForWeek
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;

import att.AttendanceRecord;

public class AttendanceDAO {

    // Save a new attendance record
    public void saveAttendance(int studentId, int courseId, String date, String status) {
        String sql = "INSERT INTO attendance (student_id, course_id, date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setString(3, date);
            ps.setString(4, status);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveAttendanceForMonth(int courseId, String month, int year, JTable attendanceTab) {
        DefaultTableModel model = (DefaultTableModel) attendanceTab.getModel();
        int rowCount = model.getRowCount();

        try {
            Connection conn = DBConn.getConnection();
            String sql = "INSERT INTO attendance (student_id, course_id, date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int row = 0; row < rowCount; row++) {
                int studentId = (int) model.getValueAt(row, 0);

                for (int week = 1; week <= 4; week++) {
                    Object cellValue = model.getValueAt(row, 1 + week);
                    if (cellValue != null) {
                        String status = mapStatus(cellValue.toString().trim());
                        if (status != null) {
                            LocalDate date = getDateForWeek(year, Month.valueOf(month.toUpperCase()).getValue(), week);
                            saveOrUpdateAttendance(studentId, courseId, date.toString(), status);
                        }
                    }
                }
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Update an existing attendance record
    public void updateAttendance(int studentId, int courseId, String date, String status) {
        String sql = "UPDATE attendance SET status=? WHERE student_id=? AND course_id=? AND date=?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);
            ps.setString(4, date);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveOrUpdateAttendance(int studentId, int courseId, String date, String status) {
        if (attendanceExists(studentId, courseId, date)) {
            updateAttendance(studentId, courseId, date, status);   // ✅ update
        } else {
            saveAttendance(studentId, courseId, date, status);     // ✅ insert
        }
    }


    // Fetch attendance records for a course and month
    public List<AttendanceRecord> getAttendanceByCourseAndMonth(int courseId, String month) {
        List<AttendanceRecord> records = new ArrayList<>();

        try (Connection conn = DBConn.getConnection()) {
            String sql = "SELECT s.student_id, s.name, a.date, a.status " +
                         "FROM students s " +
                         "JOIN attendance a ON s.student_id = a.student_id " +
                         "WHERE a.course_id = ? AND MONTHNAME(a.date) = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            stmt.setString(2, month);
            ResultSet rs = stmt.executeQuery();
            
            Map<Integer, AttendanceRecord> recordMap = new HashMap<>();

            // Build AttendanceRecord objects from results
            while (rs.next()) {
                int studentId = rs.getInt("id");
                String studentName = rs.getString("name");
                String date = rs.getString("date");
                String status = rs.getString("status");

                AttendanceRecord record = recordMap.get(studentId);
                if (record == null) {
                    record = new AttendanceRecord(studentId, studentName);
                    recordMap.put(studentId, record);
                }
                // ✅ Add status for this date
                record.addStatus(date, status);   
            }
            
            // Convert map values to list
        records.addAll(recordMap.values());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
    
    public List<String> getDatesForCourseAndMonth(int courseId, String month) {
        List<String> dates = new ArrayList<>();

        try (Connection conn = DBConn.getConnection()) {
            String sql = "SELECT DISTINCT a.date FROM attendance a " +
                         "WHERE a.course_id = ? AND MONTHNAME(a.date) = ? ORDER BY a.date";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            stmt.setString(2, month);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dates.add(rs.getString("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dates;
    }
    
    public boolean hasAttendanceForMonth(int courseId, String month) {
        try (Connection conn = DBConn.getConnection()) {
            String sql = "SELECT COUNT(*) FROM attendance WHERE course_id = ? AND MONTHNAME(date) = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            stmt.setString(2, month);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   
    private String mapStatus(String shorthand) {
        switch (shorthand) {
            case "P": return "present";
            case "A": return "absent";
            case "L": return "late";
            default: return null;
        }
    }

    private LocalDate getDateForWeek(int year, int month, int weekIndex) {
        LocalDate baseDate = LocalDate.of(year, month, 1);
        while (baseDate.getDayOfWeek() != DayOfWeek.MONDAY) {
            baseDate = baseDate.plusDays(1);
        }
        return baseDate.plusWeeks(weekIndex - 1);
    }
    
    public Map<Integer, Map<Integer, String>> getAttendanceForMonth(int courseId, int year, int month) {
        Map<Integer, Map<Integer, String>> attendanceMap = new HashMap<>();
        String sql = "SELECT student_id, date, status FROM attendance WHERE course_id=? AND YEAR(date)=? AND MONTH(date)=?";
        try (Connection conn = DBConn.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ps.setInt(2, year);
            ps.setInt(3, month);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                LocalDate date = rs.getDate("date").toLocalDate();
                String status = rs.getString("status");

                // figure out which week this date belongs to
                int weekIndex = (date.getDayOfMonth() - 1) / 7 + 1;

                attendanceMap.putIfAbsent(studentId, new HashMap<>());
                attendanceMap.get(studentId).put(weekIndex, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendanceMap;
    }
    
    public boolean attendanceExists(int studentId, int courseId, String date) {
        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id=? AND course_id=? AND date=?";
        try (Connection conn = DBConn.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setString(3, date);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}
