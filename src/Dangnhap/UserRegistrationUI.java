package Dangnhap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public UserRegistrationUI() {
        frame = new JFrame("User Registration");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Tạo nhãn username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 100, 30);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 100, 200, 30);
        frame.add(usernameField);

        // Tạo nhãn password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 30);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 30);
        frame.add(passwordField);

        // Tạo nút đăng ký
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 100, 30);
        frame.add(registerButton);

        // Tạo nhãn kết quả
        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 250, 300, 30);
        frame.add(resultLabel);

        // Thêm hành động cho nút đăng ký
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("existingUser")) {
                    resultLabel.setText("Username already exists");
                } else if (password.length() < 8 || !password.matches(".*[A-Z].*")) {
                    resultLabel.setText("Password is too weak");
                } else {
                    resultLabel.setText("Registration successful");
                }
            }
        });

        // Hiển thị frame
        frame.setVisible(true);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public void setUsername(String username) {
        usernameField.setText(username);
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }

    public String getResult() {
        return resultLabel.getText();
    }

    public void clickRegister() {
        for (ActionListener al : ((JButton) frame.getContentPane().getComponent(4)).getActionListeners()) {
            al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }

    public static void main(String[] args) {
        new UserRegistrationUI();
    }
}

