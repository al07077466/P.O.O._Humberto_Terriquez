package edu.humberto.terriquez.actividades.proyectofinal.process;
import edu.humberto.terriquez.actividades.proyectofinal.models.Book;
import edu.humberto.terriquez.actividades.proyectofinal.models.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Lang;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Esp;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Eng;
import edu.humberto.terriquez.actividades.proyectofinal.lang.Jap;
import edu.humberto.terriquez.actividades.proyectofinal.models.Prestamos;
import edu.humberto.terriquez.actividades.proyectofinal.utils.Colores;

public class Bibliotecario {
    private Lang lang=new Lang();
    private HashMap<String, Users> users;
    private HashMap<String, Book> books;
    private ArrayList<Prestamos> prestamos;
    private static final String USERS_FILE = "src/main/java/edu/jose/vazquez/actividades/proyectofinal/data/usuarios.txt";
    private static final String BOOKS_FILE = "src/main/java/edu/jose/vazquez/actividades/proyectofinal/data/libros.txt";
    private static final String PRESTAMOS_FILE = "src/main/java/edu/jose/vazquez/actividades/proyectofinal/data/prestamos.txt";
    /**
     * Metodo que se encarga de fijar el idioma en el que funcionará nuestro programa
     * @param lang
     */
    public void setLang(Lang lang){
        this.lang=lang;
    }
    /**
     * Constructor de la clase bibliotecario que arranca con varios prestamos vencidos, inicializados y devueltos para el funcionamiento de nuestro programa
     */
    public Bibliotecario() {
        this.users = new HashMap<>();
        this.books = new HashMap<>();
        this.prestamos = new ArrayList<>();
        cargarUsuarios();
        cargarLibros();
        cargarPrestamos();
        addUser("admin", "admin", 0, "admin");
        addUser("jose", "123", 25, "Jose Vazquez");
        addUser("juan", "123", 15, "Juan Perez");
        addUser("maria", "123", 10, "Maria Lopez");
        addUser ("pedro", "123", 0, "Pedro Martinez");
        addUser("luis", "123", 18, "Luis Rodriguez");
        addUser("ana", "123", 30, "Ana Garcia");
        addUser("laura", "123", 0, "Laura Hernandez");
        addUser("carlos", "123", 7, "Carlos Sanchez");
        addBook("Juego de tronos", "George R. Martin", "123", true, 1937, "Fantasia");
        addBook("El señor de los anillos", "J.R.R. Tolkien", "124", true, 1937, "Fantasia");
        addBook("Harry Potter", "J.K. Rowling", "125", true, 1937, "Fantasia");
        addBook("El principito", "Antoine de Saint-Exupéry", "126", true, 1937, "Fantasia");
        addBook("Cien años de soledad", "Gabriel García Márquez", "127", true, 1937, "Fantasia");
        addBook("Don Quijote de la Mancha", "Miguel de Cervantes", "128", true, 1937, "Fantasia");
        addBook("El alquimista", "Paulo Coelho", "129", true, 1937, "Fantasia");
        addBook("El código Da Vinci", "Dan Brown", "130", true, 1937, "Fantasia");
        addBook("El perfume", "Patrick Süskind", "131", true, 1937, "Fantasia");
        addBook("La sombra del viento", "Carlos Ruiz Zafón", "132", true, 1937, "Fantasia");
        addBook("El nombre del viento", "Patrick Rothfuss", "133", true, 1937, "Fantasia");
        addBook("La ladrona de libros", "Markus Zusak", "134", true, 1937, "Fantasia");
        addPrestamo("123", "jose");
        devolverLibro("123", "jose");
        addPrestamo("123", "laura");
        devolverLibro("123", "laura");
        addPrestamo("134", "ana");
        forzarVencimientoPrestamo("134", "ana");
        addPrestamo("123", "laura");
        devolverLibro("123", "laura");
        addPrestamo("126", "laura");
        devolverLibro("126", "laura");
        addPrestamo("126", "laura");
        devolverLibro("126", "laura");
        addPrestamo("130", "laura");
        addPrestamo("133", "luis");
        forzarVencimientoPrestamo("133", "luis");
        addPrestamo("128", "ana");
        forzarVencimientoPrestamo("128", "ana");
        addPrestamo("124", "jose");
        addPrestamo("131", "pedro");
        addPrestamo("132", "pedro");
        addPrestamo("129", "pedro");
        devolverLibro("129", "pedro");
        devolverLibro("131", "pedro");
        addPrestamo("125","juan"); 
    }
    /**
     * Metodo que se encarga de corroborar la fecha de los prestamos para actualizar sus estados en caso de estar vencidos o devueltos
     */
    public void actualizarPrestamos() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
    
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getStatus().equals("Prestado")) {
                try {
                    Date returnDate = dateFormat.parse(prestamo.getFechaFin());
                    if (currentDate.after(returnDate)) {
                        prestamo.setStatus("Vencido");
                        users.get(prestamo.getUsername()).setVencimientos(users.get(prestamo.getUsername()).getVencimientos() + 1);
                        books.get(prestamo.getTitle()).setAvailable(true);

                    }
                } catch (ParseException e) {
                    System.out.println(Colores.red+lang.error_modifing_date+ e.getMessage()+Colores.reset);
                }
            }
        }
        guardarPrestamos();
        guardarUsuarios();
    }
    /**
     * Metodo que se encarga de hacer que el prestamo de un libro para un usuario este vencido
     * @param isbn
     * @param username
     */
    public void forzarVencimientoPrestamo(String isbn, String username) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1); 
        String fechaVencida = dateFormat.format(calendar.getTime());
    
        boolean encontrado = false;
    
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getUsername().equals(username) && prestamo.getTitle().equals(isbn) && prestamo.getStatus().equals("Prestado")) {
                prestamo.setFechaFin(fechaVencida);
                encontrado = true;
                break;
            }
        }
    
        if (encontrado) {
            guardarPrestamos(); 
        } else {
            System.out.println(Colores.red+lang.user_and_book_not_found+Colores.reset);
        }
    }
    /**
     * Metodo que muestra los prestamos vencidos en la biblioteca
     */
    public void mostrarPrestamosVencidos(){
        System.out.println(Colores.dark_red+lang.overdue_loans+Colores.reset);
        boolean tienePrestamos = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getStatus().equals("Vencido")) {
                try {
                    Date returnDate = dateFormat.parse(prestamo.getFechaFin());
                    if (currentDate.after(returnDate)) {
                        String isbn = prestamo.getTitle();
                        String nombreLibro = books.containsKey(isbn) ? books.get(isbn).getTitle() : "Libro no encontrado";
                        System.out.println(Colores.dark_red+"\n"+ lang.book_alone + nombreLibro +
                                           "\n"+ lang.isbn_overdue_loans + isbn +
                                           "\n"+ lang.user_overdue_loans + prestamo.getUsername() +
                                           "\n"+ lang.return_date_overdue_loans  + prestamo.getFechaFin()+Colores.reset);
                        tienePrestamos = true;
                    }
                } catch (Exception e) {
                    System.out.println(Colores.red+lang.error_comparing_dates + e.getMessage()+Colores.reset);
                }
            }
        }
        if (!tienePrestamos) {
            System.out.println(Colores.red+lang.no_overdue_loans+Colores.reset);
        }
    }

    /**
     * Metodo que se encarga de añadir un prestamo vencido a la lista de prestamos de la biblioteca
     */
    public void addPrestamoVencido(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getStatus().equals("Prestado")) {
                try {
                    Date returnDate = dateFormat.parse(prestamo.getFechaFin());
                    if (currentDate.after(returnDate)) {
                        String isbn = prestamo.getTitle();
                        books.get(isbn).setAvailable(true);
                        prestamo.setStatus("Vencido");
                        users.get(prestamo.getUsername()).setVencimientos(users.get(prestamo.getUsername()).getVencimientos() + 1);
                        guardarPrestamos();
                    }
                } catch (Exception e) {
                    System.out.println(Colores.red+lang.error_comparing_dates + e.getMessage()+Colores.reset);
                }
            }
        }
    }

