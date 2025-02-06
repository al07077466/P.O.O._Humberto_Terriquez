package edu.humberto.terriquez.actividades.proyecto_final.process;

import edu.humberto.terriquez.actividades.proyecto_final.models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void registerBook(String name, String genre, String author, int stock) {
        Book book = new Book(name, genre, author, stock);
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<String> getBooksInfo() {
        List<String> booksInfo = new ArrayList<>();
        for (Book book : books) {
            booksInfo.add(book.getName() + " - Stock: " + book.getStock());
        }
        return booksInfo;
    }

    public Book getBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }
}