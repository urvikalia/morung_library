package org.morung.library.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book extends LibraryItem implements Renewable,Borrowable{


    public Book(String ISBN, String title, String author, String publisher, LocalDate publishedDate) {
        super(ISBN, title, author, publisher, publishedDate);
        MAX_LOAN_PERIOD = 10;

    }
    public Book(String ISBN, String title, String author) {
        super(ISBN, title, author);
        MAX_LOAN_PERIOD = 10;
    }


    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + getISBN() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", publishedDate=" + getPublishedDate() + '\'' +
                ", genre=" + getGenre() + '\'' +
                ", available_status=" + getAvailableStatus() + +'\'' +
                ", literary_period='" + getLiterary_period() + '\'' +
                ", MAX_LOAN_PERIOD=" + MAX_LOAN_PERIOD +
                '}';
    }
}