/**
 * Metodo que se encarga de agregar un libro a la biblioteca con los datos proporcionados por el usuario y lo guarda en un archivo
 * @param username
 * @param password
 * @param age
 * @param name
 */

    public void addUser(String username, String password, int age, String name) {
        if (users.containsKey(username)) {
            System.out.println(Colores.red+lang.error_already_exists+Colores.reset);
            return;
        }

        String tipo;
        if (age <= 0) {
            tipo = "Usuario VIP";
        } else
        if (age < 12) {
            tipo = "Usuario JR";
        } else if (age <= 17) {
            tipo = "Usuario teens";
        } else {
            tipo = "Usuario adulto";
        }

        Users newUser = new Users(username, password, age, name, tipo, 0, 0);
        users.put(username, newUser);
        guardarUsuarios();
    }
    /**
     * Metodo que se encarga de añadir un prestamo de un libro a un usuario en la biblioteca y lo guarda en un archivo de prestamos para tener los registros
     * @param isbn
     * @param username
     * @return
     */
    public Boolean addPrestamo(String isbn, String username) {
        if (!users.containsKey(username)) {
            System.out.println(Colores.red+lang.user_not_found+Colores.reset);
            return false;
        }
        if (!books.containsKey(isbn)) {
            System.out.println(Colores.red+lang.book_not_found+Colores.reset);
            return false;
        }
        if (!books.get(isbn).isAvailable()) {
            System.out.println(Colores.red+lang.book_not_available+Colores.reset);
            return false;
        }
        Users user = users.get(username);
        int prestamosActuales = librosPrestados(username);
        switch (user.getTipo()) {
            case "Usuario teens":
                if (prestamosActuales >= 1) {
                    System.out.println(Colores.black+lang.overload_teens+Colores.reset);
                    return false;
                }
                break;
            case "Usuario adulto":
                if (prestamosActuales >= 2) {
                    System.out.println(Colores.dark_green+lang.overload_adult+Colores.reset);
                    return false;
                }
                break;
            case "Usuario VIP":
                if (prestamosActuales >= 5){
                    System.out.println(Colores.gold+lang.overload_vip+Colores.reset);
                    return false;
                } 
                break;
        }
        switch (user.getTipo()) {
            case "Usuario teens":
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                Date currentDate = calendar.getTime();
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                Date returnDate = calendar.getTime();
                Prestamos newPrestamo = new Prestamos(isbn, username, dateFormat.format(currentDate), dateFormat.format(returnDate), "Prestado");
                prestamos.add(newPrestamo);
                books.get(isbn).setAvailable(false);
                books.get(isbn).setPopularity(books.get(isbn).getPopularity() + 1);
                guardarPrestamos();
                guardarLibros(); 
                return true;
            case "Usuario adulto":
                SimpleDateFormat dateFormatAdult = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendarAdult = Calendar.getInstance();
                Date currentDateAdult = calendarAdult.getTime();
                calendarAdult.add(Calendar.DAY_OF_MONTH, 7);
                Date returnDateAdult = calendarAdult.getTime();
                Prestamos newPrestamoAdult = new Prestamos(isbn, username, dateFormatAdult.format(currentDateAdult), dateFormatAdult.format(returnDateAdult), "Prestado");
                prestamos.add(newPrestamoAdult);
                books.get(isbn).setAvailable(false);
                books.get(isbn).setPopularity(books.get(isbn).getPopularity() + 1);
                guardarPrestamos();
                guardarLibros(); 
                return true;
            case "Usuario VIP":
                SimpleDateFormat dateFormatVip = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendarVip = Calendar.getInstance();
                Date currentDateVip = calendarVip.getTime();
                calendarVip.add(Calendar.DAY_OF_MONTH, 14);
                Date returnDateVip = calendarVip.getTime();
                Prestamos newPrestamoVip = new Prestamos(isbn, username, dateFormatVip.format(currentDateVip), dateFormatVip.format(returnDateVip   ), "Prestado");
                prestamos.add(newPrestamoVip);
                books.get(isbn).setAvailable(false);
                books.get(isbn).setPopularity(books.get(isbn).getPopularity() + 1);
                guardarPrestamos();
                guardarLibros();
                 
                return true;
        }
        return false;
    }
    /**
     * Metodo que se encarga de guardar el prestamo en un archivo de prestamos
     */
    private void guardarPrestamos(){
        File file = new File(PRESTAMOS_FILE);
        file.getParentFile().mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRESTAMOS_FILE))) {
            for (Prestamos prestamo : prestamos) {
                writer.write(prestamo.getTitle() + "," + prestamo.getUsername() + "," + prestamo.getFechaInicio() + "," + prestamo.getFechaFin() + "," + prestamo.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(Colores.red+lang.error_saving_loans + e.getMessage()+Colores.reset);
        }
    }
    /**
     * Metodo que se encarga de cargar los prestamos de un archivo de prestamos
     */
    private void cargarPrestamos(){
        File file = new File(PRESTAMOS_FILE);
        if (!file.exists()) {
            System.out.println(Colores.red+lang.loans_data_not_found+Colores.reset);
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(PRESTAMOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Prestamos prestamo = new Prestamos(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    prestamos.add(prestamo);
                }
            }
        } catch (IOException e) {
            System.out.println(Colores.red+lang.loans_data_not_found+Colores.reset);
        }
    }
    /**
     * Metodo que se encarga de guardar los usuarios en un archivo de usuarios
     */
    private void guardarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (Users user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getAge() + "," + user.getName() + "," + user.getTipo() + "," + user.getEntregados() + "," + user.getVencimientos());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(Colores.red+lang.error_saving_user + e.getMessage()+Colores.reset);
        }
    }
    /**
     * Metodo que se encarga de cargar los usuarios de un archivo de usuarios
     */
    private void cargarUsuarios() {
        File file = new File(USERS_FILE);
        if (!file.exists()) {
            System.out.println(Colores.red+lang.user_data_not_found+Colores.reset);
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) { 
                    Users user = new Users(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
                    users.put(parts[0], user);
                }
            }
        } catch (IOException e) {
            System.out.println(Colores.red+lang.error_loading_user+Colores.reset);
        }
    }

    /**
     * Metodo que se encarga de guardar los libros creados en un archivo de libros
     */
    private void guardarLibros() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books.values()) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getIsbn() + "," + book.isAvailable() + "," + book.getYear() + "," + book.getGenre() + "," + book.getPopularity());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(Colores.red+lang.error_saving_books + e.getMessage()+Colores.reset);
        }
    }
    /**
     * Metodo que se encarga de cargar los libros de un archivo de libros
     */
    public void cargarLibros() {
        File file = new File(BOOKS_FILE);
        if (!file.exists()) {
            System.out.println(Colores.red+lang.book_data_not_found+Colores.reset);
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) { // Ahora incluye la popularidad
                    Book book = new Book(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]), Integer.parseInt(parts[4]), parts[5], Integer.parseInt(parts[6]));
                    books.put(parts[2], book);
                }
            }
        } catch (IOException e) {
            System.out.println(Colores.red+lang.error_loading_books+Colores.reset);
        }
    }
    /**
     * Metodo que se encarga de revisar cuantos libros prestados tiene el usuario a la vez
     * @param username
     * @return
     */
    public int librosPrestados(String username) {
        int prestados = 0;
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getUsername().equals(username) && prestamo.getStatus().equals("Prestado")) {
                prestados++;
            }
        }
        return prestados;
    }
    /**
     * Metodo que se encarga de definir al usuario por su edad en alguna de todas las clases de usuario registradas con anterioridad (vip, jr, teens, adulto)
     * @param username
     * @return
     */
    public String validarUsuario(String username) {
        Users user = users.get(username);
        if (user == null) {
            System.out.println(Colores.red+lang.user_not_found+Colores.reset);
            return "Desconocido";
        }

        int age = user.getAge();
        if (age <= 12) return "Usuario JR";
        if (age <= 17) return "Usuario teens";
        if (age <=0) return "Usuario VIP";
        return "Usuario adulto";
    }
    /**
     * Metodo para la devolucion de un libro prestado por un usuario, actualiza el estado del prestamo y del libro en la biblioteca
     * @param isbn
     * @param username
     */
    public void devolverLibro(String isbn, String username) {
        if (!users.containsKey(username)) {
            System.out.println(Colores.red+lang.user_not_found+Colores.reset);
            return;
        }
        if (!books.containsKey(isbn)) {
            System.out.println(Colores.red+lang.book_not_found+Colores.reset);
            return;
        }
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getUsername().equals(username) && prestamo.getTitle().equals(isbn) && prestamo.getStatus().equals("Prestado")) {
                prestamo.setStatus("Devuelto");
                books.get(isbn).setAvailable(true);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                Date currentDate = calendar.getTime();
                prestamo.setFechaDevolucion(dateFormat.format(currentDate));
                users.get(username).setEntregados(users.get(username).getEntregados() + 1);
                System.out.println(Colores.green+lang.succesfuly_returned+Colores.reset);
                guardarPrestamos();
                guardarUsuarios();
                guardarLibros();
                return;
            }
        }
        System.out.println(Colores.red+lang.book_not_borrowed+Colores.reset);
    }


