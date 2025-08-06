package org.morung.library.business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.morung.library.models.Book;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;
    @BeforeEach
    void setUp() {
        library = new Library();
    }


    @org.junit.jupiter.api.Test
    void getBooks() {
        Book book1 = new Book("978-1001-123", "A thousand Splendid Sun", "Khalis", "publisher", LocalDateTime.now());
        library.add(book1);
        List<Book> books = library.getBooks();
        assertEquals(1, books.size());

    }

    @org.junit.jupiter.api.Test
    void add() {
        Book book1 = new Book("978-1001-123", "A thousand Splendid Sun", "Khalis", "publisher", LocalDateTime.now());
        library.add(book1);
        List<Book> books = library.getBooks();
        assertEquals(book1.toString(), books.get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void searchByTitle() {
        Book book1 = new Book("978-1001-123", "title1", "Khalis", "publisher", LocalDateTime.now());
        Book book2 = new Book("978-1001-123", "title2", "Khalis", "publisher", LocalDateTime.now());

        library.add(book1);
        library.add(book2);
        List<Book> books = library.getBooks();
        Book searchedBook = library.searchByTitle("title1");
        assertEquals(book1.getTitle(), "title1");



    }

    @org.junit.jupiter.api.Test
    void searchByAuthor() {
        Book book1 = new Book("978-1001-123", "title1", "author1", "publisher", LocalDateTime.now());
        Book book2 = new Book("978-1001-123", "title2", "author1", "publisher", LocalDateTime.now());
        Book book3 = new Book("978-1001-123", "title2", "author", "publisher", LocalDateTime.now());

        library.add(book1);
        library.add(book2);
        library.add(book2);
        List<Book> books = library.searchByAuthor("author1");
        assertEquals(book1.getAuthor(), "author1");


    }
}