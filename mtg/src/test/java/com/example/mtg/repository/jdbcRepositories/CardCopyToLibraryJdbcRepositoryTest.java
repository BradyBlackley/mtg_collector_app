package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Card;
import com.example.mtg.model.CardCopy;
import com.example.mtg.model.CardCopyToLibrary;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/CardCopyToLibrary.sql"})
@ContextConfiguration(
        classes = {CardCopyToLibraryJdbcRepository.class}
)
class CardCopyToLibraryJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    CardCopyToLibraryJdbcRepository repository;

    @Test
    void findByLibraryId() {
        CardCopyToLibrary cardCopyToLibrary = repository.findByLibraryId(0);
        assertEquals(1, repository.findByLibraryId(0).getCardCopies().size());
    }

    @Test
    void add() {

    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }
}