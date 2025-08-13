package org.morung.library.models;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class LibraryItem {

    private static final AtomicLong itemIdGenerator = new AtomicLong(1);

    private long itemId;
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
    private List<String> genre;
    private boolean available_status = true;
    private String literary_period;
    long MAX_LOAN_PERIOD = 10;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public List<String> getGenre() {
        return genre;
    }

    public boolean isAvailable_status() {
        return available_status;
    }

    public String getLiterary_period() {
        return literary_period;
    }

    public long getMAX_LOAN_PERIOD() {
        return MAX_LOAN_PERIOD;
    }

    public String getAvailableStatus()
    {
            return available_status ? "True" : "False";
    }

    public long getItemId() {
        return itemId;
    }

    public void setAvailable_status(boolean available_status) {
        this.available_status = available_status;
    }

    public LibraryItem(String ISBN, String title, String author, String publisher, LocalDate publishedDate) {
        this.itemId = itemIdGenerator.getAndIncrement();
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.genre = new ArrayList<>();
    }

}
