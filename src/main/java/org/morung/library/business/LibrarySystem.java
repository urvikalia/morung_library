package org.morung.library.business;

import org.morung.library.exceptions.NoDataFoundException;

import org.morung.library.models.LibraryItem;
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

    public boolean addBook(LibraryItem book) {
        return (library.add(book));
    }

    public LibraryItem searchBookByTitle(String title) {

        LibraryItem book = library.searchByTitle(title);
        if (book == null)
            throw new NoDataFoundException("No book found with title " + title);
        return book;
    }

    public List<LibraryItem> searchBookByAuthor(String author) {
       List<LibraryItem> books = library.searchByAuthor(author);
        if (books.isEmpty())
            throw new NoDataFoundException("No book found with author " + author);
        return books;
    }

    public boolean registerUser(String userName, String address, String email, String phoneNumber,long age) {

        User user = new User(userName, address, email, phoneNumber,age);
        return members.add(user);
    }

    public boolean checkoutItem(long itemId,long userId) {
        // find the item with the itemId .
        // find the member with userId
        // if Item not thrown exception with msg as Item not available currently
        // update book being nonavailable
        // add it in borrowing history of the given user

        return true;

    }

    public boolean returnItem(long itemId, long userId)
    {
        //validate input - item is borrowable , currently in borrowing list with returnDate =null
        // update borrowing history for the user - update return date
        // and mark the book available in the library

        return true;
    }

    public boolean renewalItem(long itemId, long userId) {
        // validate input - if Item is renewable , is currently borrowed
        // update borrowing history with expected return date :
        return true;
    }





}
