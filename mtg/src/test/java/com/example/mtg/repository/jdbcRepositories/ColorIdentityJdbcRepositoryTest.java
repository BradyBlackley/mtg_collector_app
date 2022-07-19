package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/ColorIdentity.sql"})
@ContextConfiguration(
        classes = {ColorIdentityJdbcRepository.class}
)
class ColorIdentityJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    ColorIdentityJdbcRepository repository;

    @Test
    void findAll() {
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void findByColorIdentityId() {
        assertEquals("ZNR150", repository.findByColorIdentityId(1).getCard().getCardId());
        assertEquals("black", repository.findByColorIdentityId(1).getColors().get(0).getColorName());
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