/**
 * Metodo que muestra los usuarios que tengan prestamos vencidos en la biblioteca
 */
    public void mostrarUsuariosVencidos(){
        System.out.println(Colores.light_blue+lang.users_with_overdue+Colores.reset);
        boolean tienePrestamos = false;
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getStatus().equals("Vencido")) {
                String isbn = prestamo.getTitle();
                String nombreLibro = books.containsKey(isbn) ? books.get(isbn).getTitle() : "Libro no encontrado";
                System.out.println(Colores.dark_green+"\n"+ lang.user_more_returned   + prestamo.getUsername() +
                                   "\n"+ lang.book_more_overdue  + nombreLibro +
                                   "\n"+lang.isbn_overdue_loans  + isbn +
                                   "\n"+ lang.return_date_overdue_loans  + prestamo.getFechaFin()+Colores.reset);
                tienePrestamos = true;
            }
        }
        if (!tienePrestamos) {
            System.out.println(Colores.red+lang.no_users_with_overdue+Colores.reset);
        }
    }
/**
 * Metodo que muestra una lista de usuarios que tengas más prestamos vencidos, una lista negra de usuarios organizados por la cantidad de prestamos vencidos
 */
    public void mostrarUsuariosMasVencidos(){
        System.out.println(Colores.red+lang.users_with_more_overdue+Colores.reset);
        List<Users> usuariosOrdenados = users.values().stream()
                .filter(user -> user.getVencimientos() > 0)
                .sorted(Comparator.comparing(Users::getVencimientos, Comparator.reverseOrder())
                        .thenComparing(Users::getUsername))
                .collect(Collectors.toList());
        
        if (usuariosOrdenados.isEmpty()) {
            System.out.println(Colores.red+lang.no_users_with_overdue+Colores.reset);
        } else {
            for (Users user : usuariosOrdenados) {
                System.out.println(Colores.light_gray+"\n"+ lang.user_more_returned  + user.getUsername() +
                                   "\n"+ lang.name_more_returned  + user.getName() +
                                   "\n"+ lang.type_more_returned  + user.getTipo() +
                                   "\n"+ lang.overdue_loans_more_overdue  + user.getVencimientos()+Colores.reset);
            }
        }

    }
