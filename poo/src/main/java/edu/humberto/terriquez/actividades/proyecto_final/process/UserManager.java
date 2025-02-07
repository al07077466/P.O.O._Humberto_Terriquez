package edu.humberto.terriquez.actividades.proyecto_final.process;

import edu.humberto.terriquez.actividades.proyecto_final.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 * UserManager es la clase encargada de manejar el area logica del manejo de usuarios.
 * Esta clase contiene metodos que son invocados en CLI.java, como lo es registrar
 * un usuario, validar su contrasena, determinar si un usuario es tipo user o librarian,
 * encontrar un usuario por su nombre y encontrar un usario por su id.
 */
public class UserManager {
    private List<User> users;

    /**
     * Constructor encargado de inicializar un array users.
     */
    public UserManager() {
        this.users = new ArrayList<>();
    }

    /**
     * Metodo encargado de registrar un objeto tipo user al array users.
     * Recibe:
     * @param id
     * @param password
     * @param name
     * @param age
     * @param type
     */
    public void registerUser(String id, String password, String name, int age, String type) {
        User user = new User(id, password, name, age, type);
        users.add(user);
    }

    /**
     * Metodo encargado de validar si el parametro password de un objeto tipo user, hace match con su name.
     * Recibe:
     * @param name
     * @param password
     */
    public boolean validateCredentials(String name, String password) {
        User user = getUserByName(name);
        return user != null && user.getPassword().equals(password);
    }

    /**
     * Metodo encargado de validar el tipo de usuario en base a su id.
     * Recibe:
     * @param id
     */
    public String getUserType(String id) {
        User user = getUserById(id);
        return (user != null) ? user.getType() : null;
    }

    /**
     * Metodo encargado de imprimir un objeto user en base a su parametro id.
     * Recibe:
     * @param id
     */
    public String getUserName(String id) {
        User user = getUserById(id);
        return (user != null) ? user.getName() : null;
    }

    /**
     * Metodo encargado de encontrar un objeto user en base a su parametro id.
     * Recibe:
     * @param id
     */
    public User getUserById(String id) {
        for (User user : users) {
            if (user.getName().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Metodo encargado de encontrar un objeto user en base a su parametro name.
     * Recibe:
     * @param name
     */
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}