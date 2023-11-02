package AMS.UserDAO;

import AMS.DB.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static boolean enter(String username, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        if(SignUp.isExist(username)) {
            PreparedStatement ps = connection.prepareStatement(
                    "Select * from users where username='"+username+"' and password='"+password+"'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "You have entered wrong Username and Password!!");
                return false;
            }

        }
        JOptionPane.showMessageDialog(null,
                "Username doesn't exist, try signing in.");

        return false;
    }
}
