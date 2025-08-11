package org.morung.library.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.morung.library.exceptions.NoDataFoundException;
import org.morung.library.models.Book;

import java.time.LocalDate;
import java.time.LocalDateTime;

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



}