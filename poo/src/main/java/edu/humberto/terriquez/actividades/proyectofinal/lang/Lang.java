package edu.humberto.terriquez.actividades.proyectofinal.lang;
/**
 * Clase que contiene los mensajes que se muestran en la aplicación
 */
public class Lang {

    public String menu_login;
    public String menu_register;
    public String menu_exit;
    public String menu_admin;
    public String menu_admin_advance;
    public String menu_user;
    public String menu_book_catalog;
    public String menu_borrow_book;
    public String menu_active_loans;
    public String menu_return;
    public String invalid_option;
    public String username_prompt;
    public String password_prompt;
    public String welcome_admin;
    public String welcome_user;
    public String goodbye;
    public String register_user;
    public String register_password;
    public String registration_success;
    public String invalid_credentials;
    public String book_added;
    public String book_borrow_success;
    public String book_not_available;
    public String invalid_input_empty;
    public String invalid_input_not_number;
    public String invalid_option_out_of_range;
    public String enter_book_title_prompt;
    public String invalid_title;
    public String enter_book_author_prompt;
    public String invalid_author;
    public String enter_book_isbn_prompt;
    public String invalid_isbn;
    public String enter_book_genre_prompt;
    public String invalid_genre;
    public String enter_book_year_prompt;
    public String year_of_publication_negative_error;
    public String year_of_publication_future_error;
    public String book_entry_success;
    public String book_borrow_name_prompt;
    public String no_active_loans_message;
    public String no_books_borrowed_message;
    public String show_books_in_catalog_message;
    public String number_format_exception;
    public String exit_admin;
    public String singning_out;
    public String return_to_menu;
    public String invalid_new_username;
    public String invalid_new_password;
    public String registered_people;
    public String registered_user;
    public String show_active_loans;
    public String select_an_option;
    public String author;
    public String title;
    public String isbn;
    public String genre;
    public String year_book;
    public String username;
    public String password;
    public String welcome_user_format; 

    //CLI
    public String enter_age; //Ingrese su edad
    public String age; //Edad:
    public String age_negative;//La edad no puede ser negativa
    public String error_valid_number;//Ingrese un número válido
    public String error_real_name;//Ingrese un nombre real
    public String name_with_colon;//Nombre:
    public String error_valid_name;//Ingrese un nombre válido
    public String vip_user;//Usuario VIP
    public String jr_user;//Usiaro JR
    public String teen_user;//Usuario Teen
    public String admin;//admin
    public String currently_available;//Actualmente disponibles
    public String currently_borrowed;//Actualmente prestados
    public String user;//Usuario:
    public String name;//Nombre:
    public String user_type;//Tipo de usuario:
    public String jr_menu;//Menú de usuario JR
    public String vip_menu;//Menú de usuario VIP
    public String teens_menu;//Menú de usuario Teen
    public String no_books_available;//No hay libros disponibles
    public String available_books;//Libros disponibles
    public String error_same_unique_code;//El libro no se puede agregar, ya existe un libro con el mismo código único
    public String borrowed_success;//Préstamo realizado con éxito
    public String adult_borrowed;//El libro se ha prestado por 7 días por ser un usuario adulto recuerda devolverlo a tiempo
    public String return_book;//Devolver libro
    public String enter_isbn;//Ingrese el ISBN del libro que desea devolver
    public String entered_invalid_isbn;//Ingrese un ISBN válido
    public String teen_borrowed;//El libro se ha prestado por 7 días por ser un usuario teen recuerda devolverlo a tiempo
    public String vip_borrowed;//El libro se ha prestado por 14 días por ser un usuario VIP recuerda devolverlo a tiempo
    public String menu_lower;
    public String menu_upper;
    public String user_showuser;
    public String name_showuser;
    public String user_type_showuser;
    public String password_showuser;
    public String edad_showuser;
    public String update_loans;
    public String exit_admin_advance;
    //bibliotecario

