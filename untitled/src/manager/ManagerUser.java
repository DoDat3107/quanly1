package manager;

import View.User;

import java.util.ArrayList;

public class ManagerUser {
    private ArrayList<User> users = new ArrayList<>();


    public boolean register(String username, String password) {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        users.add(new User(username, password));
        return true;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public ArrayList<User> getAllUsers() {
        return users;
    }
}
