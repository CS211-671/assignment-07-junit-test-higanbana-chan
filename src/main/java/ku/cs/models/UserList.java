package ku.cs.models;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username, String password) {
        User exist = findUserByUsername(username);
        if (exist == null) {
            // Encrypt the password before storing
            String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
            users.add(new User(username, hashedPassword));
        }
    }

    // TODO: implements this method to change user's password to newPassword by verified oldPassword
    // TODO: return true if process is completed, otherwise return false
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = findUserByUsername(username);
        if (user.validatePassword(oldPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // TODO: implements this method to find user in users with valid password
    // TODO: return User object if username and password is correct, otherwise return null
    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if (user.validatePassword(password)) {
            System.out.println(user.getUsername());
            return user;
        }
        return null;
    }
}