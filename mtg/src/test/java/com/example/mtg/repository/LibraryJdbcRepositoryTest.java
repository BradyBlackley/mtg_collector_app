package com.example.mtg.repository;

import com.example.mtg.model.Library;
import com.example.mtg.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Library.sql"})
@ContextConfiguration(
        classes = {LibraryJdbcRepository.class}
)
class LibraryJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    LibraryJdbcRepository repository;

    @Test
    void findAllLibrariesByUser() {
        assertTrue(repository.findAllLibrariesByUser("3f0fb9ba-94e2-11ec-b909-0242ac120002").isEmpty());
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size(), 2);
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getLibraryId(),
                1);
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getLibraryName(),
                "Burn Deck");
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(1).getLibraryName(),
                "Zombie Deck");
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getUser().getUserId(),
                "5d209ac0-9102-11ec-b909-0242ac120002");
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getUser().getUsername(),
                "TimTheMagicMan");
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getUser().getPassword(),
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
    }

    @Test
    void findLibraryById() {
        assertNull(repository.findLibraryById(0));
        assertNotNull(repository.findLibraryById(1));
        assertEquals(repository.findLibraryById(1).getLibraryName(),
                "Burn Deck");
        assertEquals(repository.findLibraryById(2).getLibraryName(),
                "Zombie Deck");
        assertEquals(repository.findLibraryById(2).getUser().getUserId(),
                "5d209ac0-9102-11ec-b909-0242ac120002");
        assertEquals(repository.findLibraryById(2).getUser().getUsername(),
                "TimTheMagicMan");
        assertEquals(repository.findLibraryById(2).getUser().getPassword(),
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
    }

    @Test
    void findLibraryByName() {
        assertNull(repository.findLibraryByName("Not a library"));
        assertNotNull(repository.findLibraryByName("Burn Deck"));
        assertNotNull(repository.findLibraryByName("Zombie Deck"));
        assertEquals(repository.findLibraryByName("Burn Deck").getLibraryId(),
                1);
        assertEquals(repository.findLibraryByName("Zombie Deck").getLibraryId(),
                2);
        assertEquals(repository.findLibraryByName("Zombie Deck").getUser().getUserId(),
                "5d209ac0-9102-11ec-b909-0242ac120002");
        assertEquals(repository.findLibraryByName("Zombie Deck").getUser().getUsername(),
                "TimTheMagicMan");
        assertEquals(repository.findLibraryByName("Zombie Deck").getUser().getPassword(),
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
    }

    @Test
    void add() {
        User user = repository.findLibraryByName("Zombie Deck").getUser();
        Library library = new Library("Dragon Deck", user);

        assertNotNull(repository.add(library));
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size(), 3);
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size() - 1)
                        .getLibraryName(),
                "Dragon Deck");
        assertEquals(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size() - 1)
                        .getUser().getUsername(),
                "TimTheMagicMan");
    }

    @Test
    void update() {

    }

    @Test
    void deleteById() {

    }
}