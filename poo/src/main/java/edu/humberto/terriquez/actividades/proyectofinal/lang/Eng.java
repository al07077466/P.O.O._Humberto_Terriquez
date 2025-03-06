package edu.humberto.terriquez.actividades.proyectofinal.lang;
/**
 * Clase que contiene los mnensajes en inglés
 */
public class Eng extends Lang {
    public Eng() {
        menu_login = 
        "\n╔═══════════════════════════╗\n" +
        "║      Log in               ║\n" +
        "╠═══════════════════════════╣\n" +
        "║ I don't have an account   ║\n" +
        "║ 1. Register               ║\n" +
        "║                           ║\n" +
        "║ I already have an account ║\n" +
        "║ 2. Log in                 ║\n" +
        "║                           ║\n" +
        "║ 3. Exit                   ║\n" +
        "╚═══════════════════════════╝";

menu_admin = 
      "\n╔══════════════════════════════════════════════════════════╗\n" +
        "║                 ADMIN MENU                               ║\n" +
        "╠══════════════════════════════════════════════════════════╣\n" +
        "║     1. Add new books to the library                      ║\n" +
        "║     2. Verify loan status                                ║\n" +
        "║     3. View active loans                                 ║\n" +
        "║     4. Manage records                                    ║\n" +
        "║     5. Exit                                              ║\n" +
        "╚══════════════════════════════════════════════════════════╝";

menu_admin_advance = 
      "\n╔══════════════════════════════════════════════════════════╗\n" +
        "║                        Records                           ║\n" +
        "╠══════════════════════════════════════════════════════════╣\n" +
        "║     1. View registered people in the library             ║\n" +
        "║     2. Show books in stock                               ║\n" +
        "║     3. View all loans of the month                       ║\n" +
        "║     4. TOP most requested books                          ║\n" +
        "║     5. TOP least requested books                         ║\n" +
        "║     6. Show overdue loans                                ║\n" +
        "║     7. Show users with overdue loans                     ║\n" +
        "║     8. Show blacklist                                    ║\n" +
        "║     9. Show honor list                                   ║\n" +
        "║     10. Exit                                             ║\n" +
        "╚══════════════════════════════════════════════════════════╝";

menu_user = 
        "\n╔══════════════════════════════════════════════╗\n" +
        "║                    MENU                      ║\n" +
        "╠══════════════════════════════════════════════╣\n" +
        "║     1. View available books                  ║\n" +
        "║     2. Request a book loan                   ║\n" +
        "║     3. Active loans                          ║\n" +
        "║     4. Return a book                         ║\n" +
        "║     5. Exit                                  ║\n" +
        "╚══════════════════════════════════════════════╝";

exit_admin_advance = 
        "\n╔═════════════════════════════╗\n" +
        "║     Exiting the records     ║\n" +
        "╚═════════════════════════════╝";
invalid_option = 
      "\n╔════════════════════════════════════════════════════════════════════════════╗\n" +
        "║    Invalid option, you cannot enter numbers that are not in the menu       ║\n" +
        "╚════════════════════════════════════════════════════════════════════════════╝";

username_prompt = 
      "\n╔══════════════════════════════════════════╗\n" +
        "║       Great, enter your username         ║\n" +
        "╚══════════════════════════════════════════╝\n";

password_prompt = 
      "\n╔═══════════════════════════════╗\n" +
        "║ Now enter your password       ║\n" +
        "╚═══════════════════════════════╝\n";

welcome_admin = 
      "\n╔═══════════════════════════╗\n" +
        "║  Welcome Administrator    ║\n" +
        "╚═══════════════════════════╝";

welcome_user = 
        "\n╔═════════════════════════════╗\n" +
        "  Welcome back, ";

welcome_user_format = 
        "\n" +
        "╚═════════════════════════════╝";

goodbye = 
      "\n╔════════════╗\n" +
        "║  Goodbye!  ║\n" +
        "╚════════════╝";

register_user = 
      "\n╔════════════════════════════════════════════════════╗\n" +
        "║         Enter a username to register               ║\n" +
        "╚════════════════════════════════════════════════════╝";

register_password = 
      "\n╔═════════════════════════════════════════╗\n" +
        "║        Enter a secure password          ║\n" +
        "╚═════════════════════════════════════════╝";

registration_success = 
      "\n╔════════════════════════════════╗\n" +
        "║  Account successfully created  ║\n" +
        "╚════════════════════════════════╝";

invalid_credentials = 
      "\n╔══════════════════════╗\n" +
        "║ Invalid credentials  ║\n" +
        "╚══════════════════════╝";

book_added = 
      "\n╔════════════════════════════════════════════╗\n" +
        "║  Book successfully added to the catalog!   ║\n" +
        "╚════════════════════════════════════════════╝";

book_borrow_success = "\nBook successfully borrowed";
book_not_available = "\nThe book is not available";
invalid_input_empty = 
      "\n╔═════════════════════════════════════════════════════╗\n" +
        "║ Invalid option, you cannot leave the field empty    ║\n" +
        "╚═════════════════════════════════════════════════════╝";

invalid_input_not_number = 
      "\n╔════════════════════════════════════════╗\n" +
        "║ Invalid option, please enter a number  ║\n" +
        "╚════════════════════════════════════════╝";

invalid_option_out_of_range = 
      "\n╔════════════════════════════════════════════════════════════╗n" +
        "║ Invalid option, you can only enter numeric characters      ║\n" +
        "╚════════════════════════════════════════════════════════════╝";

enter_book_title_prompt = 
      "\n╔════════════════════════╗\n" +
        "║ Enter the book title   ║\n" +
        "╚════════════════════════╝\n";

invalid_title = 
      "\n╔═══════════════════════════════════════╗\n" +
        "║ The book must have a name, try again  ║\n" +
        "╚═══════════════════════════════════════╝";

enter_book_author_prompt = 
      "\n╔═══════════════════════════════╗\n" +
        "║ Enter the book author         ║\n" +
        "╚═══════════════════════════════╝\n";

invalid_author = 
      "\n╔══════════════════════════════════════════╗\n" +
        "║ The book must have an author, try again. ║\n" +
        "╚══════════════════════════════════════════╝";

enter_book_isbn_prompt = 
      "\n╔═════════════════════════════╗\n" +
        "║ Enter the book ISBN         ║\n" +
        "╚═════════════════════════════╝\n";

invalid_isbn = 
      "\n╔═════════════════════════════════════════════╗\n" +
        "║ The book must have an ISBN code, try again. ║\n" +
        "╚═════════════════════════════════════════════╝";

enter_book_genre_prompt = 
      "\n╔══════════════════════════════╗\n" +
        "║ Enter the book genre         ║\n" +
        "╚══════════════════════════════╝\n";

invalid_genre = 
      "\n╔══════════════════════════════════════════════════════╗\n" +
        "║ The book must belong to a literary genre, try again. ║\n" +
        "╚══════════════════════════════════════════════════════╝";

enter_book_year_prompt = 
      "\n╔═══════════════════════════════════════════╗\n" +
        "║ Enter the year of publication of the book ║\n" +
        "╚═══════════════════════════════════════════╝\n";

year_of_publication_negative_error = 
      "\n╔═════════════════════════════════════════════╗\n" +
        "║ The year of publication cannot be negative. ║\n" +
        "╚═════════════════════════════════════════════╝";

year_of_publication_future_error = 
      "\n╔════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ The year of publication has not arrived yet. Enter a valid year (up to 2025).  ║\n" +
        "╚════════════════════════════════════════════════════════════════════════════════╝";

book_entry_success = 
      "\n╔══════════════════════════════════════════╗\n" +
        "║ The book will be registered as available ║\n" +
        "╚══════════════════════════════════════════╝";

book_borrow_name_prompt = 
      "\n╔═════════════════════════════════════════════════════════╗\n" +
        "║ Enter the ISBN of the book you want to borrow           ║\n" +
        "╚═════════════════════════════════════════════════════════╝";

no_active_loans_message = 
      "\n╔═══════════════════════════════════════════════╗\n" +
        "║ These are the books you have borrowed         ║\n" +
        "╚═══════════════════════════════════════════════╝";

no_books_borrowed_message = 
        "\nYou have no active loans\n";

show_books_in_catalog_message = 
      "\n╔════════════════════════════════════════════╗\n" +
        "║ This is our current book catalog           ║\n" +
        "╚════════════════════════════════════════════╝";

number_format_exception = 
        "\n╔══════════════════════════════════════════╗\n" +
        "║ You can only enter numbers, try again.   ║\n" +
        "╚══════════════════════════════════════════╝";

exit_admin = 
      "\n╔═════════════════════╗\n" +
        "║ Exiting admin menu  ║\n" +
        "╚═════════════════════╝";

singning_out = 
      "\n╔════════════════════════════════╗\n" +
        "║ Closing your account session   ║\n" +
        "╚════════════════════════════════╝";
        return_to_menu = 
        "\nPress ENTER to return to the menu...";

invalid_new_username = 
      "\n╔════════════════════════════════════════════════════════╗\n" +
        "║ Enter a valid username, it cannot be empty, try again. ║\n" +
        "╚════════════════════════════════════════════════════════╝";

invalid_new_password = 
      "\n╔════════════════════════════════════════════════╗\n" +
        "║ The password cannot be left blank, try again.  ║\n" +
        "╚════════════════════════════════════════════════╝";

registered_people = 
      "\n╔═══════════════════════════════════════╗\n" +
        "║ Registered people in the system are:  ║\n" +
        "╚═══════════════════════════════════════╝";

show_active_loans = 
        "\nShowing active loans...";

select_an_option = 
        "\nSelect an option: ";

author = 
        "Author: ";

title = 
        "Title: ";

isbn = 
        "ISBN: ";

genre = 
        "Genre: ";

year_book = 
        "Publication Year: ";

username = 
        "Username: ";

password = 
        "Password: ";

menu_lower = 
        "\n╔═════════════════════════════╗\n";

menu_upper = 
        "╚═════════════════════════════╝";

enter_age = 
        "╔═══════════════════╗\n" +
        "║ Enter your age    ║\n" +
        "╚═══════════════════╝\n";

age = 
        "Age: ";

age_negative = 
        "╔════════════════════════════════╗\n" +
        "║ Age cannot be negative         ║\n" +
        "╚════════════════════════════════╝\n";

error_valid_number = 
        "╔════════════════════════════╗\n" +
        "║ Enter a valid number       ║\n" +
        "╚════════════════════════════╝\n";

error_real_name = 
        "╔═══════════════════════════╗\n" +
        "║ Enter your real name      ║\n" +
        "╚═══════════════════════════╝\n";

name_with_colon = 
        "Name: ";

error_valid_name = 
        "╔════════════════════════════╗\n" +
        "║ Enter a valid name         ║\n" +
        "╚════════════════════════════╝\n";

user_showuser = 
        "║ User:  ";

name_showuser = 
        "║ Name:";

user_type_showuser = 
        "║ User type: ";

password_showuser = 
        "║ Password: ";

edad_showuser = 
        "║ Age: ";

jr_menu = 
        "╔═══════════════════════════════╗\n" +
        "║             JR Menu           ║\n" +
        "╠═══════════════════════════════╣\n" +
        "║ 1. View available books       ║\n" +
        "║ 2. Exit                       ║\n" +
        "╚═══════════════════════════════╝\n";

vip_menu = 
        "╔═══════════════════════════════════════╗\n" +
        "║               VIP Menu                ║\n" +
        "╠═══════════════════════════════════════╣\n" +
        "║ 1. View available books               ║\n" +
        "║ 2. Request a book loan                ║\n" +
        "║ 3. Active loans                       ║\n" +
        "║ 4. Return a book                      ║\n" +
        "║ 5. Exit                               ║\n" +
        "╚═══════════════════════════════════════╝\n";

teens_menu = 
        "╔═══════════════════════════════════════╗\n" +
        "║               Teens Menu              ║\n" +
        "╠═══════════════════════════════════════╣\n" +
        "║ 1. View available books               ║\n" +
        "║ 2. Request a book loan                ║\n" +
        "║ 3. Active loans                       ║\n" +
        "║ 4. Return a book                      ║\n" +
        "║ 5. Exit                               ║\n" +
        "╚═══════════════════════════════════════╝\n";

error_same_unique_code = 
        "╔═════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ The book cannot be added, a book with the same unique code already exists.  ║\n" +
        "╚═════════════════════════════════════════════════════════════════════════════╝\n";

update_loans = 
        "╔═══════════════════════════════════╗\n" +
        "║ Loans updated successfully        ║\n" +
        "╚═══════════════════════════════════╝\n";

borrowed_success = 
        "╔════════════════════════════════╗\n" +
        "║ Loan successfully completed    ║\n" +
        "╚════════════════════════════════╝\n";

adult_borrowed = 
        "╔════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ The book has been borrowed for 7 days as you are an adult user. Remember to return it on time. ║\n" +
        "╚════════════════════════════════════════════════════════════════════════════════════════════════╝\n";

enter_isbn = 
        "╔═══════════════════════════════════════════════╗\n" +
        "║ Enter the ISBN of the book you want to return ║\n" +
        "╚═══════════════════════════════════════════════╝\n";

entered_invalid_isbn = 
        "╔═══════════════════════════╗\n" +
        "║ Enter a valid ISBN        ║\n" +
        "╚═══════════════════════════╝\n";

teen_borrowed = 
        "╔═══════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ The book has been borrowed for 7 days as you are a teen user. Remember to return it on time.  ║\n" +
        "╚═══════════════════════════════════════════════════════════════════════════════════════════════╝\n";

vip_borrowed = 
        "╔══════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ The book has been borrowed for 14 days as you are a VIP user. Remember to return it on time. ║\n" +
        "╚══════════════════════════════════════════════════════════════════════════════════════════════╝\n";

fantasy = 
        "Fantasy";

got = 
        "Game of Thrones";

lotr = 
        "The Lord of the Rings";

hp = 
        "Harry Potter";

tlp = 
        "The Little Prince";

ohyos = 
        "One Hundred Years of Solitude";

dqolm = 
        "Don Quixote";

ta = 
        "The Alchemist";

tvdc = 
        "The Da Vinci Code";

tp = 
        "Perfume";

tsotw = 
        "The Shadow of the Wind";

ttob = 
        "The Book Thief";

error_modifing_date = 
        "Error processing the expiration date: ";

user_and_book_not_found = 
        "╔═══════════════════════════════════════════════╗\n" +
        "║ No active loan found for this book and user.  ║\n" +
        "╚═══════════════════════════════════════════════╝\n";

overdue_loans = 
        "Overdue loans: ";

book_alone = 
        "Book: ";

isbn_overdue_loans = 
        "║ ISBN: ";

user_overdue_loans = 
        "║ User: ";

return_date_overdue_loans = 
        "║ Return date: ";

error_comparing_dates = 
        "Error comparing dates:  ";

no_overdue_loans = 
        "╔═════════════════════════════════════════════╗\n" +
        "║ No overdue loans in the library             ║\n" +
        "╚═════════════════════════════════════════════╝\n";

error_already_exists = 
        "╔═════════════════════════════════╗\n" +
        "║ Error: The user already exists. ║\n" +
        "╚═════════════════════════════════╝\n";

user_not_found = 
        "╔════════════════════════════════╗\n" +
        "║ Error: User not found          ║\n" +
        "╚════════════════════════════════╝\n";

book_not_found = 
        "╔════════════════════════════════╗\n" +
        "║ Error: Book not found          ║\n" +
        "╚════════════════════════════════╝\n";

book_not_available = 
        "╔════════════════════════════════╗\n" +
        "║ Error: Book not available      ║\n" +
        "╚════════════════════════════════╝\n";

return_date = 
        "╔═══════════════════════╗\n" +
        "║ Return date:          ║\n" +
        "╚═══════════════════════╝\n";

no_overdue_loans = 
        "╔═══════════════════════════════════╗\n" +
        "║ No overdue loans in the library   ║\n" +
        "╚═══════════════════════════════════╝\n";

with_the_book = 
        "╔══════════════════╗\n" +
        "║ With the book    ║\n" +
        "╚══════════════════╝\n";

overload_teens = 
        "╔══════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ You can only have 1 book borrowed at a time, please return it before borrowing another.  ║\n" +
        "╚══════════════════════════════════════════════════════════════════════════════════════════╝\n";

overload_adult = 
        "╔═════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ You can only have 2 books borrowed at a time, please return one before borrowing another.   ║\n" +
        "╚═════════════════════════════════════════════════════════════════════════════════════════════╝\n";

overload_vip = 
        "╔═════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
        "║ You can only have 5 books borrowed at a time, please return one before borrowing another.   ║\n" +
        "╚═════════════════════════════════════════════════════════════════════════════════════════════╝\n";

error_saving_loans = 
        "Error saving loans: ";

loans_data_not_found = 
        "╔═════════════════════╗\n" +
        "║ No loan data found. ║\n" +
        "╚═════════════════════╝\n";

error_saving_user = 
        "Error saving users: ";

user_data_not_found = 
        "╔══════════════════════╗\n" +
        "║ No user data found.  ║\n" +
        "╚══════════════════════╝\n";

error_loading_user = 
        "╔═════════════════════════════╗\n" +
        "║ Error loading users.        ║\n" +
        "╚═════════════════════════════╝\n";

error_saving_books = 
        "Error saving books: ";

book_data_not_found = 
        "╔═════════════════════╗\n" +
        "║ No book data found. ║\n" +
        "╚═════════════════════╝\n";

error_loading_books = 
        "╔═════════════════════════════╗\n" +
        "║ Error loading books.        ║\n" +
        "╚═════════════════════════════╝\n";

succesfuly_returned = 
        "╔═════════════════════════════╗\n" +
        "║ Book successfully returned  ║\n" +
        "╚═════════════════════════════╝\n";

book_not_borrowed = 
        "╔════════════════════════════════════════════╗\n" +
        "║ Error: You do not have this book borrowed. ║\n" +
        "╚════════════════════════════════════════════╝\n";

users_with_overdue = 
        "Users with overdue loans: ";

no_users_with_overdue = 
        "╔══════════════════════════════╗\n" +
        "║ No users with overdue loans. ║\n" +
        "╚══════════════════════════════╝\n";

user_more_returned = 
        "User: ";

book_more_overdue = 
        "║ Book: ";

name_more_returned = 
        "║ Name: ";

type_more_returned = 
        "║ Type: ";

overdue_loans_more_overdue = 
        "║ Overdue loans: ";

users_with_more_returns = 
        "Users with more returned books: ";

no_users_with_returns = 
        "╔════════════════════════════════╗\n" +
        "║ No users with returned books.  ║\n" +
        "╚════════════════════════════════╝\n";

returned_loans = 
        "║ Returned loans: ";

books_arranged_by_title = 
        "Books arranged by title: ";

currently_available = 
        "Currently available";

currently_borrowed = 
        "Currently borrowed";

available_books_arranged_by_title = 
        "Available books arranged by title: ";

no_books_available_on_library = 
        "╔════════════════════════════════════╗\n" +
        "║ No books available in the library. ║\n" +
        "╚════════════════════════════════════╝\n";

popular_books = 
        "Most popular books: ";

no_popular_books = 
        "╔══════════════════════════════════╗\n" +
        "║ No popular books in the library  ║\n" +
        "╚══════════════════════════════════╝\n";

title_more_popular = 
        "Title: ";

author_more_popular = 
        "║ Author: ";

times_more_popular = 
        "║ Times borrowed: ";

unpopular_books = 
        "Least popular books: ";

no_books_on_library = 
        "╔══════════════════════════╗\n" +
        "║ No books in the library. ║\n" +
        "╚══════════════════════════╝\n";

loans_of_month = 
        "Loans of the month: ";

borrow_date_admin_loans = 
        "║ Loan date: ";

no_loans_on_month = 
        "╔══════════════════════════════════════════════╗\n" +
        "║ No loans recorded in the library this month. ║\n" +
        "╚══════════════════════════════════════════════╝\n";

active_loans = 
        "Active loans: ";

no_active_loans = 
        "╔═════════════════════════════════╗\n" +
        "║ No active loans in the library. ║\n" +
        "╚═════════════════════════════════╝\n";

active_loans_of = 
        "Active loans of ";

asset_loans = 
        "╔═══════════════════════════╗\n" +
        "║ You have no active loans. ║\n" +
        "╚═══════════════════════════╝\n";

error_book_already_registered = 
        "╔═══════════════════════════════════════════╗\n" +
        "║ Error: The book is already registered.    ║\n" +
        "╚═══════════════════════════════════════════╝\n";
users_with_more_overdue = 
        "Users with more overdue loans:  ";

    }
}
