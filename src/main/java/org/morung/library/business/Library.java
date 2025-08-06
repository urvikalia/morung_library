package org.morung.library.business;

import org.morung.library.models.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

   public boolean add(Book book) {
        return(this.books.add(book));
   }

    public Library() {
        this.books = new ArrayList<>();
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
   }
   public List<Book> searchByAuthor(String author) {
        List<Book> books = new ArrayList<>();

        for(Book book : books) {
            if(author.equals(book.getAuthor())) {
                books.add(book);
            }
        }
        return books;
   }

}
