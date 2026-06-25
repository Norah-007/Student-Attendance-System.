package att;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.time.Year;
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import eligibility.EligibilityDAO;
import auth.LoginForm;


public class AttendForm extends javax.swing.JFrame {

    private String lecturerName;
    private int selectedCourseId;

    public AttendForm(String lecturerName) {
    initComponents();
   
    this.lecturerName = lecturerName;
    lecturerField.setText(lecturerName);
    lecturerField.setEditable(false);

    // Initialize months
    monthCmb.removeAllItems();
    monthCmb.addItem("April");
    monthCmb.addItem("May");
    monthCmb.addItem("June");
    monthCmb.addItem("July");

    // Initialize empty table
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Name");
    attendanceTab.setModel(model);

    // Load courses for lecturer
    CourseDAO dao = new CourseDAO();
    lecturerCourses = dao.getCoursesByLecturer(lecturerName);

    courseCmb.removeAllItems();
    for (Course c : lecturerCourses) {
        courseCmb.addItem(c.getCourseName());
    }

    // ✅ Optional: auto-select first course so it's never null
    if (!lecturerCourses.isEmpty()) {
        courseCmb.setSelectedIndex(0);
    }

    // Search filter listener
    searchField.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) { filter(); }
        @Override
        public void removeUpdate(DocumentEvent e) { filter(); }
        @Override
        public void changedUpdate(DocumentEvent e) { filter(); }
    });
}

    
    private void filter() {
        String keyword = searchField.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) attendanceTab.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        attendanceTab.setRowSorter(sorter);

        if (keyword.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, 1));
        }
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTab = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        monthCmb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lecturerField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        courseCmb = new javax.swing.JComboBox<>();
        eligibilityBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jButton3.setBackground(new java.awt.Color(97, 163, 142));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save Attendance");

        jButton5.setBackground(new java.awt.Color(97, 163, 142));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Save Attendance");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        attendanceTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(attendanceTab);

        saveBtn.setBackground(new java.awt.Color(97, 163, 142));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save Attendance");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Select month:");

        monthCmb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        monthCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        monthCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCmbActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setText("Search :");

        searchField.setText(" ");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.setBackground(new java.awt.Color(97, 163, 142));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 29)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Student Attendance Management System");

        jPanel3.setBackground(new java.awt.Color(217, 231, 228));

        jLabel2.setText("Lecturer :");

        lecturerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturerFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Select course :");

        courseCmb.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        courseCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        courseCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCmbActionPerformed(evt);
            }
        });

        eligibilityBtn.setBackground(new java.awt.Color(97, 163, 142));
        eligibilityBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        eligibilityBtn.setForeground(new java.awt.Color(255, 255, 255));
        eligibilityBtn.setText("Check Eligibility");
        eligibilityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eligibilityBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lecturerField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(461, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eligibilityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lecturerField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(eligibilityBtn)
                .addGap(9, 9, 9))
        );

        logoutBtn.setBackground(new java.awt.Color(217, 231, 228));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        logoutBtn.setText("LogOut");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(logoutBtn)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void courseCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCmbActionPerformed
        if (courseCmb.getSelectedItem() != null) {
        String selectedName = courseCmb.getSelectedItem().toString();
        Course selectedCourse = lecturerCourses.stream()
            .filter(c -> c.getCourseName().equals(selectedName))
            .findFirst()
            .orElse(null);

        if (selectedCourse != null) {
            selectedCourseId = selectedCourse.getCourseId();
            loadStudentsForCourse(selectedCourseId);
        }
    }
    }//GEN-LAST:event_courseCmbActionPerformed

    private void lecturerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturerFieldActionPerformed
        
    }//GEN-LAST:event_lecturerFieldActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to log out?",
        "Confirm Logout",
        JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            this.dispose();
            new LoginForm().setVisible(true);
        }

    }//GEN-LAST:event_logoutBtnActionPerformed

    private void monthCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCmbActionPerformed
        if (monthCmb.getSelectedItem() != null && courseCmb.getSelectedItem() != null) {
            String selectedMonth = monthCmb.getSelectedItem().toString();
            String selectedName = courseCmb.getSelectedItem().toString();

            Course selectedCourse = lecturerCourses.stream()
                .filter(c -> c.getCourseName().equals(selectedName))
                .findFirst()
                .orElse(null);

            if (selectedCourse != null) {
                int courseId = selectedCourse.getCourseId();

                AttendanceDAO dao = new AttendanceDAO();
                boolean hasData = dao.hasAttendanceForMonth(courseId, selectedMonth);

                if (hasData) {
                    loadAttendanceForMonth(courseId, selectedMonth);   // ✅ load from DB
                } else {
                    createNewAttendanceTable(courseId, selectedMonth); // ✅ fresh table
                }
            }
        }
    }//GEN-LAST:event_monthCmbActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        AttendanceDAO dao = new AttendanceDAO();
        dao.saveAttendanceForMonth(
            selectedCourseId,
            monthCmb.getSelectedItem().toString(),
            Year.now().getValue(),
            attendanceTab
        );
        JOptionPane.showMessageDialog(this, "Attendance saved/updated successfully!");      
    }//GEN-LAST:event_saveBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void eligibilityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eligibilityBtnActionPerformed
        int selectedRow = attendanceTab.getSelectedRow();
        if (selectedRow != -1) {
            int studentId = (int) attendanceTab.getValueAt(selectedRow, 0);
            String studentName = (String) attendanceTab.getValueAt(selectedRow, 1);

            EligibilityDAO dao = new EligibilityDAO();
            double percentage = dao.calculateAttendancePercentage(studentId, selectedCourseId);

             String status = (percentage >= 75) ? "Eligible" : "Not Eligible";

            JOptionPane.showMessageDialog(this,
                    studentName + "\nAttendance: " + String.format("%.2f", percentage) + "%\nStatus: " + status);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
        }
    }//GEN-LAST:event_eligibilityBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AttendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendForm("Test lecturer").setVisible(true);
            }
        });
    }

    
    // Keep a list of courses for lookup
    private List<Course> lecturerCourses = new ArrayList<>();

    private void loadCoursesForLecturer(String lecturerName) {
        try {
            CourseDAO dao = new CourseDAO();
            lecturerCourses = dao.getCoursesByLecturer(lecturerName); // List<Course>
            courseCmb.removeAllItems();
            for (Course course : lecturerCourses) {
                courseCmb.addItem(course.getCourseName()); // only add String name
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    

    private void loadStudentsForCourse(int courseId) {
        try {
            StudentDAO dao = new StudentDAO();
            List<Student> students = dao.getStudentsByCourse(courseId);

            DefaultTableModel model = (DefaultTableModel) attendanceTab.getModel();
            model.setRowCount(0); // clear table

            for (Student s : students) {
                model.addRow(new Object[]{s.getId(), s.getName(), false});
                // last column could be a checkbox for attendance
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void addDateColumn() {
        String date = JOptionPane.showInputDialog(this, "Enter date (dd-MMM):");
        if (date != null && !date.trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) attendanceTab.getModel();
            model.addColumn(date.trim());

            // Add empty cells for each student row
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt("", i, model.getColumnCount() - 1);
            }
        }
    }
    
    private void saveAttendance() {
        DefaultTableModel model = (DefaultTableModel) attendanceTab.getModel();
        int rows = model.getRowCount();

        AttendanceDAO dao = new AttendanceDAO();

        for (int i = 0; i < rows; i++) {
            int studentId = Integer.parseInt(model.getValueAt(i, 0).toString());

            // Get selected course name
            String selectedName = courseCmb.getSelectedItem().toString();

            // Find matching Course object
            Course selectedCourse = lecturerCourses.stream()
            .filter(c -> c.getCourseName().equals(selectedName))
            .findFirst()
            .orElse(null);

            if (selectedCourse == null) continue; // safety check

            int courseId = selectedCourse.getCourseId();

            for (int col = 2; col < model.getColumnCount(); col++) {
                String date = model.getColumnName(col);
                String status = (String) model.getValueAt(i, col); // P, A, L

                dao.saveAttendance(studentId, courseId, date, status);
            }
        }

        JOptionPane.showMessageDialog(this, "Attendance saved successfully!");
    }

    private void checkEligibility() {
        int selectedRow = attendanceTab.getSelectedRow();
        if (selectedRow != -1) {
            int studentId = (int) attendanceTab.getValueAt(selectedRow, 0);
            String studentName = (String) attendanceTab.getValueAt(selectedRow, 1);

            String selectedName = courseCmb.getSelectedItem().toString();
            Course selectedCourse = lecturerCourses.stream()
                .filter(c -> c.getCourseName().equals(selectedName))
                .findFirst()
                .orElse(null);

            if (selectedCourse != null) {
                int courseId = selectedCourse.getCourseId(); // ✅ int, not String
                EligibilityDAO dao = new EligibilityDAO();
                double percentage = dao.calculateAttendancePercentage(studentId, courseId);

                String status = (percentage >= 75) ? "Eligible" : "Not Eligible";
                JOptionPane.showMessageDialog(this,
                    studentName + "\nAttendance: " + percentage + "%\nStatus: " + status);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
        }
    }

        
    private void loadAttendanceForMonth(int courseId, String monthName) {
    int year = Year.now().getValue();
    int month = Month.valueOf(monthName.toUpperCase()).getValue();

    AttendanceDAO dao = new AttendanceDAO();
    Map<Integer, Map<Integer, String>> data = dao.getAttendanceForMonth(courseId, year, month);

    DefaultTableModel model = (DefaultTableModel) attendanceTab.getModel();

    for (int row = 0; row < model.getRowCount(); row++) {
        int studentId = (int) model.getValueAt(row, 0);
        Map<Integer, String> weeks = data.get(studentId);

        if (weeks != null) {
            for (int week = 1; week <= 4; week++) {
                String status = weeks.get(week);
                if (status != null) {
                    // convert full word back to shorthand
                    String shorthand = status.equals("present") ? "P" :
                                       status.equals("absent") ? "A" :
                                       status.equals("late") ? "L" : "";
                    model.setValueAt(shorthand, row, 1 + week);
                }
            }
        }
    }
}


    
    
    private void viewPreviousMonth() {
        String selectedName = courseCmb.getSelectedItem().toString();
        Course selectedCourse = lecturerCourses.stream()
            .filter(c -> c.getCourseName().equals(selectedName))
            .findFirst()
            .orElse(null);

        if (selectedCourse != null) {
            int courseId = selectedCourse.getCourseId();   // ✅ int
            String month = monthCmb.getSelectedItem().toString(); // ✅ String
            loadAttendanceForMonth(courseId, month);
        }
    }

    private void createNewAttendanceTable(int courseId, String month) {
        StudentDAO studentDao = new StudentDAO();
        List<Student> students = studentDao.getStudentsByCourse(courseId);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");

        // Add columns for each scheduled class day in that month
        // For simplicity, let’s say 4 weeks → 4 dates
        for (int i = 1; i <= 4; i++) {
            model.addColumn(month + " Week " + i);
        }

        for (Student s : students) {
            Object[] row = new Object[2 + 4];
            row[0] = s.getId();
            row[1] = s.getName();
            // Empty attendance cells
            for (int i = 2; i < row.length; i++) {
                row[i] = "";
            }
            model.addRow(row);
        }

        attendanceTab.setModel(model);
    }

    




    




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTab;
    private javax.swing.JComboBox<String> courseCmb;
    private javax.swing.JButton eligibilityBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lecturerField;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JComboBox<String> monthCmb;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
