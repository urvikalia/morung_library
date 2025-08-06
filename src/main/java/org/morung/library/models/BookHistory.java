package org.morung.library.models;

import java.util.Date;

public class BookHistory {

    private long userId;
    private long bookId;
    private Date borrowedOn;
    private Date returnedOn;

    public BookHistory(long userId, long bookId, Date borrowedOn, Date returnedOn) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedOn = borrowedOn;
        this.returnedOn = returnedOn;
    }
}
