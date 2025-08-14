package org.morung.library.models;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Transaction   {

    private static final AtomicLong transactionIdGenerator = new AtomicLong(1);

    private long id;
    private TransactionType type;
    private LocalDate date;
    private long userId;
    private long itemId;

    public Transaction(TransactionType type, long userId, long itemId) {
        this.id = transactionIdGenerator.getAndIncrement();
        this.type = type;
        this.date = LocalDate.now();
        this.userId = userId;
        this.itemId = itemId;
    }

    public TransactionType getType() {
        return type;
    }
}
