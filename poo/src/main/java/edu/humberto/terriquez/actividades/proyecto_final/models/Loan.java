package edu.humberto.terriquez.actividades.proyecto_final.models;

/**
 * Loan es la clase encargada de definir los atributos de para los prestamos de libros de la libreria.
 * Contiene los atributos userID y bookName, incluyendo sus setters y sus getters.
 */
public class Loan {
    private String userId;
    private String bookName;

    /**
     * Constructor encargado de inicializar un prestamo. Recibiendo:
     * @param userId
     * @param bookName
     */
    public Loan(String userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
    }

    /**
     * Getters y setters.
     * Donde los setters, incluyen sus excepciones.
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("ID de usuario no puede ser vacío");
        }
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName == null || bookName.isEmpty()) {
            throw new IllegalArgumentException("Nombre del libro no puede ser vacío");
        }
        this.bookName = bookName;
    }
}