    public String fantasy;//Fantasía
    public String got;//Juego de tronos
    public String lotr;//El señor de los anillos
    public String hp;//Harry Potter
    public String tlp;//El principito
    public String ohyos;//Cien años de soledad
    public String dqolm;//Don Quijote de la Mancha
    public String ta;
    public String tvdc;
    public String tp;
    public String tsotw;
    public String ttob;
    
    public String overdue_loans;//Préstamos vencidos
    public String date_pattern;//yyyy-MM-dd
    public String overdue;//Vencido
    public String book;//Libro:
    public String return_date;//Fecha de devolución:
    public String error_comparing_dates;//Error al comparar fechas: 
    public String no_overdue_loans;//No hay préstamos vencidos en la biblioteca
    public String borrowed;//Prestado
    public String new_return_date;//Nueva fecha de devolución para:
    public String with_the_book;// con el libro 
    public String colon;//: 
    public String error_modifing_date;//Error al modificar la fecha del préstamo:
    public String error_already_exists;//Error: El usuario ya existe.
    public String adult_users;//Usuario adulto
    public String book_not_found;//Error: Libro no encontrado
    public String user_not_found;//Error: Usuario no encontrado
    public String overload_teens;//Solo puedes tener 1 libro prestado a la vez, por favor devuelvelo antes de pedir otro.
    public String overload_adult;//Solo puedes tener 2 libros prestados a la vez, por favor devuelve uno antes de pedir otro.
    public String overload_vip;//Solo puedes tener 5 libros prestados a la vez, por favor devuelve uno antes de pedir otro.
    public String error_saving_user;//Error al guardar usuarios:
    public String user_data_not_found;//No se encontraron datos de usuarios.
    public String error_saving_books;//Error al guardar libros:
    public String book_data_not_found;//No se encontraron datos de libros.
    public String stranger;//Desconocido
    public String returned;//Devuelto
    public String succesfuly_returned;//Libro devuelto con éxito
    public String popular_books;//Libros más populares
    public String no_popular_books;//No hay libros populares en la biblioteca.
    public String popularity;//Popularidad
    public String users_with_overdue;//Usuarios con préstamos vencidos:
    public String no_users_with_overdue;//No hay usuarios con préstamos vencidos.
    public String users_with_more_overdue;//Usuarios con más préstamos vencidos:
    public String overdue_loans_colon;//Préstamos vencidos: 
    public String users_with_more_returns;//Usuarios con más préstamos entregados:
    public String no_users_with_returns;//No hay usuarios con préstamos entregados.
    public String returned_loans;//Préstamos entregados: 
    public String books_arranged_by_title;//Libros ordenados por título:
    public String no_books_on_library;//No hay libros en la biblioteca.
    public String unpopular_books;//Libros menos populares
    public String loans_of_month;//Préstamos del mes:
    public String no_loans_on_month;//No hay se han registrado prestamos en la biblioteca este mes.
    public String active_loans;//Préstamos activos:
    public String no_active_loans;//No hay préstamos activos en la biblioteca.
    public String active_loans_of;//Préstamos activos de 
    public String asset_loans;//No tienes préstamos activos.
    public String error_book_already_registered;//Error: El libro ya está registrado.
    public String user_and_book_not_found;
    public String book_alone;
    public String isbn_overdue_loans;
    public String user_overdue_loans;
    public String return_date_overdue_loans;
    public String error_saving_loans;
    public String oans_data_not_found;
    public String error_loading_user;
    public String error_loading_books;
    public String book_not_borrowed;
    public String user_more_returned;

    public String book_more_overdue;
    public String name_more_returned;
    public String type_more_returned;
    public String overdue_loans_more_overdue;
    public String available_books_arranged_by_title;
    public String no_books_available_on_library;
    public String title_more_popular;
    public String author_more_popular;
    public String times_more_popular;
    public String borrow_date_admin_loans;
    public String loans_data_not_found;
}
