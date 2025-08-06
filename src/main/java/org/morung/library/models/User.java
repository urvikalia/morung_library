package org.morung.library.models;

import org.morung.library.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long userId;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private long age;


    private List<BookHistory> borrowingHistory;

    public User(String name, String address, String email, String phoneNumber, long age) {

        boolean isValid = validate(name, address, email, phoneNumber, age);

        if (!isValid)
            throw new InvalidInputException("Invalid input. User not added to the system");

        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        borrowingHistory = new ArrayList<>();
    }

    public List<BookHistory> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void addBorrowingHistory(BookHistory bookHistory) {
        this.borrowingHistory.add(bookHistory);
    }

    private boolean validate(String name, String address, String email, String phoneNumber, long age) {
        if (name == null || address == null || email == null || phoneNumber == null || name.isEmpty() || address.isEmpty() || email.isEmpty() || phoneNumber.isEmpty())
            return false;

        if (age <= 0)
            return false;
        return true;
    }
}
