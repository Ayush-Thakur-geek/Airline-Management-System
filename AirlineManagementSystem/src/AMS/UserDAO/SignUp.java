package AMS.UserDAO;

import AMS.DB.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp {
    public static boolean isExist(String username) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "select username from users");
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            String un = rs.getString(1);
            if (un.equals(username)) {
                return true;
            }
        }
        return false;
    }
    public static Integer saveUser(String username, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        if (SignUp.isExist(username)) {
            JOptionPane.showMessageDialog(null,
                    "Username already exists.");
            return 0;
        }
        PreparedStatement ps = connection.prepareStatement(
                "insert into users values(Default, ?, ?)");
        ps.setString(1, username);
        ps.setString(2, password);
        return ps.executeUpdate();

    }
}
