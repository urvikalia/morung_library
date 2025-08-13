package org.morung.library.models;

import java.time.LocalDate;


public class ItemHistory {

    private long itemId;
    private LocalDate borrowedOn;
    private LocalDate expectedReturnedDate;
    private LocalDate returnedOn;

    public ItemHistory(long itemId, LocalDate borrowedOn, LocalDate expectedReturnedDate) {
        this.itemId = itemId;
        this.borrowedOn = borrowedOn;
        this.expectedReturnedDate = expectedReturnedDate;
        this.returnedOn = null;
    }

    public void setReturnedOn(LocalDate returnedOn) {
        this.returnedOn = returnedOn;
    }

    public LocalDate getReturnedOn() {
        return returnedOn;
    }

    public LocalDate getExpectedReturnedDate() {
        return expectedReturnedDate;
    }

    public long getItemId() {
        return itemId;
    }

    public void setExpectedReturnedDate(LocalDate expectedReturnedDate) {
        this.expectedReturnedDate = expectedReturnedDate;
    }

    @Override
    public String toString() {
        return "ItemHistory{" +
                "itemId=" + itemId +
                ", borrowedOn=" + borrowedOn +
                ", expectedReturnedDate=" + expectedReturnedDate +
                ", returnedOn=" + returnedOn +
                '}';
    }
}
