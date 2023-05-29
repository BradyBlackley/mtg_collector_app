package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Keyword;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:schema-h2.sql", "classpath:data/Keyword.sql"})
class KeywordJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    KeywordJdbcRepository repository;

    @Test
    void findAllKeywords() {
        assertNotNull(repository.findAllKeywords());
        assertEquals(3, repository.findAllKeywords().size());
        assertEquals(1, repository.findAllKeywords().get(0).getKeywordId());
        assertEquals("Double Strike", repository.findAllKeywords().get(0).getKeywordName());
    }

    @Test
    void findKeywordById() {
        assertNotNull(repository.findKeywordById(1));
        assertEquals(3, repository.findKeywordById(3).getKeywordId());
        assertEquals("Vigilance", repository.findKeywordById(3).getKeywordName());
    }

    @Test
    void findKeywordByName() {
        assertNotNull(repository.findKeywordByName("Flying"));
        assertEquals(2, repository.findKeywordByName("Flying").getKeywordId());
        assertEquals("Flying", repository.findKeywordByName("Flying").getKeywordName());
    }

    @Test
    void add() {
        Keyword keyword = new Keyword("Menace");
        assertNotNull(repository.add(keyword));
        assertEquals(4, repository.findKeywordById(4).getKeywordId());
        assertEquals("Menace", repository.findKeywordById(4).getKeywordName());
    }

    @Test
    void update() {
        Keyword keyword = repository.findKeywordById(2);
        keyword.setKeywordName("Flash");
        assertTrue(repository.update(keyword));
        assertEquals(3, repository.findAllKeywords().size());
    }

    @Test
    void delete() {
        Keyword keyword = repository.findKeywordByName("Flying");
        assertTrue(repository.delete(keyword));
    }
}