/**
 * Metodo que muestra una lista de honor de usuarios que tengan más prestamos entregados, una lista de usuarios organizados por la cantidad de prestamos entregados
 */
    public void mostrarUsuariosMasEntregados(){
        System.out.println(Colores.dark_green+lang.users_with_more_returns+Colores.reset);
        List<Users> usuariosOrdenados = users.values().stream()
                .filter(user -> user.getEntregados() > 0)
                .sorted(Comparator.comparing(Users::getEntregados, Comparator.reverseOrder())
                        .thenComparing(Users::getUsername))
                .collect(Collectors.toList());
        
        if (usuariosOrdenados.isEmpty()) {
            System.out.println(Colores.red+lang.no_users_with_returns+Colores.reset);
        } else {
            for (Users user : usuariosOrdenados) {
                System.out.println(Colores.cyan+"\n"+ lang.user_more_returned + user.getUsername() +
                                   "\n"+ lang.name_more_returned + user.getName() +
                                   "\n"+ lang.type_more_returned  + user.getTipo() +
                                   "\n"+lang.returned_loans + user.getEntregados()+Colores.reset);
            }
        }
    }
/**
 * Metodo que muestra los libros de la biblioteca ordenados por titulo en orden alfabetico
 */
    public void showBooksSorted(){
        System.out.println(Colores.dark_gray+lang.books_arranged_by_title+Colores.reset);
        List<Book> librosOrdenados = books.values().stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
        
        if (librosOrdenados.isEmpty()) {
            System.out.println(Colores.red+lang.no_books_available_on_library+Colores.reset);
        } else {
            for (Book book : librosOrdenados) {
                System.out.println(Colores.silver+"╔═══════════════════╗");
                System.out.println("║  "+book.getTitle());
                System.out.println("╚═══════════════════╝");
                System.out.println("╔═══════════════════╗");
                System.out.println(lang.author_more_popular + book.getAuthor() );
                System.out.println("║ "+lang.isbn + book.getIsbn() );
                System.out.println("║ "+lang.genre + book.getGenre() );
                System.out.println("║ "+lang.year_book + book.getYear() );
                System.out.println("║ " + (book.isAvailable() ? lang.currently_available : lang.currently_borrowed) );
                System.out.println("╚═══════════════════╝"+Colores.reset);
            }
        }
    }
