package org.morung.library.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.morung.library.exceptions.NoDataFoundException;
import org.morung.library.models.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {


    LibrarySystem librarySystem;

    @BeforeEach
    void setUp() {
        librarySystem = new LibrarySystem();
    }

    @Test
    void searchBookByTitle() {
        Book book1 = new Book("978-1001-123", "title1", "Khalis", "publisher", LocalDate.now());
        Book book2 = new Book("978-1001-123", "title2", "Khalis", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.addBook(book2);
        assertThrows(NoDataFoundException.class, () -> librarySystem.searchBookByTitle("title"));


    }

    @Test
    void searchBookByAuthor() {

        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        Book book2 = new Book("978-1001-123", "title2", "author1", "publisher", LocalDate.now());
        Book book3 = new Book("978-1001-123", "title2", "author", "publisher", LocalDate.now());

        librarySystem.addBook(book1);
        librarySystem.addBook(book2);
        librarySystem.addBook(book2);
        assertThrows(NoDataFoundException.class, () -> librarySystem.searchBookByAuthor("author0"));
    }

    @Test
    void checkoutBook() {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        boolean isCheckedOut= librarySystem.checkoutItem(searchedItem.getItemId(), user.getUserId());
        assertTrue(isCheckedOut);
        assertFalse(librarySystem.searchBookByTitle("title1").isAvailable_status());
        user = librarySystem.getUser("urvi");
        ItemHistory history =user.getBorrowingDetails(searchedItem.getItemId());
        assertNotNull(history);
        assertNotNull(history.getExpectedReturnedDate());
        System.out.println("Checkout Book");
        System.out.println(history.toString());
    }

    @Test
    void checkOutWrongBook()
    {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        assertThrows(NoDataFoundException.class, () -> librarySystem.checkoutItem(100, user.getUserId()));
    }

    @Test
    void checkOutWrongUser()
    {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        assertThrows(NoDataFoundException.class, () -> librarySystem.checkoutItem(searchedItem.getItemId(), 100));
    }

    @Test
    void returnBook() {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        boolean isCheckedOut= librarySystem.checkoutItem(searchedItem.getItemId(), user.getUserId());

        boolean isReturned = librarySystem.returnItem(searchedItem.getItemId(), user.getUserId());
        assertTrue(isCheckedOut);

        assertTrue(librarySystem.searchBookByTitle("title1").isAvailable_status());
        user = librarySystem.getUser("urvi");
        ItemHistory history =user.getBorrowingDetails(searchedItem.getItemId());
        assertNotNull(history);
        assertNotNull(history.getReturnedOn());
        System.out.println("Return Book ");
        System.out.println(history.toString());

    }

    @Test
    void returnInvalidBook()
    {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        boolean isCheckedOut= librarySystem.checkoutItem(searchedItem.getItemId(), user.getUserId());

        assertThrows(NoDataFoundException.class, () -> librarySystem.returnItem(100, user.getUserId()));
    }

    @Test
    void returnWithWrongUser()
    {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        boolean isCheckedOut= librarySystem.checkoutItem(searchedItem.getItemId(), user.getUserId());

        assertThrows(NoDataFoundException.class, () -> librarySystem.returnItem(searchedItem.getItemId(), 100));
    }

    @Test
    void renewal()
    {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(book1);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        boolean isCheckedOut= librarySystem.checkoutItem(searchedItem.getItemId(), user.getUserId());

        boolean isRenewed = librarySystem.renewalItem(searchedItem.getItemId(), user.getUserId());
        assertTrue(isCheckedOut);
        assertFalse(librarySystem.searchBookByTitle("title1").isAvailable_status());

        ItemHistory history =user.getBorrowingDetails(searchedItem.getItemId());
        assertNotNull(history);
        assertNull(history.getReturnedOn());
        System.out.println("Renew Book ");
        System.out.println(history.toString());

    }

    void renewalEBook()
    {
        LibraryItem item = new EBook("978-1001-123", "title1", "author1", "publisher", LocalDate.now());
        librarySystem.addBook(item);
        librarySystem.registerUser("urvi", "chincwad", "urvikalia@gmail.com", "9011057430", 42, UserType.REGULAR.toString());
        LibraryItem searchedItem =librarySystem.searchBookByTitle("title1");
        User user = librarySystem.getUser("urvi");
        boolean isCheckedOut= librarySystem.checkoutItem(searchedItem.getItemId(), user.getUserId());

        assertThrows(NoDataFoundException.class, () -> librarySystem.renewalItem(searchedItem.getItemId(), user.getUserId()));

    }





}