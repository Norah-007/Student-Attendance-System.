package com.mycompany.attendance_mngt_system;

import auth.LoginForm;


/**
 *
 * @author hp
 */
public class Attendance_Mngt_System {

    public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
