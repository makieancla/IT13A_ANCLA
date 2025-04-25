
package ANCLA_JAVALOGINGUI;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class LoginForm extends JFrame {
    private JLabel userLabel, passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;

    public LoginForm() {
        // GUI Components
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userText = new JTextField(15);
        passText = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Layout Setup
        setLayout(null);
        userLabel.setBounds(30, 30, 80, 25);
        userText.setBounds(120, 30, 150, 25);
        passLabel.setBounds(30, 70, 80, 25);
        passText.setBounds(120, 70, 150, 25);
        loginButton.setBounds(120, 110, 80, 25);

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);

     
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);

        // Button Action Listener
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
    }

    // Validate Login Against File
    private boolean validateLogin(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2) {
                    if (credentials[0].trim().equals(username) && credentials[1].trim().equals(password)) {
                        reader.close();
                        return true;
                    }
                }
            }

            reader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "welcome to mobile legend.");
        }

        return false;
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
