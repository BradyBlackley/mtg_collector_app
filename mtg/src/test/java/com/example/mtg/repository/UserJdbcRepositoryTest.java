package com.example.mtg.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({ "classpath: data/User.sql"})
@ContextConfiguration
class UserJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    UserJdbcRepository repository;

    @Test
    void findAll() {
    }

    @Test
    void findByUsername() {
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