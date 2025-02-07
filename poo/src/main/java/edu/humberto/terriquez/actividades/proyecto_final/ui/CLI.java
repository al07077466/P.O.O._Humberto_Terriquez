package edu.humberto.terriquez.actividades.proyecto_final.ui;

import edu.humberto.terriquez.actividades.proyecto_final.models.Loan;
import edu.humberto.terriquez.actividades.proyecto_final.process.UserManager;
import edu.humberto.terriquez.actividades.proyecto_final.process.BookManager;
import edu.humberto.terriquez.actividades.proyecto_final.process.LoanManager;
import edu.humberto.terriquez.actividades.proyecto_final.ui.Languages.Lang;
import edu.humberto.terriquez.actividades.proyecto_final.ui.Languages.Esp;
import edu.humberto.terriquez.actividades.proyecto_final.ui.Languages.Eng;
import java.util.Scanner;

public class CLI {
    private UserManager userManager;
    private BookManager bookManager;
    private LoanManager loanManager;
    private Scanner scanner;
    private Lang lang;

    public CLI() {
        this.userManager = new UserManager();
        this.bookManager = new BookManager();
        this.loanManager = new LoanManager(userManager, bookManager);
        this.scanner = new Scanner(System.in);

        // test users, delete later
        userManager.registerUser("00000000", "test", "librariantest", 21, "librarian");
        userManager.registerUser("00000001", "test", "usertest", 21, "user");
    }

    public void runApp() {
        System.out.println("Select a Language:");
        System.out.println("1 - Español");
        System.out.println("2 - English");
        System.out.print("Choose an option: ");
        int languageOption = Integer.parseInt(scanner.nextLine());

        if (languageOption == 1) {
            lang = new Esp();
        } else if (languageOption == 2) {
            lang = new Eng();
        } else {
            System.out.println("Invalid option. Defaulting to Español.");
            lang = new Esp();
        }
        
        while (true) {
            System.out.println(lang.getFirstWelcomeText());
            System.out.println(lang.getLogInRequestText());
            System.out.print(lang.getUserRequestText());
            String userId = scanner.nextLine();
            System.out.print(lang.getPasswordRequestText());
            String password = scanner.nextLine();

            if (userManager.validateCredentials(userId, password)) {
                String userType = userManager.getUserType(userId);

                if (userType.equals("user")) {
                    userMenu(userId);
                } else if (userType.equals("librarian")) {
                    librarianMenu(userId);
                }
            } else {
                System.out.println(lang.getLogInErrorText());
            }
        }
    }

