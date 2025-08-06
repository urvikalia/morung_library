package org.morung.library.business;

import org.morung.library.exceptions.NoDataFoundException;
import org.morung.library.models.Book;
import org.morung.library.models.User;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private Library library;
    private List<User> members;

    public LibrarySystem() {
        this.library = new Library();
        this.members = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return (library.add(book));
    }

    public Book searchBookByTitle(String title) {

        Book book = library.searchByTitle(title);
        if (book == null)
            throw new NoDataFoundException("No book found with title " + title);
        return book;
    }

    public List<Book> searchBookByAuthor(String author) {
       List<Book> books = library.searchByAuthor(author);
        if (books.isEmpty())
            throw new NoDataFoundException("No book found with author " + author);
        return books;
    }

    public boolean registerUser(String userName, String address, String email, String phoneNumber,long age) {

        User user = new User(userName, address, email, phoneNumber,age);
        return members.add(user);
    }

}
