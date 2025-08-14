package org.morung.library.utils;

import org.junit.jupiter.api.Test;
import org.morung.library.models.LibraryItem;
import org.morung.library.models.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryPreloaderTest {


    @Test
    void preloadLibraryItems() {
        List<LibraryItem> items = LibraryPreloader.preloadLibraryItems();
        assertTrue(items.size() > 0);
        assertEquals(9, items.size());
    }

    @Test
    void preloadMembers() {
        List<User> members = LibraryPreloader.preloadMembers();
        assertTrue(members.size() > 0);
        assertEquals(5, members.size());
    }
}