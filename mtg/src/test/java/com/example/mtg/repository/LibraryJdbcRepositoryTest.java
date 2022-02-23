package com.example.mtg.repository;

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

    }

    @Test
    void add() {

    }

    @Test
    void update() {

    }

    @Test
    void deleteById() {

    }
}