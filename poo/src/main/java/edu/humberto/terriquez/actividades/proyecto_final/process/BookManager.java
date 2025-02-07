package edu.humberto.terriquez.actividades.proyecto_final.process;

import edu.humberto.terriquez.actividades.proyecto_final.models.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * BookManager es la clase encargada de manejar el area logica del manejo de libros.
 * Esta clase contiene metodos que son invocados en CLI.java, como lo es registrar un libro a
 * la lista, imprimir la lista de libros, imprimir un objeto libro y buscar un objeto tipo libro.
 */
public class BookManager {
    private List<Book> books;

    /**
     * Constructor encargado de inicializar un array books.
     */
    public BookManager() {
        this.books = new ArrayList<>();
    }

    /**
     * Metodo encargado de registrar un objeto tipo libro al array books.
     * Recibe:
     * @param name
     * @param genre
     * @param author
     * @param stock
     */
    public void registerBook(String name, String genre, String author, int stock) {
        Book book = new Book(name, genre, author, stock);
        books.add(book);
    }

    /**
     * Metodo encargado de regesar la lista del array books.
     * Returna:
     * @return books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Metodo encargado de regresar la info de un objeto tipo libro dentro del array books, solo returna name y stock.
     * Returna:
     * @return booksInfo (name & stock)
     */
    public List<String> getBooksInfo() {
        List<String> booksInfo = new ArrayList<>();
        for (Book book : books) {
            booksInfo.add(book.getName() + " - Stock: " + book.getStock());
        }
        return booksInfo;
    }

    /**
     * Metodo encargado de buscar un objeto tipo libro dentro del array books, en base a su parametro name.
     * Returna:
     * @return book (objeto)
     * en caso de no encontrarlo, Returna:
     * @return null
     */
    public Book getBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }
}