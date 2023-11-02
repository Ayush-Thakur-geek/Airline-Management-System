package AMS.GUI;

import AMS.UserDAO.Login;
import AMS.UserDAO.SignUp;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = tf.getText();
        String pass = pf.getText();
        if (e.getSource() == b1) {
            try {
                if (Login.enter(username, pass)) {
                    f.setVisible(false);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

//            try {
//                DatabaseConnection obj = new DatabaseConnection();
//                String q = "Select * from signup where username='"+username+"' and password='"+pass+"'";
//                ResultSet rs = obj.stm.executeQuery(q);
//                f.setVisible(false);
//                if (rs.next()) {
//                    f.setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password!!");
//                    f.setVisible(false);
//                    f.setVisible(true);
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
        }
        if (e.getSource() == b2) {

            try {
                if (SignUp.saveUser(username, pass) != 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Username and Password successfully saved");
                    f.setVisible(false);
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    LoginPage() {
        f = new JFrame("Login Account");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        f.add(l1);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("AMS/Images/Login.jpg"));
        Image i1 = img1.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);

        l2 = new JLabel("Username:");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("kajiro", Font.BOLD, 20));
        l1.add(l2);

        l3 = new JLabel("Login Account");
        l3.setBounds(190, 30, 500, 50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("gilroy", Font.BOLD, 30));
        l1.add(l3);

        l4 = new JLabel("Password:");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("kajiro", Font.BOLD, 20));
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(320, 120, 150, 30);
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(320, 170, 150, 30);
        l1.add(pf);

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120, 220, 150, 40);
        l1.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(320, 220, 150, 40);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);
        f.setSize(550, 350);
        f.setLocation(300, 100);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
