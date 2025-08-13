package org.morung.library.business;

import org.morung.library.exceptions.InvalidInputException;
import org.morung.library.exceptions.NoDataFoundException;

import org.morung.library.models.Borrowable;
import org.morung.library.models.ItemHistory;
import org.morung.library.models.LibraryItem;
import org.morung.library.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public boolean registerUser(String userName, String address, String email, String phoneNumber, long age) {

        User user = new User(userName, address, email, phoneNumber, age);
        return members.add(user);
    }

    public User getUser(long userId) {
        for (User user : members) {
            if (userId == user.getUserId())
                return user;
        }
        return null;
    }

    private void updateAvailableStatus(LibraryItem item) {
        item.setAvailable_status(false);
    }

    private LocalDate getExpectedReturnDate(LocalDate borrowDate, User user) {
        return (borrowDate.plusDays(user.get_MAX_LOAN_PERIOD()));
    }

    private void validateItem(LibraryItem libraryItem,long itemId) {
        if (libraryItem == null)
            throw new NoDataFoundException("No item found with id " + itemId);
    }

    private void validateMember(User user, long userId) {
        if (user == null) {
            throw new InvalidInputException("No user found with id " + userId);
        }
    }

    private void validateReturnItem(ItemHistory itemHistory,long itemId, long userId)
    {
        if (itemHistory == null) {
            throw new NoDataFoundException("No item borrowed by the give userid:  " + userId + " and itemid: " + itemId);
        }
        if (itemHistory.getReturnedOn() != null) {
            throw new InvalidInputException("The given item is already returned");
        }
    }

    private void validateIfBorrowable(LibraryItem libraryItem)
    {
        if (!(libraryItem instanceof Borrowable)) {
            throw new InvalidInputException("The given item is not Borrowable");
        }
    }

    private void validateItemHistoryAvailability(ItemHistory itemHistory)
    {
        if (itemHistory == null) {
            throw new NoDataFoundException("The History doesn't exists for the given user and Item");
        }
    }
    public boolean checkoutItem(long itemId, long userId) {

        LibraryItem libraryItem = library.searchById(itemId);
        validateItem(libraryItem,itemId);

        User borrower = getUser(userId);
        validateMember(borrower,userId);

        LocalDate expectedReturnDate = getExpectedReturnDate(LocalDate.now(), borrower);
        ItemHistory itemHistory = new ItemHistory(itemId, LocalDate.now(), expectedReturnDate);

        updateAvailableStatus(libraryItem);
        borrower.addBorrowingHistory(itemHistory);

        return true;

    }

    public boolean returnItem(long itemId, long userId) {

        User borrower = getUser(userId);

        validateMember(borrower,userId);

        ItemHistory itemHistory = borrower.getBorrowingDetails(itemId);
        validateReturnItem(itemHistory,itemId,userId);

        itemHistory.setReturnedOn(LocalDate.now());
        LibraryItem libraryItem = library.searchById(itemId);
        libraryItem.setAvailable_status(true);

        return true;
    }

    public boolean renewalItem(long itemId, long userId) {

        LibraryItem libraryItem = library.searchById(itemId);
        validateItem(libraryItem,itemId);

        User borrower = getUser(userId);
        validateMember(borrower,userId);

        validateIfBorrowable(libraryItem);

        ItemHistory itemHistory = borrower.getBorrowingDetails(itemId);
        validateItemHistoryAvailability(itemHistory);

        LocalDate expectedReturnDate = getExpectedReturnDate(LocalDate.now(), borrower);
        itemHistory.setExpectedReturnedDate(expectedReturnDate);

        return true;
    }


}
