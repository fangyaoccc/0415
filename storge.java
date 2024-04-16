import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Database {
    static HashMap<String, User> users = new HashMap<>();
    static List<String> messages = new ArrayList<>();

    static boolean addUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            return true;
        }
        return false;
    }

    static User getUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return user;
        }
        return null;
    }

    static void addMessage(String message) {
        messages.add(message);
    }
}

