package edu.humberto.terriquez.actividades.proyectofinal.ui;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import edu.humberto.terriquez.actividades.proyectofinal.lang.Eng;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Esp;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Jap;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Lang;
import edu.humberto.terriquez.actividades.proyectofinal.models.Users;
import edu.humberto.terriquez.actividades.proyectofinal.process.Bibliotecario;
import edu.humberto.terriquez.actividades.proyectofinal.utils.Colores;

/**    
 * Esta clase es la encargada de manejar la interfaz de usuario de la aplicación   
 */
public class CLI {
    static Bibliotecario bibliotecario = new Bibliotecario();
    static Lang lang =new Lang();
    static String usernameLogged;
    
        /**
         * Método que se encarga de asignar el lenguaje con el que el usuario quiere correr la aplicación
         */
        public static void selectLang(){
            cleanScreen();
            Locale systemLocale = Locale.getDefault();
            lang =new Esp();
            Scanner scanner=new Scanner(System.in);
            int opcion=-1;
            while (opcion!=3) {
                System.out.println(Colores.cyan+"\n╔══════════════════════════════════════════════╗\n║ El idioma actual de tu ordenador es: "+ systemLocale + "   ║\n║      ¿Te gustaría cambiar el idioma?         ║\n╠══════════════════════════════════════════════╣\n║                  1. Español                  ║\n║                  2. Ingles                   ║\n║                  3. Japones                  ║\n╚══════════════════════════════════════════════╝"+Colores.reset);
                while (true) {
                    System.out.print(Colores.blue+lang.select_an_option+Colores.reset);
                    String input = scanner.nextLine().trim(); 
                    if (input.isEmpty()) {
                        System.out.println(Colores.red+ lang.invalid_input_empty+Colores.reset);
                        continue;
                    }
        
                    try {
                        opcion = Integer.parseInt(input);
                        if (opcion < 1 || opcion > 3) {
                            System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                            System.out.println(Colores.cyan+"\n╔══════════════════════════════════════════════╗\n║ El idioma actual de tu ordenador es: "+ systemLocale + "   ║\n║      ¿Te gustaría cambiar el idioma?         ║\n╠══════════════════════════════════════════════╣\n║                  1. Español                  ║\n║                  2. Ingles                   ║\n║                  3. Japones                  ║\n╚══════════════════════════════════════════════╝"+Colores.reset);
                        } else {
                            break; 
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                        System.out.println(Colores.cyan+"\n╔══════════════════════════════════════════════╗\n║ El idioma actual de tu ordenador es: "+ systemLocale + "   ║\n║      ¿Te gustaría cambiar el idioma?         ║\n╠══════════════════════════════════════════════╣\n║                  1. Español                  ║\n║                  2. Ingles                   ║\n║                  3. Japones                  ║\n╚══════════════════════════════════════════════╝"+Colores.reset);
                    }
                }
                switch (opcion) {
                    case 1:
                        try {
                        new ProcessBuilder("cmd", "/c", "chcp 65001").inheritIO().start().waitFor();
                        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        cleanScreen();
                        lang= new Esp();
                        break;
    
                    case 2:
                        cleanScreen();
                        lang= new Eng();
                        break;
                    case 3:
                        try {
                        new ProcessBuilder("cmd", "/c", "chcp 65001").inheritIO().start().waitFor();
                        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        cleanScreen();
                        lang= new Jap();
                        break;
                }
                break;
            }
            
        }
        /**
         * Método que se encarga de génerar una barra de carga dentro de la terminal
         */        
        public static void showLoadingBar() {
            final int total = 50; 
            String bar = "";
            System.out.println();
            for (int i = 0; i <= total; i++) {
                int progress = (i * 100) / total;
                bar = "[" + "|".repeat(i) + " ".repeat(total - i) + "]";
                if (progress < 40) {
                    System.out.print("\u001B[31m"+(bar) + " " + progress + "%\r"+"\u001B[0m");
                } else if (progress < 80) {
                    System.out.print("\u001B[33m"+(bar) + " " + progress + "%\r"+"\u001B[0m");
                } else {
                    System.out.print("\u001B[32m"+(bar) + " " + progress + "%\r"+"\u001B[0m");
                }
        
                try {
                    Thread.sleep(60); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(); 
        }
        /**
         * Método que se encarga de correr la aplicación
         */
        public static void runApp() {
                showLoadingBar();
                cleanScreen();
                bibliotecario.setLang(lang);
                Scanner scanner = new Scanner(System.in);
                int opcion = -1; 
                while (opcion !=3) {
                    showMenu();
                    while (true) {
                        System.out.print(Colores.light_blue+lang.select_an_option+Colores.reset);
                        String input = scanner.nextLine().trim(); 
            
                        if (input.isEmpty()) {
                            System.out.println(Colores.red+lang.invalid_input_empty+Colores.reset);
                            showMenu();
                            continue;
                        }
            
                        try {
                            opcion = Integer.parseInt(input);
                            if (opcion < 1 || opcion > 3) {
                                System.out.println(Colores.red+lang.invalid_option+Colores.reset);
    
                                showMenu();
                            } else {
                                break; 
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                            
                            showMenu();
                        }
                    }
                    switch (opcion) {
                        /**
                         * Opción para registrar un nuevo usuario en la aplicación
                         */
                        case 1:
                            System.out.println(Colores.purple+lang.register_user+Colores.reset);
    
                            String user;
                            while (true) {
                                System.out.print(Colores.pink+lang.username+Colores.reset);
                                user = scanner.nextLine().trim();
                                if (user.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_new_username+Colores.reset);
    
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.register_password+Colores.reset);
    
                            String password;
                            while (true) {
                                System.out.print(Colores.pink+lang.password+Colores.reset);
                                password = scanner.nextLine().trim();
                                if (password.isEmpty()) {          
                                    System.out.println(Colores.red+lang.invalid_new_password+Colores.reset);
    
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.enter_age+Colores.reset);
                            int age;
                            while (true) {
                                try {
                                    System.out.print(Colores.pink+lang.age+Colores.reset);
                                    age = Integer.parseInt(scanner.nextLine());
                                    if (age < 0) {
                                        throw new IllegalArgumentException(Colores.red+lang.age_negative+Colores.reset);
                                    }
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println(Colores.red+lang.error_valid_number+Colores.reset);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            System.out.println(Colores.purple+lang.error_real_name+Colores.reset);
                            String name;
                            while (true) {
                                System.out.print(Colores.pink+lang.name_with_colon+Colores.reset);
                                name = scanner.nextLine().trim();
                                if (name.isEmpty()) {
                                    System.out.println(Colores.red+lang.error_valid_name+Colores.reset);
                                } else {
                                    break;
                                }
                            }
                            bibliotecario.addUser(user, password, age, name);
                            System.out.println(Colores.green+lang.registration_success+Colores.reset);
                            usernameLogged = user;
                            if (bibliotecario.getUsers().get(user).getTipo().equals("Usuario VIP")) {
                                cleanScreen();
                                userMenuVip();
                            } else if (bibliotecario.getUsers().get(user).getTipo().equals("Usuario JR")) {
                                cleanScreen();
                                userMenuJr();
                            } else if (bibliotecario.getUsers().get(user).getTipo().equals("Usuario teens")) {
                                cleanScreen();
                                userMenuTeens();
                            } else{
                                cleanScreen();
                                userMenu();
                            }
                            break;
                        /**
                        * Opción para iniciar sesión en la aplicación
                        * @return void
                        */
                        case 2:
                            System.out.println(Colores.purple+lang.username_prompt+Colores.reset);
                            String registerUser;
                            while (true) {
                                System.out.print(Colores.pink+lang.username+Colores.reset);
                                registerUser = scanner.nextLine().trim();
                                if (registerUser.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_new_username+Colores.reset);
    
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.password_prompt+Colores.reset);
                            String registerPassword;
                            while (true) {
                                System.out.print(Colores.pink+lang.password+Colores.reset);
                                registerPassword = scanner.nextLine().trim();
                                if (registerPassword.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_new_password+Colores.reset);
                                } else {
                                    break;
                                }
                            }
                            if (bibliotecario.validateUserLoggin(registerUser, registerPassword)) {
                                if (registerUser.equals("admin")) {
                                    System.out.println(Colores.light_green+lang.welcome_admin+Colores.reset);
                                    showLoadingBar();
                                    cleanScreen();
                                    adminMenu();
                                } else {
                                    System.out.println(Colores.violet+lang.welcome_user + registerUser + lang.welcome_user_format+Colores.reset);
                                    usernameLogged = registerUser;


                                    if (bibliotecario.getUsers().get(registerUser).getTipo().equals("Usuario VIP")) {
                                        showLoadingBar();
                                        cleanScreen();
                                        userMenuVip();
                                    } else if (bibliotecario.getUsers().get(registerUser).getTipo().equals("Usuario JR")) {
                                        showLoadingBar();
                                        cleanScreen();
                                        userMenuJr();
                                    } else if (bibliotecario.getUsers().get(registerUser).getTipo().equals("Usuario teens")) {
                                        showLoadingBar();
                                        cleanScreen();
                                        userMenuTeens();
                                    } else{
                                        showLoadingBar();
                                        cleanScreen();
                                        userMenu();
                                    }
                                    
                                }
                            } else {
                                System.out.println(Colores.red+lang.invalid_credentials+Colores.reset);
                            }
                            break;
                        /**
                        * Opción para salir de la aplicación
                        * @return void
                        */
                        case 3:
                        cleanScreen();
                        System.out.println(Colores.brown+lang.goodbye+Colores.reset);
                        break;
                }
            }
        }
        /**
         * Metodo que se encarga de limpiar la consola
         */
        public static void cleanScreen(){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        /**
        * Método que se encarga de mostrar la información de un usuario
        * @param user
        * @return void
        */
        public static void showUser(Users user){
            System.out.println(Colores.light_green+"╔═══════════════════╗\n"+lang.user_showuser+user.getUsername()+"\n"+lang.password_showuser+user.getPassword()+"\n"+lang.edad_showuser+user.getAge()+"\n"+lang.name_showuser+user.getName()+"\n"+lang.user_type_showuser+user.getTipo()+"\n╚═══════════════════╝"+Colores.reset);
        }
    
        /**
        * Método que se encarga de mostrar el menú principal de la aplicación
        * @return void
        */
        public static void showMenu(){
            cleanScreen();
            System.out.println(lang.menu_login+Colores.reset);
        }
        /**
         * Método que se encarga de mostrar el menú de usuario Jr
         * @return void
         */
        public static void showMenuJr(){
            System.out.println(Colores.orange+lang.jr_menu+Colores.reset);
        }
        /**
         * Método que se encarga de mostrar el menú de usuario Teen
         * @return void
         */
        public static void showMenuTeens(){
            System.out.println(Colores.dark_gray+lang.teens_menu+Colores.reset);
        }
        /**
         * Método que se encarga de mostrar el menú de usuario VIP
         * @return void
         */

        public static void showMenuVip(){
            System.out.println(Colores.gold+lang.vip_menu+Colores.reset);
        }
        /**
         * Método que se encarga de mostrar el menú de administrador avanzado, es decir, los registros del sistema
         * @return void
         */
        public static void showAdminMenuAdvance(){          
        System.out.println(Colores.blue+lang.menu_admin_advance+Colores.reset);
        }
        
            /**
             * Método que se encarga de mostrar el menú de administrador
             * @return void
             */  
        public static void adminMenu(){
                Scanner scanner = new Scanner(System.in);
                int option = -1;
                while (option != 5) {
                    
                    System.out.println(lang.menu_admin+Colores.reset);
                    System.out.print(Colores.light_blue+lang.select_an_option+Colores.reset);
                    String userInput = scanner.nextLine().trim();
        
                    try {
                        option = Integer.parseInt(userInput);
                        if (option < 1 || option > 5) {
                            System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                        continue;
                    }
        
                    switch (option) {
                        /**
                         * Opción para registrar un nuevo libro en el catálogo
                         * @return void
                         */
                        case 1:
                            System.out.println(Colores.purple+lang.enter_book_title_prompt+Colores.reset);
                            String title;
                            while (true) {
                                System.out.print(Colores.pink+lang.title+Colores.reset);
                                title = scanner.nextLine().trim();
                                if (title.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_title+Colores.reset);
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.enter_book_author_prompt+Colores.reset);
                            String author;
                            while (true) {
                                System.out.print(Colores.pink+lang.author+Colores.reset);
                                author = scanner.nextLine().trim();
                                if (author.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_author+Colores.reset);
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.enter_book_isbn_prompt+Colores.reset);
                            String isbn;
                            while (true) {
                                System.out.print(Colores.pink+lang.isbn+Colores.reset);
                                isbn = scanner.nextLine().trim();
                                if (isbn.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_isbn+Colores.reset);
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.enter_book_genre_prompt+Colores.reset);
                            String genre;
                            while (true) {
                                System.out.print(Colores.pink+lang.genre+Colores.reset);
                                genre = scanner.nextLine().trim();
                                if (genre.isEmpty()) {
                                    System.out.println(Colores.red+lang.invalid_genre+Colores.reset);
                                } else {
                                    break;
                                }
                            }
                            System.out.println(Colores.purple+lang.enter_book_year_prompt+Colores.reset);
                            int year = -1;
                            while (true) {
                                try {
                                    System.out.print(Colores.pink+lang.year_book+Colores.reset);
                                    year = Integer.parseInt(scanner.nextLine());
    
                                    if (year < 0) {
                                        throw new IllegalArgumentException(Colores.red+lang.year_of_publication_negative_error+Colores.reset);
                                    } 
                                    if (year > 2025) {
                                        throw new IllegalArgumentException(Colores.red+lang.year_of_publication_future_error+Colores.reset);
                                    }
                                    break; 
    
                                } catch (NumberFormatException e) {
                                    System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage() );
                                }
                            }
                            
                            System.out.println(Colores.dark_green+lang.book_entry_success+Colores.reset);
                            boolean available = true;
                            if (bibliotecario.getBooks().containsKey(isbn)) {
                                System.out.println(Colores.red+"El libro no se puede agregar porque tiene el mismo código único"+Colores.reset);
                                break;
                            }else{
                                bibliotecario.addBook(title, author, isbn, available, year, genre);
                                System.out.println(Colores.dark_gray+lang.book_added+Colores.reset);
                            }
                            
                            break;
                            /**
                             * Opción para actualizar los préstamos del sistema
                             * @return void
                             */
                        case 2:
                            bibliotecario.actualizarPrestamos();
                            bibliotecario.addPrestamoVencido();
                            System.out.println(Colores.green+lang.update_loans+Colores.reset);
                            break;
                            /**
                             * Opción para mostrar los préstamos activos en la biblioteca
                             * @return void
                             */
                        case 3:
                            bibliotecario.mostrarPrestamosActivosAdministrador();
                            break;
                            /**
                             * Opción para mostrar los registros del administrador de la biblioteca
                             * @return void
                             */
                        case 4:
                            adminAdvanceMenu();                       
                            break;
                        /**
                        * Opción para salir del menú de administrador
                        * @return void
                        */
                        case 5:
                            System.out.println(Colores.brown+lang.exit_admin+Colores.reset);
                            showLoadingBar();
                            cleanScreen();  
                            break; 
                    }
                }
                  
        }
        /**
         * Método que se encarga de mostrar el menú de registros del administrador
         * @return void
         */
        public static void adminAdvanceMenu(){
            Scanner scanner = new Scanner(System.in);
            int option = -1;
            while (option != 10) {
                showAdminMenuAdvance();
                System.out.print(Colores.silver+lang.select_an_option+Colores.reset);
                String userInput = scanner.nextLine().trim();
    
                try {
                    option = Integer.parseInt(userInput);
                    if (option < 1 || option > 10) {
                        System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                    continue;
                }
    
                switch (option) {
                    /**
                     * Opción para mostrar los usuarios registrados en el sistema
                     * @return void
                     */
                    case 1:
                    System.out.println(Colores.beige+lang.registered_people+Colores.reset);
                    bibliotecario.getUsers().forEach((k, v) -> { showUser(v); });
                    break;
                    /**
                     * Opción para mostrar los libros disponibles en el catálogo
                     */
                    case 2:
                    System.out.println(Colores.bold+lang.show_books_in_catalog_message+Colores.reset);
                    bibliotecario.showBooksSorted();
                    break;
                    /**
                     * Opción para mostrar los préstamos realizados en la biblioteca en todo el mes
                     * @return void
                     */
                    case 3:
                    bibliotecario.mostrarPrestamosAdministrador();
                    break;
                    /**
                     * Opción para mostrar los libros más populares en la biblioteca
                     * @return void
                     */
                    case 4:
                    bibliotecario.mostrarLibrosMasPopulares();
                    break;
                    /**
                     * Opción para mostrar los libros menos populares en la biblioteca
                     * @return void
                     */
                    case 5:
                    bibliotecario.mostrarLibrosMenosPopulares();
                    break;
                    /**
                     * Opción para mostrar los préstamos vencidos en la biblioteca
                     * @return void
                     */
                    case 6:
                    bibliotecario.mostrarPrestamosVencidos();
                    break;
                    /**
                     * Opción para mostrar los usuarios con préstamos vencidos en la biblioteca
                     * @return void
                     */
                    case 7:
                    bibliotecario.mostrarUsuariosVencidos();
                            break;
                    /**
                     * Opción para mostrar los usuarios con más préstamos vencidos en la biblioteca
                     * @return void
                     */
                    case 8:
                    bibliotecario.mostrarUsuariosMasVencidos();
                            break;
                    /**
                     * Opción para mostrar los usuarios con más préstamos entregados en la biblioteca
                     * @return void
                     */
                    case 9:
                    bibliotecario.mostrarUsuariosMasEntregados();
                            break;
                    /**
                     * Opción para salir del menú de registros del administrador
                     * @return void
                     */
                    case 10:
                    System.out.println(lang.exit_admin_advance+Colores.reset);
                    showLoadingBar();
                    cleanScreen();
                    break;
                }
            }     
        }
        /**
        * Método que se encarga de mostrar el menú de usuario adulto
        * @return void
        */
        public static void userMenu() {
            System.out.println(lang.menu_user+Colores.reset);
        
            Scanner scanner = new Scanner(System.in);
            int option = -1;
        
            while (option != 5) {
                System.out.print(Colores.light_green+lang.select_an_option+Colores.reset);
                String userInput = scanner.nextLine().trim();
        
                if (userInput.isEmpty()) {
                    System.out.println(Colores.red+lang.invalid_input_empty+Colores.reset);
                    continue; 
                }
        
                try {
                    option = Integer.parseInt(userInput);
                    if (option < 1 || option > 5) {
                        System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                    continue;
                }
        
                switch (option) {
                    /**
                    * Opción para mostrar los libros disponibles en el catálogo
                    * @return void
                    */
                    case 1:
                        System.out.println(Colores.light_gray+lang.show_books_in_catalog_message+Colores.reset);
                        bibliotecario.showBooksAvailableSorted();
                        break;

                    /**
                    * Opción para solicitar el préstamo de un libro
                    * @return void
                    */
                    case 2:
                        System.out.println(Colores.blue+lang.book_borrow_name_prompt+Colores.reset);
                        String bookName;
                        while (true) {
                            System.out.print(Colores.purple+lang.isbn+Colores.reset);
                            bookName = scanner.nextLine().trim();
                            if (bookName.isEmpty()) {
                                System.out.println(Colores.red+lang.invalid_isbn+Colores.reset);
                            } else {
                                break;
                            }
                        }
                        if (bibliotecario.addPrestamo(bookName, usernameLogged)) {
                            System.out.println(Colores.green+lang.borrowed_success+Colores.reset);
                            System.out.println(Colores.green+lang.adult_borrowed+Colores.reset);
                        } 
                        break;
                    /**
                    * Opción para mostrar los préstamos activos
                    * @return void
                    */
                    case 3:
                        bibliotecario.mostrarPrestamosActivos(usernameLogged);
                        break;
                    /**
                    * Opción para devolver un libro prestado
                    * @return void
                    */
                    case 4:
                        System.out.println(Colores.dark_gray+lang.enter_isbn+Colores.reset);
                        String isbn;
                        while (true) {
                            System.out.print(Colores.dark_green+lang.isbn+Colores.reset);
                            isbn = scanner.nextLine().trim();
                            if (isbn.isEmpty()) {
                                System.out.println(Colores.red+lang.entered_invalid_isbn+Colores.reset);
                            } else {
                                break;
                            }
                        }
                        bibliotecario.devolverLibro(isbn, usernameLogged);
                        break;
                    /**
                     * Opción para salir del menú de usuario
                     * @return void
                     */
                    case 5:
                        System.out.println(Colores.brown+lang.singning_out+Colores.reset);
                        showLoadingBar();
                        break;
                }
                if (option != 5) {
                    System.out.println(Colores.brown+lang.return_to_menu+Colores.reset);
                    scanner.nextLine(); 
                    System.out.println(lang.menu_user+Colores.reset);
                }
            }
        }
        /**
         * Método que se encarga de mostrar el menú de usuario Jr
         * @return void
         */
        public static void userMenuJr(){
            showMenuJr();
        
            Scanner scanner = new Scanner(System.in);
            int option = -1;
        
            while (option != 2) {
                System.out.print(Colores.dark_red+lang.select_an_option+Colores.reset);
                String userInput = scanner.nextLine().trim();
        
                if (userInput.isEmpty()) {
                    System.out.println(Colores.red+lang.invalid_input_empty+Colores.reset);
                    continue; 
                }
        
                try {
                    option = Integer.parseInt(userInput);
                    if (option < 1 || option > 2) {
                        System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                    continue;
                }
        
                switch (option) {
                    /**
                    * Opción para mostrar los libros disponibles en el catálogo
                    * @return void
                    */
                    case 1:
                        System.out.println(Colores.turquoise+lang.show_books_in_catalog_message+Colores.reset);
                        bibliotecario.showBooksAvailableSorted();
                        break;
                    /**
                    * Opción para salir del menú de usuario Jr
                    * @return void
                    */
                    case 2:
                        System.out.println(Colores.brown+lang.singning_out+Colores.reset);
                        showLoadingBar();
                        break;
                }
                if (option != 2) {
                    System.out.println(Colores.brown+lang.return_to_menu+Colores.reset);
                    scanner.nextLine(); 
                    showMenuJr();
                }
            }
        }
        /**
         * Método que se encarga de mostrar el menú de usuario Teen
         */
        public static void userMenuTeens(){
            showMenuTeens();
            Scanner scanner = new Scanner(System.in);
            int option = -1;
        
            while (option != 5) {
                System.out.print(Colores.light_gray+lang.select_an_option+Colores.reset);
                String userInput = scanner.nextLine().trim();
        
                if (userInput.isEmpty()) {
                    System.out.println(Colores.red+lang.invalid_input_empty+Colores.reset);
                    continue; 
                }
        
                try {
                    option = Integer.parseInt(userInput);
                    if (option < 1 || option > 5) {
                        System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                    continue;
                }
        
                switch (option) {
                    /**
                    * Opción para mostrar los libros disponibles en el catálogo
                    * @return void
                    */
                    case 1:
                        System.out.println(Colores.orange+lang.show_books_in_catalog_message+Colores.reset);
                        bibliotecario.showBooksAvailableSorted();
                        break;

                    /**
                    * Opción para solicitar el préstamo de un libro
                    * @return void
                    */
                    case 2:
                        System.out.println(Colores.yellow+lang.book_borrow_name_prompt+Colores.reset);
                        String bookName;
                        while (true) {
                            System.out.print(Colores.bg_yellow+lang.isbn+Colores.reset);
                            bookName = scanner.nextLine().trim();
                            if (bookName.isEmpty()) {
                                System.out.println(Colores.red+lang.invalid_isbn+Colores.reset);
                            } else {
                                break;
                            }
                        }
                        if (bibliotecario.addPrestamo(bookName, usernameLogged)) {
                            System.out.println(Colores.dark_green+lang.borrowed_success+Colores.reset);
                            System.out.println(Colores.light_green+lang.teen_borrowed+Colores.reset);
                        } 
                        break;
                    /**
                    * Opción para mostrar los préstamos activos
                    * @return void
                    */
                    case 3:
                        bibliotecario.mostrarPrestamosActivos(usernameLogged);
                        break;
                    /**
                    * Opción para devolver un libro prestado
                    * @return void
                    */
                    case 4:
                        System.out.println(Colores.purple+lang.enter_isbn+Colores.reset);
                        String isbn;
                        while (true) {
                            System.out.print(Colores.pink+lang.isbn+Colores.reset);
                            isbn = scanner.nextLine().trim();
                            if (isbn.isEmpty()) {
                                System.out.println(Colores.red+lang.entered_invalid_isbn+Colores.reset);
                            } else {
                                break;
                            }
                        }
                        bibliotecario.devolverLibro(isbn, usernameLogged);
                        break;
                    /**
                     * Opción para salir del menú de usuario Teen
                     */
                    case 5:
                        System.out.println(Colores.dark_green+lang.singning_out+Colores.reset);
                        showLoadingBar();
                        break;
                }
                if (option != 5) {
                    System.out.println(Colores.brown+lang.return_to_menu+Colores.reset);
                    scanner.nextLine(); 
                    showMenuTeens();
                }
            }
        }
        /**
         * Método que se encarga de mostrar el menú de usuario VIP
         */
        public static void userMenuVip() {
            showMenuVip();
        
            Scanner scanner = new Scanner(System.in);
            int option = -1;
        
            while (option != 5) {
                System.out.print(Colores.gold+lang.select_an_option+Colores.reset);
                String userInput = scanner.nextLine().trim();
        
                if (userInput.isEmpty()) {
                    System.out.println(Colores.red+lang.invalid_input_empty+Colores.reset);
                    continue; 
                }
        
                try {
                    option = Integer.parseInt(userInput);
                    if (option < 1 || option > 5) {
                        System.out.println(Colores.red+lang.invalid_option+Colores.reset);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Colores.red+lang.invalid_input_not_number+Colores.reset);
                    continue;
                }
        
                switch (option) {
                    /**
                    * Opción para mostrar los libros disponibles en el catálogo
                    * @return void
                    */
                    case 1:
                        System.out.println(Colores.turquoise+lang.show_books_in_catalog_message+Colores.reset);
                        bibliotecario.showBooksAvailableSorted();
                        break;

                    /**
                    * Opción para solicitar el préstamo de un libro
                    * @return void
                    */
                    case 2:
                        System.out.println(Colores.dark_blue+lang.book_borrow_name_prompt+Colores.reset);
                        String bookName;
                        while (true) {
                            System.out.print(Colores.light_blue+lang.isbn+Colores.reset);
                            bookName = scanner.nextLine().trim();
                            if (bookName.isEmpty()) {
                                System.out.println(Colores.red+lang.invalid_isbn+Colores.reset);
                            } else {
                                break;
                            }
                        }
                        if (bibliotecario.addPrestamo(bookName, usernameLogged)) {
                            System.out.println(Colores.dark_green+lang.borrowed_success+Colores.reset);
                            System.out.println(Colores.gold+lang.vip_borrowed+Colores.reset);
                        } 
                        break;
                    /**
                    * Opción para mostrar los préstamos activos
                    * @return void
                    */
                    case 3:
                        bibliotecario.mostrarPrestamosActivos(usernameLogged);
                        break;
                    /**
                    * Opción para devolver un libro prestado
                    * @return void
                    */
                    case 4:
                        System.out.println(Colores.dark_blue+lang.enter_isbn+Colores.reset);
                        String isbn;
                        while (true) {
                            System.out.print(Colores.light_blue+lang.isbn+Colores.reset);
                            isbn = scanner.nextLine().trim();
                            if (isbn.isEmpty()) {
                                System.out.println(Colores.red+lang.entered_invalid_isbn+Colores.reset);
                            } else {
                                break;
                            }
                        }
                        bibliotecario.devolverLibro(isbn, usernameLogged);
                        break;
                    /**
                     * Opción para salir del menú de usuario VIP
                     */
                    case 5:
                        System.out.println(Colores.brown+lang.singning_out+Colores.reset);
                        showLoadingBar();
                        break;
                }
                if (option != 5) {
                    System.out.println(Colores.brown+lang.return_to_menu+Colores.reset);
                    scanner.nextLine(); 
                    showMenuVip();
                }
            }
        }
    }