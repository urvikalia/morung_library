package org.morung.library.utils;

import org.morung.library.exceptions.InvalidInputException;
import org.morung.library.models.Book;
import org.morung.library.models.LibraryItem;
import org.morung.library.models.RegularUser;
import org.morung.library.models.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.Long.*;

public class LibraryPreloader {

    public static List<String> readLinesFromResources(String filename){
        InputStream inputStream = LibraryPreloader.class.getClassLoader().getResourceAsStream(filename);
        if(inputStream == null)
            throw new InvalidInputException("Resource not found: " + filename);
        List<String> lines;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().collect(Collectors.toList());
    }

    public static List<LibraryItem> preloadLibraryItems()
    {
        List<LibraryItem> items = new ArrayList<>();
        readLinesFromResources("book.txt").forEach(line -> {
            String[] elements = line.split(",");
            String isbn = elements[0].trim();
            String title = elements[1].trim();
            String author = elements[2].trim();
            LibraryItem  item = new Book(isbn, title, author);
            items.add(item);
        });
        return items;
    }

    public static List<User> preloadMembers()
    {
        List<User> members = new ArrayList<>();
        readLinesFromResources("users.txt").stream().map(line -> line.split(",")).forEach(elements -> {
            String userName = elements[0].trim();
            String address = elements[1].trim();
            String email = elements[2].trim();
            String phoneNumber = elements[3].trim();
            String age = elements[4].trim();
            RegularUser regularUser = new RegularUser(userName, address, email, phoneNumber, parseInt(age));
            members.add(regularUser);
        });
        return members;
    }

}
