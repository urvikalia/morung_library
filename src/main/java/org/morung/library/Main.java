package org.morung.library;

import org.morung.library.business.LibrarySystem;
import org.morung.library.exceptions.NoDataFoundException;
import org.morung.library.models.Book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        LibrarySystem librarySystem = new LibrarySystem();


        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("****** Main Menu ******");
            System.out.println("1. Register User");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book by Author");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Review borrowing history of a User");
            System.out.println("6. Exit");

            //Read input
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid choice");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter User name");
                    String userName = scanner.next();
                    System.out.println("Enter address");
                    String address = scanner.nextLine();
                    System.out.println("Enter email");
                    String email = scanner.nextLine();
                    ;
                    System.out.println("Enter phone number");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter age");
                    long age = scanner.nextLong();
                    boolean isCreated = librarySystem.registerUser(userName, address, email, phoneNumber, age);
                    if (isCreated)
                        System.out.println("User registered successfully!");
                    else
                        System.out.println("User not registered!");
                    break;

                case 2:

                    System.out.println("Enter Book details:");
                    System.out.println("Enter ISBN:");
                    String isbn = scanner.next();
                    System.out.println("Enter Title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter Publisher:");
                    String publisher = scanner.nextLine();
                    System.out.println("Enter Published Date:");
                    LocalDateTime publishedDate = LocalDateTime.parse(scanner.next());
                    boolean isAdded = librarySystem.addBook(new Book(isbn, title, author, publisher, publishedDate));
                    if (isAdded)
                        System.out.println("Book added successfully!");
                    else
                        System.out.println("Book not added!");
                    break;
                case 3:
                    System.out.println("Enter the Author name by which you want to search:");
                    String authorName = scanner.next();
                    List<Book> books = null;
                    try {
                        books = librarySystem.searchBookByAuthor(authorName);
                    }catch (NoDataFoundException e) {
                        System.out.println("No data found!");
                        break;
                    }
                    System.out.println("Here are the books by author:" + authorName);
                    for (Book book : books)
                        System.out.println(book);
                    break;
                case 4:
                    System.out.println("Enter the Book Title by which you want to search:");
                    String searchTitle = scanner.next();
                    Book book=null;
                    try {
                         book = librarySystem.searchBookByTitle(searchTitle);
                    } catch (NoDataFoundException ex) {
                        System.out.println(ex);
                        break;
                    }
                    System.out.println("Here is the book details by title:" + searchTitle);
                    book.toString();
                    break;
                case 5:
                    //TODO: to be implemented
                    break;
                case 6:
                    System.out.println("Have a great day!! see you soon");
                    break;
            }


        } while (choice != 4);


    }
}
