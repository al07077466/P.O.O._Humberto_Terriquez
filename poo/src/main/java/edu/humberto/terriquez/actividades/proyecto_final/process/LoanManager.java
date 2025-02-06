package edu.humberto.terriquez.actividades.proyecto_final.process;

import edu.humberto.terriquez.actividades.proyecto_final.models.Loan;
import edu.humberto.terriquez.actividades.proyecto_final.models.User;
import edu.humberto.terriquez.actividades.proyecto_final.models.Book;
import java.util.ArrayList;
import java.util.List;

public class LoanManager {
    private List<Loan> loans;
    private UserManager userManager;
    private BookManager bookManager;

    public LoanManager(UserManager userManager, BookManager bookManager) {
        this.loans = new ArrayList<>();
        this.userManager = userManager;
        this.bookManager = bookManager;
    }

    public boolean canUserBorrow(String userId) {
        User user = userManager.getUserById(userId);
        return user != null && user.getActiveLoan() < 2;
    }

    public boolean isBookAvailable(String bookName) {
        Book book = bookManager.getBookByName(bookName);
        return book != null && book.getStock() > 0;
    }

    public void requestLoan(String userId, String bookName) {
        User user = userManager.getUserById(userId);
        Book book = bookManager.getBookByName(bookName);
        
        if (user != null && book != null) {
            loans.add(new Loan(userId, bookName));
            user.setActiveLoan(user.getActiveLoan() + 1);
            book.setStock(book.getStock() - 1);
        }
    }

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

    public boolean bookExists(String bookName) {
        return bookManager.getBookByName(bookName) != null;
    }

    public boolean userExists(String userId) {
        return userManager.getUserById(userId) != null;
    }

    public boolean loanExists(String userId, String bookName) {
        for (Loan loan : loans) {
            if (loan.getUserId().equals(userId) && loan.getBookName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    public List<Loan> getLoans() {
        return loans;
    }
}