package edu.humberto.terriquez.actividades.proyecto_final.process;

import edu.humberto.terriquez.actividades.proyecto_final.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String id, String password, String name, int age, String type) {
        User user = new User(id, password, name, age, type);
        users.add(user);
    }

    public boolean validateCredentials(String id, String password) {
        User user = getUserById(id);
        return user != null && user.getPassword().equals(password);
    }

    public String getUserType(String id) {
        User user = getUserById(id);
        return (user != null) ? user.getType() : null;
    }

    public String getUserName(String id) {
        User user = getUserById(id);
        return (user != null) ? user.getName() : null;
    }

    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}