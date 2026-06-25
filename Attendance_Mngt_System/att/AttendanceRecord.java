
package att;

import java.util.HashMap;
import java.util.Map;

public class AttendanceRecord {
    private int studentId;
    private String studentName;
    private Map<String, String> dateStatusMap; // date -> "P", "A", "L"

    public AttendanceRecord(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateStatusMap = new HashMap<>();
    }
    
    public int getStudentId() { 
        return studentId; 
    }
    public String getStudentName() {
        return studentName;
    }

    // Add attendance status for a specific date
    public void addStatus(String date, String status) {
        dateStatusMap.put(date, status);
    }

    // Retrieve status for a specific date
    public String getStatusForDate(String date) {
        return dateStatusMap.getOrDefault(date, "");
    }
}