    private void userMenu(String userId) {
        while (true) {
            System.out.println(lang.getMainMenuText());
            System.out.println(lang.getWelcomeText() + userManager.getUserName(userId) + lang.getExclamationMarkText());
            System.out.println(lang.getOptionOneRegistryText());
            System.out.println(lang.getOptionTwoConsultText());
            System.out.println(lang.getOptionThreeExit());
            System.out.print(lang.getChooseAnOptionText());
            int option = Integer.parseInt(scanner.nextLine());
    
            switch (option) {
                case 1:
                    System.out.println(lang.getOptionOneRequestBookText());
                    System.out.println(lang.getOptionTwoReturnBookText());
                    System.out.print(lang.getChooseAnOptionText());
                    int subOption = Integer.parseInt(scanner.nextLine());
                    
                    switch (subOption) {
                        case 1:
                            System.out.print(lang.getEnterBookNameText());
                            String bookNameBorrow = scanner.nextLine();
                    
                            if (!loanManager.bookExists(bookNameBorrow)) {
                                System.out.println(lang.getBookDontExistErrorText());
                                break;
                            }
                            if (!loanManager.isBookAvailable(bookNameBorrow)) {
                                System.out.println(lang.getNotEnoughStockErrorText());
                                break;
                            }
                            if (!loanManager.canUserBorrow(userId)) {
                                System.out.println(lang.getMaxLoansReachedErrorText());
                                break;
                            }
                    
                            loanManager.requestLoan(userId, bookNameBorrow);
                            System.out.println(lang.getBookLoanRequestedText());
                            break;
                        case 2:
                            System.out.println(lang.getReachLibrarianForRequestText());
                            break;
                    }
                    break;
                case 2:
                    for (String bookInfo : bookManager.getBooksInfo()) {
                        System.out.println(bookInfo);
                    }
                    System.out.print(lang.getEnterBookNameText());
                    String bookName = scanner.nextLine();
                    if (!bookName.equals("back")) {
                        if (bookManager.getBookByName(bookName) != null) {
                            System.out.println(lang.getBookFoundText());
                        } else {
                            System.out.println(lang.getBookNotFoundErrorText());
                        }
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println(lang.getInvalidOptionErrorText());
            }
        }
    }

    private void librarianMenu(String userId) {
        while (true) {
            System.out.println(lang.getMainMenuText());
            System.out.println(lang.getWelcomeText() + userManager.getUserName(userId) + lang.getExclamationMarkText());
            System.out.println(lang.getOptionOneRegisterBookText());
            System.out.println(lang.getOptionTwoRegisterUserText());
            System.out.println(lang.getOptionThreeRegisterLoanText());
            System.out.println(lang.getOptionFourReturnBookText());
            System.out.println(lang.getOptionFiveQueriesText());
            System.out.println(lang.getOptionSixExitText());
            System.out.print(lang.getChooseAnOptionText());
            int option = Integer.parseInt(scanner.nextLine());
    
            switch (option) {
                case 1:
                    try {
                        System.out.print(lang.getEnterBookNameText());
                        String name = scanner.nextLine();
                        System.out.print(lang.getEnterBookGenreText());
                        String genre = scanner.nextLine();
                        System.out.print(lang.getEnterBookAuthorText());
                        String author = scanner.nextLine();
                        System.out.print(lang.getEnterBookStockText());
                        int stock = Integer.parseInt(scanner.nextLine());
                        bookManager.registerBook(name, genre, author, stock);
                        System.out.println(lang.getBookAddedSuccessText());
                    } catch (NumberFormatException e) {
                        System.out.println(lang.getErrorEqualsErrorText() + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println(lang.getErrorEqualsErrorText() + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print(lang.getEnterUserIDText());
                    String id = scanner.nextLine();
                    System.out.print(lang.getEnterUserPasswordText());
                    String password = scanner.nextLine();
                    System.out.print(lang.getEnterUserNameText());
                    String userName = scanner.nextLine();
                    System.out.print(lang.getEnterUserAgeText());
                    int age = Integer.parseInt(scanner.nextLine());
                    userManager.registerUser(id, password, userName, age, "user");
                    System.out.println(lang.getUserRegisteredSuccessText());
                    break;
                case 3:
                    System.out.print(lang.getEnterUserIDText());
                    String userIdLoan = scanner.nextLine();
                    System.out.print(lang.getEnterBookNameText());
                    String bookNameLoan = scanner.nextLine();
                
                    if (!loanManager.userExists(userIdLoan)) {
                        System.out.println(lang.getUserNotFoundErrorText());
                        break;
                    }
                    if (!loanManager.bookExists(bookNameLoan)) {
                        System.out.println(lang.getBookNotRegisteredErrorText());
                        break;
                    }
                    if (!loanManager.isBookAvailable(bookNameLoan)) {
                        System.out.println(lang.getNoStockLeftErrorText());
                        break;
                    }
                    if (!loanManager.canUserBorrow(userIdLoan)) {
                        System.out.println(lang.getMaxLoansReachedErrorText());
                        break;
                    }
                
                    loanManager.requestLoan(userIdLoan, bookNameLoan);
                    System.out.println(lang.getLoanRegisteredSucessText());
                    break;
                case 4:
                    System.out.print(lang.getEnterUserIDText());
                    String userIdReturn = scanner.nextLine();
                    System.out.print(lang.getEnterBookNameText());
                    String bookNameReturn = scanner.nextLine();
                
                    if (!loanManager.userExists(userIdReturn)) {
                        System.out.println(lang.getUserNotFoundErrorText());
                        break;
                    }
                    if (!loanManager.bookExists(bookNameReturn)) {
                        System.out.println(lang.getBookNotRegisteredErrorText());
                        break;
                    }
                    if (!loanManager.loanExists(userIdReturn, bookNameReturn)) {
                        System.out.println(lang.getUserDoesntHaveThisBookErrorText());
                        break;
                    }
                
                    loanManager.returnLoan(userIdReturn, bookNameReturn);
                    System.out.println(lang.getBookReturnRegisteredSuccessText());
                    break;
                case 5:
                    System.out.println(lang.getOptionOneViewLoanRequestsText());
                    System.out.println(lang.getOptionTwoConsultText());
                    System.out.println(lang.getOptionThreeReturnToMainMenuText());
                    System.out.print(lang.getChooseAnOptionText());
                    int subOption = Integer.parseInt(scanner.nextLine());
                    
                    switch (subOption) {
                        case 1:
                            for (Loan loan : loanManager.getLoans()) {
                                System.out.println(lang.getUserEqualsText() + loan.getUserId() + lang.getBookEqualsText() + loan.getBookName());
                            }
                            break;
                        case 2:
                            for (String bookInfo : bookManager.getBooksInfo()) {
                                System.out.println(bookInfo);
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println(lang.getInvalidOptionErrorText());
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println(lang.getInvalidOptionErrorText());
            }
        }
    }
}