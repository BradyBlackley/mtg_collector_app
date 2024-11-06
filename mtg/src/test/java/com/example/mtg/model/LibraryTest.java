package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void constructorTests() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        Library library = new Library();
        Library library1 = new Library(1);
        Library library2 = new Library("Zombie Deck", user.getUserId());
        Library library3 = new Library(1, "Zombie Deck", user.getUserId());

        assertNull(library.getLibraryName());

        assertEquals(1, library1.getLibraryId());

        assertEquals("Zombie Deck", library2.getLibraryName());
        assertEquals(user.getUserId(), library2.getUserId());

        assertEquals(1, library3.getLibraryId());
        assertEquals("Zombie Deck", library3.getLibraryName());
        assertEquals(user.getUserId(), library3.getUserId());
    }

    @Test
    void getSetLibraryId() {
        Library library = new Library();
        library.setLibraryId(1);

        assertEquals(1, library.getLibraryId());
    }

    @Test
    void getSetLibraryName() {
        Library library = new Library();
        library.setLibraryName("Zombie Deck");

        assertEquals("Zombie Deck", library.getLibraryName());
    }

    @Test
    void getSetUser() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        Library library = new Library();
        library.setUserId(user.getUserId());
    }

    @Test
    void testEquals() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        Library library = new Library();
        Library library1 = new Library();
        Library different = new Library();

        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUserId(user.getUserId());

        library1.setLibraryId(1);
        library1.setLibraryName("Zombie Deck");
        library1.setUserId(user.getUserId());

        different.setLibraryId(2);
        different.setLibraryName("Dragon Deck");
        different.setUserId(user.getUserId());

        assertFalse(library.equals(different));
        assertTrue(library.equals(library1));
    }

    @Test
    void testHashCode() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        Library library = new Library();

        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUserId(user.getUserId());

        assertNotNull(library.hashCode());
    }

    @Test
    void testToString() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        Library library = new Library();

        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUserId(user.getUserId());

        assertEquals("{\"libraryId\":1, \"libraryName\":\"Zombie Deck\", \"userId\":\"5d209ac0-9102-11ec-b909-0242ac120002\"}",
                library.toString());
    }
}