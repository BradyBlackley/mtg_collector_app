package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Library;
import com.example.mtg.model.User;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:schema-h2.sql", "classpath:data/Library.sql"})
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
                        .get(0).getUserId());
    }

    @Test
    void findLibraryByName() {
        assertNull(repository.findLibraryByName("Not a library",
                "5d209ac0-9102-11ec-b909-0242ac120002"));
        assertNotNull(repository.findLibraryByName("Burn Deck",
                "5d209ac0-9102-11ec-b909-0242ac120002"));
        assertNotNull(repository.findLibraryByName("Zombie Deck",
                "5d209ac0-9102-11ec-b909-0242ac120002"));
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findLibraryByName("Zombie Deck",
                        "5d209ac0-9102-11ec-b909-0242ac120002").getUserId());
    }

    @Test
    void add() {
        String userId = repository.findLibraryByName("Zombie Deck",
                "5d209ac0-9102-11ec-b909-0242ac120002").getUserId();
        Library library = new Library("Dragon Deck", userId);

        assertNotNull(repository.add(library));

        assertEquals("Dragon Deck",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size() - 1)
                        .getLibraryName());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002")
                        .get(repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size() - 1)
                        .getUserId());
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
        Library library = repository.findLibraryByName("Rogue Deck",
                "5d209ac0-9102-11ec-b909-0242ac120002");
        assertTrue(repository.delete(library));
        assertEquals(2, repository.findAllLibrariesByUser("5d209ac0-9102-11ec-b909-0242ac120002").size());
    }
}