package org.morung.library.business;
import org.morung.library.models.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> items;

    public List<LibraryItem> getItems() {
        return items;
    }

   public boolean add(LibraryItem book) {
        return(this.items.add(book));
   }

    public Library() {
        this.items = new ArrayList<>();
    }

    public LibraryItem searchByTitle(String title) {
        for (LibraryItem book : getItems()) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
   }
   public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> books = new ArrayList<>();

        for(LibraryItem book : getItems()) {
            if(author.equalsIgnoreCase(book.getAuthor())) {
                books.add(book);
            }
        }
        return books;
   }

}
