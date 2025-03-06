package edu.humberto.terriquez.actividades.proyectofinal.models;

/**
 * Clase que se encarga de gestionar los usuarios del sistema
 */
public class Users {

    private String username;
    private String password;
    private int age;
    private String name;
    private String tipo;
    private int vencimientos;
    private int entregados;
    /**
     * Constructor de la clase Users que inicializa los atributos de la clase con los valores pasados como argumentos
     * @param username
     * @param password
     * @param age
     * @param name
     * @param tipo
     * @param entregados
     * @param vencimientos
     */
    public Users(String username, String password, int age, String name, String tipo, int entregados, int vencimientos) {
        setUsername(username);
        setPassword(password);
        setAge(age); 
        setName(name);
        setTipo(tipo);
        setEntregados(entregados);
        setVencimientos(vencimientos);
        
    }

    public int getVencimientos() {
        return vencimientos;
    }

    public int getEntregados() {
        return entregados;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
    
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setTipo(String tipo) {
        
        this.tipo = tipo;
    }

    public void setVencimientos(int vencimientos) {
        this.vencimientos = vencimientos;
    }

    public void setEntregados(int entregados) {
        this.entregados = entregados;
    }
}
