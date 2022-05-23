package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Library;
import com.example.mtg.model.User;
import com.example.mtg.repository.CommonRepoTest;
import com.example.mtg.repository.jdbcRepositories.LibraryJdbcRepository;
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
        assertEquals(3, repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size());
        assertEquals("Burn Deck",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(0).getLibraryName());
        assertEquals("Zombie Deck",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(1).getLibraryName());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(0).getUser().getUserId());
        assertEquals("TimTheMagicMan",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(0).getUser().getUsername());
        assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(0).getUser().getPassword());
    }

    @Test
    void findLibraryByName() {
        assertNull(repository.findLibraryByName("Not a library"));
        assertNotNull(repository.findLibraryByName("Burn Deck"));
        assertNotNull(repository.findLibraryByName("Zombie Deck"));
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findLibraryByName("Zombie Deck").getUser().getUserId());
        assertEquals("TimTheMagicMan",
                repository.findLibraryByName("Zombie Deck").getUser().getUsername());
        assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", repository.findLibraryByName("Zombie Deck").getUser().getPassword());
    }

    @Test
    void add() {
        User user = repository.findLibraryByName("Zombie Deck").getUser();
        Library library = new Library("Dragon Deck", user);

        assertNotNull(repository.add(library));

        assertEquals("Dragon Deck",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size() - 1)
                        .getLibraryName());
        assertEquals("TimTheMagicMan",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size() - 1)
                        .getUser().getUsername());
    }

    @Test
    void update() {
        Library library = repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                .get(1);
        library.setLibraryName("Dragon Destruction");
        assertTrue(repository.update(library));
        assertEquals("Dragon Destruction",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(1).getLibraryName());
    }

    @Test
    void delete() {
        Library library = repository.findLibraryByName("Rogue Deck");
        assertTrue(repository.delete(library));
        assertEquals(2, repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size());
    }
}