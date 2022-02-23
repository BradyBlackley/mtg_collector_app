package com.example.mtg.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Collection.sql"})
@ContextConfiguration(
        classes = {CollectionJdbcRepository.class}
)
class CollectionJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    CollectionJdbcRepository repository;

    @Test
    void findAll() {
        assertEquals(repository.findAll().size(), 2);
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
    void deleteById() {
    }
}