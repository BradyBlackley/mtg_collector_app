package com.example.mtg.repository.jdbcRepositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Card.sql"})
@ContextConfiguration(
        classes = {CardJdbcRepository.class}
)
class CardJdbcRepositoryTest {

    @Autowired
    CardJdbcRepository repository;

    @Test
    void findAllCards() {
    }

    @Test
    void findCardsByName() {
    }

    @Test
    void findCardsByRarity() {
    }

    @Test
    void findCardsByArtist() {
    }

    @Test
    void findCardsByConvertedManaCost() {
    }

    @Test
    void findCardsByPower() {
    }

    @Test
    void findCardsByToughness() {
    }

    @Test
    void findCardsByExpansion() {
    }

    @Test
    void findCardsByTextBox() {
    }

    @Test
    void findCardById() {
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