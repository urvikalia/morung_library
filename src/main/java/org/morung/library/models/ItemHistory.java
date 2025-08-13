package org.morung.library.models;

import java.util.Date;

public class ItemHistory {

    private long itemId;
    private Date borrowedOn;
    private Date expectedReturnedDate;
    private Date returnedOn;

    public ItemHistory(long itemId, Date borrowedOn, Date expectedReturnedDate) {
        this.itemId = itemId;
        this.borrowedOn = borrowedOn;
        this.expectedReturnedDate = expectedReturnedDate;
        this.returnedOn = null;
    }

    public void setReturnedOn(Date returnedOn) {
        this.returnedOn = returnedOn;
    }

    public Date getReturnedOn() {
        return returnedOn;
    }

    public Date getExpectedReturnedDate() {
        return expectedReturnedDate;
    }

    public long getItemId() {
        return itemId;
    }
}
