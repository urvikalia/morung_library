package org.morung.library.models;

import java.time.LocalDate;

public class EBook extends LibraryItem {

    public EBook(String ISBN, String title, String author, String publisher, LocalDate publishedDate) {
        super(ISBN, title, author, publisher, publishedDate);
        CHECKOUT_DAYS = 30;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "ISBN='" + getISBN() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", publishedDate=" + getPublishedDate() + '\'' +
                ", genre=" + getGenre() + '\'' +
                ", available_status=" + getAvailableStatus() + +'\'' +
                ", literary_period='" + getLiterary_period() + '\'' +
                ", CHECKOUT_DAYS=" + CHECKOUT_DAYS +
                '}';
    }
}
