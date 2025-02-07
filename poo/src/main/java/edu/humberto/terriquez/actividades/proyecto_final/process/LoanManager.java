package edu.humberto.terriquez.actividades.proyecto_final.process;

import edu.humberto.terriquez.actividades.proyecto_final.models.Loan;
import edu.humberto.terriquez.actividades.proyecto_final.models.User;
import edu.humberto.terriquez.actividades.proyecto_final.models.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * LoanManager es la clase encargada de manejar el area logica del manejo de prestamos.
 * Esta clase contiene metodos que son invocados en CLI.java, como lo es validar si un
 * usuario puede pedir un prestamo, si un libro esta disponible, hacer un request de prestamo,
 * regresar un libro, buscar si un libro, usuario o prestamo existen e imprimir los prestamos.
 */
public class LoanManager {
    private List<Loan> loans;
    private UserManager userManager;
    private BookManager bookManager;

    /**
     * Constructor encargado de inicializar un array loans.
     */
    public LoanManager(UserManager userManager, BookManager bookManager) {
        this.loans = new ArrayList<>();
        this.userManager = userManager;
        this.bookManager = bookManager;
    }

    /**
     * Metodo encargado de validar si un objeto tipo user, puede crear un request para un objeto tipo libro.
     * Recibe:
     * @param userId
     */
    public boolean canUserBorrow(String userId) {
        User user = userManager.getUserById(userId);
        return user != null && user.getActiveLoan() < 2;
    }

    /**
     * Metodo encargado de validar si un objeto tipo book esta disponible basado es su stock.
     * Recibe:
     * @param bookName
     */
    public boolean isBookAvailable(String bookName) {
        Book book = bookManager.getBookByName(bookName);
        return book != null && book.getStock() > 0;
    }

    /**
     * Metodo encargado de validar si un usuario puede crear un request de un libro basado en el stock del mismo.
     * Recibe:
     * @param userId
     * @param bookName
     */
    public void requestLoan(String userId, String bookName) {
        User user = userManager.getUserById(userId);
        Book book = bookManager.getBookByName(bookName);
        
        if (user != null && book != null) {
            loans.add(new Loan(userId, bookName));
            user.setActiveLoan(user.getActiveLoan() + 1);
            book.setStock(book.getStock() - 1);
        }
    }

    /**
     * Metodo encargado de validar si un prestamo puede ser regresado y en caso de pasar la
     * validacion, permitir los cambios a un objeto loan y a un objeto book (solo stock).
     * Recibe:
     * @param userId
     * @param bookName
     */
    public void returnLoan(String userId, String bookName) {
        Loan loanToRemove = null;
        for (Loan loan : loans) {
            if (loan.getUserId().equals(userId) && loan.getBookName().equals(bookName)) {
                loanToRemove = loan;
                break;
            }
        }
        if (loanToRemove != null) {
           loans.remove(loanToRemove);
            User user = userManager.getUserById(userId);
            Book book = bookManager.getBookByName(bookName);
        
            if (user != null) user.setActiveLoan(user.getActiveLoan() - 1);
            if (book != null) book.setStock(book.getStock() + 1);
        }
    }

    /**
     * Metodo encargado de validar si un objeto book existe, basado en su parametro name.
     * Recibe:
     * @param bookName
     */
    public boolean bookExists(String bookName) {
        return bookManager.getBookByName(bookName) != null;
    }

    /**
     * Metodo encargado de validar si un objeto user existe, basado en su parametro id.
     * Recibe:
     * @param userId
     */
    public boolean userExists(String userId) {
        return userManager.getUserById(userId) != null;
    }

    /**
     * Metodo encargado de validar si un objeto tipo loan existe, basado en un objeto user y un objeto name.
     * Recibe:
     * @param userId
     * @param bookName
     */
    public boolean loanExists(String userId, String bookName) {
        for (Loan loan : loans) {
            if (loan.getUserId().equals(userId) && loan.getBookName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo encargado de imprimir el array de tipo loan.
     */
    public List<Loan> getLoans() {
        return loans;
    }
}