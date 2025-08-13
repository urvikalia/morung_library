package org.morung.library;

import org.morung.library.business.Library;
import org.morung.library.business.LibrarySystem;
import org.morung.library.exceptions.NoDataFoundException;
import org.morung.library.models.Book;
import org.morung.library.models.EBook;
import org.morung.library.models.ItemType;
import org.morung.library.models.LibraryItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static LibraryItem createLibraryItem(ItemType itemType, Scanner scanner) {
        System.out.println("Enter Book details:");
        System.out.println("Enter ISBN:");
        String isbn = scanner.next();
        System.out.println("Enter Title:");
        String title = scanner.next();
        System.out.println("Enter Author:");
        String author = scanner.next();
        System.out.println("Enter Publisher:");
        String publisher = scanner.next();
        System.out.println("Enter Published Date:");
        String publishedDateStr = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate publishedDate = LocalDate.parse(publishedDateStr, formatter);

        if (itemType.equals(ItemType.EBOOK)) {
            return (new EBook(isbn, title, author, publisher, publishedDate));
        } else
            return (new Book(isbn, title, author, publisher, publishedDate));

    }

    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        LibrarySystem librarySystem = new LibrarySystem();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("****** Main Menu ******");
            System.out.println("1. Register User");
            System.out.println("2. Add Book");
            System.out.println("3. Add Ebook");
            System.out.println("4. Search Book by Author");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Review borrowing history of a User");
            System.out.println("7. Exit");

            //Read input
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid choice");
                scanner.next();
            }
            choice = scanner.nextInt();
            LibraryItem book = null;

            switch (choice) {
                case 1:
                    System.out.println("Enter User name");
                    String userName = scanner.next();
                    System.out.println("Enter address");
                    String address = scanner.next();
                    System.out.println("Enter email");
                    String email = scanner.next();
                    ;
                    System.out.println("Enter phone number");
                    String phoneNumber = scanner.next();
                    System.out.println("Enter age");
                    long age = scanner.nextLong();
                    System.out.println("Enter user type (REGULAR, STUDENT, SENIOR_CITIZEN)");
                    String userType = scanner.next();
                    boolean isCreated = librarySystem.registerUser(userName, address, email, phoneNumber, age,userType);
                    if (isCreated)
                        System.out.println("User registered successfully!");
                    else
                        System.out.println("User not registered!");
                    break;

                case 2:

                    System.out.println("Enter Book details:");
                    book = createLibraryItem(ItemType.BOOK, scanner);

                    boolean isAdded = librarySystem.addBook(book);
                    if (isAdded)
                        System.out.println("Book added successfully!");
                    else
                        System.out.println("Book not added!");
                    break;
                case 3:
                    System.out.println("Enter EBook details:");
                    LibraryItem ebook = createLibraryItem(ItemType.EBOOK, scanner);
                    boolean isAddedEBook = librarySystem.addBook(ebook);
                    if (isAddedEBook)
                        System.out.println("Book added successfully!");
                    else
                        System.out.println("Book not added!");
                    break;
                case 4:
                    System.out.println("Enter the Author name by which you want to search:");
                    String authorName = scanner.next();
                    List<LibraryItem> books = null;
                    try {
                        books = librarySystem.searchBookByAuthor(authorName);
                        System.out.println("Here are the books by author:" + authorName);
                        for (LibraryItem item : books)
                            System.out.println(item);
                    } catch (NoDataFoundException e) {
                        System.out.println("No data found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter the Book Title by which you want to search:");
                    String searchTitle = scanner.next();
                    try {
                        book = librarySystem.searchBookByTitle(searchTitle);
                        System.out.println("Here is the book details by title:" + searchTitle);
                        System.out.println(book.toString());
                    } catch (NoDataFoundException ex) {
                        System.out.println(ex);
                    }
                    break;
                case 6:
                    //TODO: to be implemented
                    break;
                case 7:
                    System.out.println("Have a great day!! see you soon");
                    break;
            }


        } while (choice != 7);


    }
}
