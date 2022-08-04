package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/CardToLibrary.sql"})
@ContextConfiguration(
        classes = {CardCopyToLibraryJdbcRepository.class}
)
class CardCopyToLibraryJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    CardCopyToLibraryJdbcRepository repository;

    @Test
    void findAll() {
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void findById() {

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