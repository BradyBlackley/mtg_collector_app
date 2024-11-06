package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.*;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:schema-h2.sql", "classpath:data/CardCopyToLibrary.sql"})
class CardCopyToLibraryJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    CardCopyToLibraryJdbcRepository repository;

    @Test
    void findByLibraryId() {
        assertNull(repository.findByLibraryId(-1));
        assertEquals(1, repository.findByLibraryId(1).getCardCopies().size());
    }

    @Test
    void add() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        Library library = new Library();
        library.setLibraryId(2);
        library.setLibraryName("Zombie Deck");
        library.setUserId(user.getUserId());

        List<CardCopy> cardCopies = repository.findByLibraryId(2).getCardCopies();

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setLibrary(library);
        cardCopyToLibrary.setCardCopies(cardCopies);

        assertNotNull(repository.add(cardCopyToLibrary));

        assertEquals(library, repository.findByLibraryId(2).getLibrary());
        assertEquals("ZNR134", repository.findByLibraryId(2).getCardCopies().get(1).getCard().getCardId());
    }

    @Test
    void update() {
        CardCopyToLibrary cardCopyToLibrary = repository.findByLibraryId(1);
        Library library = cardCopyToLibrary.getLibrary();
        library.setLibraryName("Dragon Deck");
        cardCopyToLibrary.setLibrary(library);

        assertTrue(repository.update(cardCopyToLibrary));
    }

    @Test
    void delete() {
        CardCopyToLibrary cardCopyToLibrary = repository.findByLibraryId(1);
        assertTrue(repository.delete(cardCopyToLibrary));
    }
}