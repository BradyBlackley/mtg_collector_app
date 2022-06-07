package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Expansion;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Date;

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
        assertEquals(3, repository.findAllExpansions().size());
    }

    @Test
    void findExpansionByName() {
        assertEquals("IKO",
                repository.findExpansionByName("Ikoria: Lair of Behemoths").getExpansionCode());
        assertEquals(3,
                repository.findExpansionByName("Ikoria: Lair of Behemoths").getExpansionId());
        assertEquals(Date.valueOf("2020-04-01"),
                repository.findExpansionByName("Ikoria: Lair of Behemoths").getReleasedDate());
    }

    @Test
    void add() {
        Expansion expansion = new Expansion();
        expansion.setExpansionName("Jumpstart");
        expansion.setExpansionCode("JMP");
        expansion.setReleasedDate(Date.valueOf("2020-07-01"));
        assertNotNull(repository.add(expansion));
        assertEquals(4, repository.findAllExpansions().size());
        assertEquals("Jumpstart", repository.findExpansionByName("Jumpstart").getExpansionName());
        assertEquals("JMP", repository.findExpansionByName("Jumpstart").getExpansionCode());
        assertEquals(Date.valueOf("2020-07-01"),
                repository.findExpansionByName("Jumpstart").getReleasedDate());
    }

    @Test
    void update() {
        Expansion expansion = repository.findExpansionByName("Ikoria: Lair of Behemoths");
        expansion.setExpansionName("test");
        expansion.setReleasedDate(Date.valueOf("1901-01-01"));
        assertTrue(repository.update(expansion));
        assertNull(repository.findExpansionByName("Ikoria: Lair of Behemoths"));
        assertEquals("test", repository.findExpansionByName("test").getExpansionName());
        assertEquals(Date.valueOf("1901-01-01"), repository.findExpansionByName("test").getReleasedDate());
    }

    @Test
    void delete() {
        Expansion expansion = repository.findExpansionByName("Innistrad: Crimson Vow");
        assertTrue(repository.delete(expansion));
        assertNull(repository.findExpansionByName("Innistrad: Crimson Vow"));
    }
}