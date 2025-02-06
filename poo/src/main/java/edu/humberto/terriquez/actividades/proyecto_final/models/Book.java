package edu.humberto.terriquez.actividades.proyecto_final.models;

public class Book {
    private String name;
    private String genre;
    private String author;
    private int stock;

    public Book(String name, String genre, String author, int stock) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser vacío");
        }
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Género no puede ser vacío");
        }
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Autor no puede ser vacío");
        }
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock no puede ser negativo");
        }
        this.stock = stock;
    }
}