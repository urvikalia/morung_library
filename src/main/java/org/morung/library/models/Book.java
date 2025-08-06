package org.morung.library.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Book {


    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private LocalDateTime publishedDate;
    private List<String> genre;
    private boolean available_status = true;
    private String literary_period;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String ISBN, String title, String author, String publisher, LocalDateTime publishedDate) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.genre = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", genre=" + genre +
                ", available_status=" + available_status +
                ", literary_period='" + literary_period + '\'' +
                '}';
    }
}
