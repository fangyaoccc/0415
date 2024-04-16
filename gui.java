import javax.swing.*;
import java.awt.*;
class ChatUI {
    JFrame frame = new JFrame("Chat Window");
    JTextArea chatArea = new JTextArea();
    JTextField chatField = new JTextField();
    JButton sendButton = new JButton("Send");
    String username;

    public ChatUI(String username) {
        this.username = username;
    }

    void initUI() {
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(chatField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());

        frame.setVisible(true);
    }

    void sendMessage() {
        String message = username + ": " + chatField.getText();
        chatField.setText("");
        Database.addMessage(message);
        chatArea.append(message + "\n");
    }
}
