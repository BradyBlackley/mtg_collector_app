package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Expansion.sql"})
@ContextConfiguration(
        classes = {ExpansionJdbcRepository.class}
)
class ExpansionJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    ExpansionJdbcRepository repository;

    @Test
    void findAllExpansions() {
    }

    @Test
    void findExpansionByName() {
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