/**
 * Metodo que muestra los libros ordenamos de manera alfabetica pero solo mostrando los que están disponibles para prestamo
 */
    public void showBooksAvailableSorted(){
        System.out.println(Colores.light_green+"Libros disponibles ordenados por título:"+Colores.reset);
        List<Book> librosOrdenados = books.values().stream()
                .filter(Book::isAvailable)
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
        
        if (librosOrdenados.isEmpty()) {
            System.out.println(Colores.red+"No hay libros disponibles en la biblioteca."+Colores.reset);
        } else {
            for (Book book : librosOrdenados) {
                System.out.println(Colores.bold+"╔═══════════════════╗");
                System.out.println("║  "+book.getTitle());
                System.out.println("╚═══════════════════╝");
                System.out.println("╔═══════════════════╗");
                System.out.println("║ "+lang.author + book.getAuthor() );
                System.out.println("║ "+lang.isbn + book.getIsbn() );
                System.out.println("║ "+lang.genre + book.getGenre() );
                System.out.println("║ "+lang.year_book + book.getYear() );
                System.out.println("║ " + (book.isAvailable() ? lang.currently_available : lang.currently_borrowed) );
                System.out.println("╚═══════════════════╝"+Colores.reset);
            }
        }
    }
    /**
     * Metodo que muestra los libros ordenados por popularidad, mostrando los libros más populares primero
     */
    public void mostrarLibrosMasPopulares() {
        cargarLibros();
        System.out.println(Colores.violet+lang.popular_books+Colores.reset);
        List<Book> librosOrdenados = books.values().stream()
                .filter(book -> book.getPopularity() > 0)
                .sorted(Comparator.comparing(Book::getPopularity, Comparator.reverseOrder())
                        .thenComparing(Book::getTitle))
                .collect(Collectors.toList());
        
        if (librosOrdenados.isEmpty()) {
            System.out.println(Colores.red+lang.no_popular_books+Colores.reset);
        } else {
            for (Book book : librosOrdenados) {
                System.out.println(Colores.dark_red+"\n"+lang.title_more_popular + book.getTitle() +
                                   "\n"+lang.author_more_popular + book.getAuthor() +
                                   "\n"+lang.isbn_overdue_loans + book.getIsbn() +
                                   "\n"+lang.times_more_popular + book.getPopularity()+Colores.reset);
            }
        }
    }
    /**
     * Metodo que muestra los libros menos populares de la biblioteca, mostrando los libros menos populares primero
     */

    public void mostrarLibrosMenosPopulares() {
        cargarLibros();
        System.out.println(Colores.pink+lang.unpopular_books+Colores.reset);
        List<Book> librosOrdenados = books.values().stream()
                .sorted(Comparator.comparing(Book::getPopularity)
                        .thenComparing(Book::getTitle))
                .collect(Collectors.toList());
        
        if (librosOrdenados.isEmpty()) {
            System.out.println(Colores.red+lang.no_books_on_library+Colores.reset);
        } else {
            for (Book book : librosOrdenados) {
                System.out.println(Colores.dark_blue+"\n"+lang.title_more_popular + book.getTitle() +
                                   "\n"+lang.author_more_popular + book.getAuthor() +
                                   "\n"+lang.isbn_overdue_loans + book.getIsbn() +
                                   "\n"+lang.times_more_popular + book.getPopularity()+Colores.reset);
            }
        }
    }
    /**
     * Metodo que muestra los prestamos que se han hecho en la biblioteca a lo largo de este mes
     */
    public void mostrarPrestamosAdministrador() {
        
        System.out.println(Colores.purple+lang.loans_of_month+Colores.reset);
        boolean tienePrestamos = false;
        for (Prestamos prestamo : prestamos) {
            String isbn = prestamo.getTitle();
            String nombreLibro = books.containsKey(isbn) ? books.get(isbn).getTitle() : "Libro no encontrado";
            String fechaDevolucion = prestamo.getFechaFin();
            
            if (prestamo.getStatus().equals("Devuelto")) {
                fechaDevolucion = prestamo.getFechaDevolucion(); 
            }
            if(prestamo.getStatus().equals("Vencido")){
                fechaDevolucion = prestamo.getFechaFin();
            }
            System.out.println(Colores.dark_green+"\n"+lang.book_alone + nombreLibro +
                               "\n"+lang.isbn_overdue_loans + isbn +
                               "\n"+lang.user_overdue_loans + prestamo.getUsername() +
                               "\n"+lang.borrow_date_admin_loans + prestamo.getFechaInicio() +
                               "\n"+lang.return_date_overdue_loans + fechaDevolucion+Colores.reset);
            tienePrestamos = true;
        }
        
        if (!tienePrestamos) {
            System.out.println(Colores.red+lang.no_loans_on_month+Colores.reset);
        }
    }
    /**
     * Metodo que muestra los prestamos activos en la biblioteca
     */
    public void mostrarPrestamosActivosAdministrador() {
        System.out.println(Colores.light_gray+lang.active_loans+Colores.reset);
        boolean tienePrestamos = false;
    
        for (Prestamos prestamo : prestamos) {
            if (!prestamo.getStatus().equals("Devuelto") && !prestamo.getStatus().equals("Vencido")) { // Filtrar solo los préstamos activos
                String isbn = prestamo.getTitle();
                String nombreLibro = books.containsKey(isbn) ? books.get(isbn).getTitle() : "Libro no encontrado";
                System.out.println(Colores.cyan+"\n"+ lang.book_alone + nombreLibro +
                                   "\n"+lang.isbn_overdue_loans + isbn +
                                   "\n"+lang.user_overdue_loans + prestamo.getUsername() +
                                   "\n"+ lang.borrow_date_admin_loans  + prestamo.getFechaInicio() +
                                   "\n"+ lang.return_date_overdue_loans   + prestamo.getFechaFin()+Colores.reset);
                tienePrestamos = true;
            }
        }
    
        if (!tienePrestamos) {
            System.out.println(Colores.red+lang.no_active_loans+Colores.reset);
        }
    }
    /**
     * Metodo que muestra los prestamos activos de un usuario en la biblioteca
     * @param username
     */
    public void mostrarPrestamosActivos(String username) {
        if (!users.containsKey(username)) {
            System.out.println(Colores.red+lang.user_not_found +Colores.reset);
            return;
        }
    
        System.out.println(Colores.beige+lang.active_loans_of + username + ":"+Colores.reset);
        boolean tienePrestamos = false;
    
        for (Prestamos prestamo : prestamos) {
            if (prestamo.getUsername().equals(username) && prestamo.getStatus().equals("Prestado")) {
                String isbn = prestamo.getTitle();
                String nombreLibro = books.containsKey(isbn) ? books.get(isbn).getTitle() : "Libro no encontrado";
                System.out.println(Colores.bold+"\n"+ lang.book_alone  + nombreLibro +
                                   "\n"+ lang.isbn_overdue_loans + isbn +
                                   "\n"+ lang.borrow_date_admin_loans + prestamo.getFechaInicio() +
                                   "\n"+ lang.return_date_overdue_loans  + prestamo.getFechaFin()+Colores.reset);
                tienePrestamos = true;
            }
        }
    
        if (!tienePrestamos) {
            System.out.println(Colores.dark_red+lang.asset_loans+Colores.reset);
        }
    }
    /**
     * Metodo que permite agregar un libro a la biblioteca con los datos proporcionados por el usuario y lo guarda en un archivo de libros
     * @param title
     * @param author
     * @param isbn
     * @param available
     * @param year
     * @param genre
     */
    public void addBook(String title, String author, String isbn, boolean available, int year, String genre) {
        if (books.containsKey(isbn)) {
            System.out.println(Colores.red+lang.error_book_already_registered+Colores.reset);
            return;
        }
        Book newBook = new Book(title, author, isbn, available, year, genre, 0);
        books.put(isbn, newBook);
        guardarLibros();
    }
    /**
     * Metodo que permite ver a los usuarios registrados en la biblioteca
     */
    public HashMap<String, Users> getUsers() {
        return this.users;
    }
    /**
     * Metodo que permite ver los libros registrados en la biblioteca
     * @return
     */
    public HashMap<String, Book> getBooks() {
        return this.books;
    }
    /**
     * Metodo que permite verificar si las credenciales con las que se inicia sesión son correctas
     * @param username
     * @param password
     * @return
     */
    public boolean validateUserLoggin(String username, String password) {
        Users user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
    /**
     * Metodo que permite obtener el tipo de usuario que se ha registrado en la biblioteca
     * @param registerUser
     * @return
     */
    public String getUserType(String registerUser) {
        Users user = users.get(registerUser);
        return (user != null) ? user.getTipo() : "Desconocido";
    }
}