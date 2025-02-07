package edu.humberto.terriquez.actividades.proyecto_final.ui.Languages;

/**
 * Esp es la clase encargada de definir como texto en espanol las variables creadas en Lang.java, utilizadas en CLI.java.
 * Utiliza el principio de polimorfismo, por lo que esta clase es utilizada solo si el usuario lo elige.
 */
public class Esp extends Lang{
    public Esp(){
        FirstWelcomeText = "Bienvenido a la biblioteca TeamTree!";
        LogInRequestText = "Haz Log-in para ingresar.";
        UserRequestText = "Usuario: ";
        PasswordRequestText = "Ingresa tu contraseña: ";
        LogInErrorText = "Usuario o contraseña incorrectos.";
        MainMenuText = "Menú principal";
        WelcomeText = "Bienvenido, ";
        ExclamationMarkText = "!";
        OptionOneRegistryText = "1 - Registros";
        OptionTwoConsultText = "2 - Consultar Libros";
        OptionThreeExit = "3 - Salir";
        ChooseAnOptionText = "Elige una opción: ";
        OptionOneRequestBookText = "1 - Pedir prestado un libro";
        OptionTwoReturnBookText = "2 - Regresar un libro";
        EnterBookNameText = "Ingresa el nombre del libro: ";
        BookDontExistErrorText = "Error: El libro no existe";
        NotEnoughStockErrorText = "Error: No hay ejemplares disponibles";
        MaxLoansReachedErrorText = "Error: Límite de préstamos alcanzado (máx. 2)";
        BookLoanRequestedText = "Solicitud enviada al bibliotecario.";
        ReachLibrarianForRequestText = "Acude con el bibliotecario para registrar el regreso del libro.";
        BookFoundText = "Libro encontrado.";
        BookNotFoundErrorText = "Libro no encontrado.";
        InvalidOptionErrorText = "Opción inválida.";
        OptionOneRegisterBookText = "1 - Registrar Libros";
        OptionTwoRegisterUserText = "2 - Registrar Usuarios";
        OptionThreeRegisterLoanText = "3 - Registrar Préstamo";
        OptionFourReturnBookText = "4 - Regresar Préstamo";
        OptionFiveQueriesText = "5 - Consultas";
        OptionSixExitText = "6 - Salir";
        EnterBookGenreText = "Ingresa el género: ";
        EnterBookAuthorText = "Ingresa el autor: ";
        EnterBookStockText = "Ingresa el stock: ";
        BookAddedSuccessText = "Libro registrado exitosamente.";
        ErrorEqualsErrorText = "Error: ";
        EnterUserIDText = "ID del usuario: ";
        EnterUserPasswordText = "Contraseña: ";
        EnterUserNameText = "Nombre: ";
        EnterUserAgeText = "Edad: ";
        UserRegisteredSuccessText = "Usuario registrado exitosamente.";
        UserNotFoundErrorText = "Error: Usuario no registrado";
        BookNotRegisteredErrorText = "Error: Libro no registrado";
        NoStockLeftErrorText = "Error: No hay ejemplares disponibles";
        LoanRegisteredSucessText = "Préstamo registrado exitosamente.";
        UserDoesntHaveThisBookErrorText = "Error: Este usuario no tiene prestado este libro";
        BookReturnRegisteredSuccessText = "Retorno registrado exitosamente.";
        OptionOneViewLoanRequestsText = "1 - Ver solicitudes de préstamo";
        OptionThreeReturnToMainMenuText = "3 - Regresar al menú principal";
        UserEqualsText = "Usuario: ";
        BookEqualsText = " - Libro: ";

        NameCantBeNullExceptionText = "Nombre no puede estar vacío";
        GenreCantBeNullExceptionText = "Género no puede estar vacío";
        AuthorCantBeNullExceptionText = "Autor no puede estar vacío";
        StockCantBeNegativeExceptionText = "Stock no puede ser negativo";
        IDCantBeNullExceptionText = "ID no puede estar vacío";
        IDMustBe8NumbersExceptionText = "ID debe tener 8 números exactamente";
        PasswordCantBeNullExceptionText = "Contraseña no puede ser vacía";
        NameCantContainNumbersExceptionText = "Nombre no puede contener números";
        AgeCantBeNegativeExceptionText = "Edad no puede ser negativa";
        TypeMustBeUserOrLibrarianExceptionText = "Tipo debe ser 'user' o 'librarian'";
        ActiveLoanCantBeNegativeExceptionText = "Préstamos activos no pueden ser negativos";
        PastLoanCantBeNegativeExceptionText = "Préstamos pasados no pueden ser negativos";
        BookNameCantBeNullExceptionText = "Nombre del libro no puede estar vacío";
    }
}