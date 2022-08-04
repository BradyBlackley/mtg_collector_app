package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/CardToLibrary.sql"})
@ContextConfiguration(
        classes = {CardCopyJdbcRepository.class}
)
class CardToLibraryJdbcRepositoryTest extends CommonRepoTest {

    @Test
    void findAll() {
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