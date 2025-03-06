package edu.humberto.terriquez.actividades.proyectofinal.models;

/**
 * Clase que representa un préstamo de un libro
 */
public class Prestamos {
    private String title;
    private String username;
    private String fechaInicio;
    private String fechaFin;
    private String status;
    private String fechaDevolucion;
    /**
     * Constructor de la clase Prestamos que inicializa los atributos de la clase con los valores pasados como argumentos
     * @param title
     * @param username
     * @param fechaInicio
     * @param fechaFin
     * @param status
     */
    public Prestamos(String title, String username, String fechaInicio, String fechaFin, String status) {
        setTitle(title);
        setUsername(username);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setStatus(status);
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getStatus() {
        return status;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
