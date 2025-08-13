package org.morung.library.models;

import org.morung.library.exceptions.InvalidInputException;

import java.util.HashMap;
import java.util.Map;

public class User {

    private long userId;
    private String userName;
    private String address;
    private String email;
    private String phoneNumber;
    private long age;
    private long MAX_LOAN_PERIOD= 10;


    private Map<Long, ItemHistory> borrowingHistory;

    public User(String name, String address, String email, String phoneNumber, long age) {

        boolean isValid = validate(name, address, email, phoneNumber, age);

        if (!isValid)
            throw new InvalidInputException("Invalid input. User not added to the system");

        this.userName = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        borrowingHistory = new HashMap<>();
    }

    public ItemHistory getBorrowingDetails(long itemId) {
        return borrowingHistory.get(itemId);

    }

    public void addBorrowingHistory(ItemHistory bookHistory) {
        this.borrowingHistory.put(bookHistory.getItemId(),bookHistory);
    }

    private boolean validate(String name, String address, String email, String phoneNumber, long age) {
        if (name == null || address == null || email == null || phoneNumber == null || name.isEmpty() || address.isEmpty() || email.isEmpty() || phoneNumber.isEmpty())
            return false;

        if (age <= 0)
            return false;
        return true;
    }

    public long get_MAX_LOAN_PERIOD() {
        return MAX_LOAN_PERIOD;
    }

    protected void set_MAX_LOAN_PERIOD(long MAX_LOAN_PERIOD) {
        this.MAX_LOAN_PERIOD = MAX_LOAN_PERIOD;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
