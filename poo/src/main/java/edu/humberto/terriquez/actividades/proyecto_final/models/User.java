package edu.humberto.terriquez.actividades.proyecto_final.models;

/**
 * User es la clase encargada de definir los atributos para los usuarios de una libreria.
 * Contiene los atributos id, password, name, age, type, activeLoan y pastLoan, incluyendo sus setters y sus getters.
 */
public class User {
    private String id;
    private String password;
    private String name;
    private int age;
    private String type;
    private int activeLoan;
    private int pastLoan;

    /**
     * Constructor encargado de inicializar un usuario. Recibiendo:
     * @param id
     * @param password
     * @param name
     * @param age
     * @param type
     * @param activeLoan
     * @param pastLoan
     */
    public User(String id, String password, String name, int age, String type) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.type = type;
        this.activeLoan = 0;
        this.pastLoan = 0;
    }

    /**
     * Getters y setters.
     * Donde los setters, incluyen sus excepciones.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID no puede ser vacío");
        }
        if (!id.matches("\\d{8}")) {
            throw new IllegalArgumentException("ID debe tener 8 números exactamente");
        }
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Contraseña no puede ser vacía");
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser vacío");
        }
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Nombre no puede contener números");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa");
        }
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!type.equals("user") && !type.equals("librarian")) {
            throw new IllegalArgumentException("Tipo debe ser 'user' o 'librarian'");
        }
        this.type = type;
    }

    public int getActiveLoan() {
        return activeLoan;
    }

    public void setActiveLoan(int activeLoan) {
        if (activeLoan < 0) {
            throw new IllegalArgumentException("Préstamos activos no pueden ser negativos");
        }
        this.activeLoan = activeLoan;
    }

    public int getPastLoan() {
        return pastLoan;
    }

    public void setPastLoan(int pastLoan) {
        if (pastLoan < 0) {
            throw new IllegalArgumentException("Préstamos pasados no pueden ser negativos");
        }
        this.pastLoan = pastLoan;
    }
}