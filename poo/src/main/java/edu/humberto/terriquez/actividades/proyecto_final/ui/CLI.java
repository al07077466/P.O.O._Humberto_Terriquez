package edu.humberto.terriquez.actividades.proyecto_final.ui;

import edu.humberto.terriquez.actividades.proyecto_final.models.Loan;
import edu.humberto.terriquez.actividades.proyecto_final.process.UserManager;
import edu.humberto.terriquez.actividades.proyecto_final.process.BookManager;
import edu.humberto.terriquez.actividades.proyecto_final.process.LoanManager;
import java.util.Scanner;

public class CLI {
    private UserManager userManager;
    private BookManager bookManager;
    private LoanManager loanManager;
    private Scanner scanner;

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
        while (true) {
            System.out.println("Bienvenido a la biblioteca TeamTree!");
            System.out.println("Haz Log-in para ingresar.");
            System.out.print("Usuario: ");
            String userId = scanner.nextLine();
            System.out.print("Ingresa tu contraseña: ");
            String password = scanner.nextLine();

            if (userManager.validateCredentials(userId, password)) {
                String userType = userManager.getUserType(userId);
                String userName = userManager.getUserName(userId);

                if (userType.equals("user")) {
                    userMenu(userId);
                } else if (userType.equals("librarian")) {
                    librarianMenu();
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }
    }

    private void userMenu(String userId) {
        while (true) {
            System.out.println("Menú principal");
            System.out.println("Bienvenido " + userManager.getUserName(userId) + "!");
            System.out.println("1 - Registros");
            System.out.println("2 - Consultas");
            System.out.println("3 - Salir");
            System.out.print("Elige una opción: ");
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                System.out.println("1 - Pedir prestado un libro");
                System.out.println("2 - Regresar un libro");
                System.out.print("Elige una opción: ");
                int subOption = Integer.parseInt(scanner.nextLine());

                if (subOption == 1) {
                    System.out.print("Ingresa el nombre del libro: ");
                    String bookName = scanner.nextLine();
                    if (loanManager.canUserBorrow(userId)) {
                        loanManager.requestLoan(userId, bookName);
                        System.out.println("Préstamo registrado exitosamente.");
                    } else {
                        System.out.println("No puedes pedir más libros.");
                    }
                } else if (subOption == 2) {
                    System.out.print("Ingresa el nombre del libro: ");
                    String bookName = scanner.nextLine();
                    loanManager.returnLoan(userId, bookName);
                    System.out.println("Libro devuelto exitosamente.");
                }
            } else if (option == 2) {
                for (String bookInfo : bookManager.getBooksInfo()) {
                    System.out.println(bookInfo);
                }
                System.out.print("Escribe el nombre del libro o 'back' para regresar: ");
                String bookName = scanner.nextLine();
                if (bookName.equals("back")) {
                    continue;
                }
                if (bookManager.getBookByName(bookName) != null) {
                    System.out.println("Libro encontrado.");
                } else {
                    System.out.println("Libro no encontrado.");
                }
            } else if (option == 3) {
                break;
            }
        }
    }

    private void librarianMenu() {
        while (true) {
            System.out.println("Menú principal");
            System.out.println("Bienvenido " + userManager.getUserName("00000000") + "!");
            System.out.println("1 - Registrar Libros");
            System.out.println("2 - Registrar Usuarios");
            System.out.println("3 - Registrar Préstamo");
            System.out.println("4 - Regresar Préstamo");
            System.out.println("5 - Consultas");
            System.out.println("6 - Salir");
            System.out.print("Elige una opción: ");
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                System.out.print("Nombre del libro: ");
                String name = scanner.nextLine();
                System.out.print("Género: ");
                String genre = scanner.nextLine();
                System.out.print("Autor: ");
                String author = scanner.nextLine();
                System.out.print("Stock: ");
                int stock = Integer.parseInt(scanner.nextLine());
                bookManager.registerBook(name, genre, author, stock);
                System.out.println("Libro registrado exitosamente.");
            } else if (option == 2) {
                System.out.print("ID del usuario: ");
                String id = scanner.nextLine();
                System.out.print("Contraseña: ");
                String password = scanner.nextLine();
                System.out.print("Nombre: ");
                String name = scanner.nextLine();
                System.out.print("Edad: ");
                int age = Integer.parseInt(scanner.nextLine());
                userManager.registerUser(id, password, name, age, "user");
                System.out.println("Usuario registrado exitosamente.");
            } else if (option == 3) {
                System.out.print("ID del usuario: ");
                String userId = scanner.nextLine();
                System.out.print("Nombre del libro: ");
                String bookName = scanner.nextLine();
                loanManager.requestLoan(userId, bookName);
                System.out.println("Préstamo registrado exitosamente.");
            } else if (option == 4) {
                System.out.print("ID del usuario: ");
                String userId = scanner.nextLine();
                System.out.print("Nombre del libro: ");
                String bookName = scanner.nextLine();
                loanManager.returnLoan(userId, bookName);
                System.out.println("Préstamo devuelto exitosamente.");
            } else if (option == 5) {
                System.out.println("1 - Ver solicitudes de préstamo");
                System.out.println("2 - Consultar libros");
                System.out.println("3 - Regresar al menú principal");
                System.out.print("Elige una opción: ");
                int subOption = Integer.parseInt(scanner.nextLine());

                if (subOption == 1) {
                    for (Loan loan : loanManager.getLoans()) {
                        System.out.println("Usuario: " + loan.getUserId() + " - Libro: " + loan.getBookName());
                    }
                } else if (subOption == 2) {
                    for (String bookInfo : bookManager.getBooksInfo()) {
                        System.out.println(bookInfo);
                    }
                }
            } else if (option == 6) {
                break;
            }
        }
    }
}