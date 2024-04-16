import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignupUI {
    JFrame frame = new JFrame("Chat");

    JPanel panel = new JPanel();
    JTextField usernameField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);
    JButton loginButton = new JButton("Login");
    JButton signupButton = new JButton("Signup");

    public LoginSignupUI() {
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(10, 20, 80, 25);
        panel.add(user);

        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        signupButton.setBounds(100, 80, 100, 25);
        panel.add(signupButton);

        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSignup();
            }
        });
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (Database.getUser(username, password) != null) {
            JOptionPane.showMessageDialog(frame, "Login ok!");
            new ChatUI(username).initUI();
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid! ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performSignup() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (Database.addUser(username, password)) {
            JOptionPane.showMessageDialog(frame, "Signup ok!");
        } else {
            JOptionPane.showMessageDialog(frame, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
