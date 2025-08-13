package org.morung.library.models;

public class Transaction   {

    private TransactionType type;
    private Book book;
    private User borrower;

    public Transaction(TransactionType type, Book book, User borrower) {
        this.type = type;
        this.book = book;
        this.borrower = borrower;
    }

    public Transaction(String type, Book book, User borrower) {
        this.type = TransactionType.valueOf(type);
        this.book = book;
        this.borrower = borrower;
    }
    
}
