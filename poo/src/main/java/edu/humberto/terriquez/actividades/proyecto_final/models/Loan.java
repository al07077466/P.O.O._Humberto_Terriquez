package edu.humberto.terriquez.actividades.proyecto_final.models;

public class Loan {
    private String userId;
    private String bookName;

    public Loan(String userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
    }

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