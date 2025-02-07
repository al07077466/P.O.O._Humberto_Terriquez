package edu.humberto.terriquez.actividades.proyecto_final.models;

public class Book {
    private String name;
    private String genre;
    private String author;
    private int stock;

    public Book(String name, String genre, String author, int stock) {
        setName(name);
        setGenre(genre);
        setAuthor(author);
        setStock(stock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Género no puede estar vacío");
        }
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Autor no puede estar vacío");
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