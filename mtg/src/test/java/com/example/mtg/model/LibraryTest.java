package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void constructorTests() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        Library library = new Library();
        Library library1 = new Library(1);
        Library library2 = new Library("Zombie Deck", user);
        Library library3 = new Library(1, "Zombie Deck", user);

        assertNull(library.getLibraryName());

        assertEquals(1, library1.getLibraryId());

        assertEquals("Zombie Deck", library2.getLibraryName());
        assertEquals(user, library2.getUser());

        assertEquals(1, library3.getLibraryId());
        assertEquals("Zombie Deck", library3.getLibraryName());
        assertEquals(user, library3.getUser());
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
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        Library library = new Library();
        library.setUser(user);
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
        library.setUser(user);

        library1.setLibraryId(1);
        library1.setLibraryName("Zombie Deck");
        library1.setUser(user);

        different.setLibraryId(2);
        different.setLibraryName("Dragon Deck");
        different.setUser(user);

        assertFalse(library.equals(different));
        assertTrue(library.equals(library1));
    }

    @Test
    void testHashCode() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        Library library = new Library();

        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUser(user);

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
        library.setUser(user);

        assertEquals("{\"libraryId\":1, \"libraryName\":\"Zombie Deck\", \"user\":{\"userId\":\"5d209ac0-9102-11ec-b909-0242ac120002\", \"username\":\"TimTheMagicMan\", \"isAdmin\":\"false\"}}",
                library.toString());
    }
}