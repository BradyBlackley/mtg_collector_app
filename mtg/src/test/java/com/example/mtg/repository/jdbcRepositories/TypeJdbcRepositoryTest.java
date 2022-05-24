package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Type;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Type.sql"})
@ContextConfiguration(
        classes = {TypeJdbcRepository.class}
)
class TypeJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    TypeJdbcRepository repository;

    @Test
    void findAllTypes() {
        assertNotNull(repository.findAllTypes());
        assertEquals(3, repository.findAllTypes().size());
    }

    @Test
    void findTypeByName() {
        assertNotNull(repository.findTypeByName("Creature"));
        assertNull(repository.findTypeByName("Non-existent"));
        assertEquals("Creature", repository.findTypeByName("Creature").getTypeName());
        assertEquals(2, repository.findTypeByName("Creature").getTypeId());
    }

    @Test
    void add() {
        Type type = new Type("Dragon");
        assertNotNull(repository.add(type));
        assertEquals(4, repository.findAllTypes().size());
        assertEquals("Dragon", repository.findTypeByName("Dragon").getTypeName());
        assertEquals(4, repository.findTypeByName("Dragon").getTypeId());
    }

    @Test
    void update() {
        Type type = repository.findTypeByName("Creature");
        type.setTypeName("Sorcery");
        assertTrue(repository.update(type));
        assertEquals("Sorcery", repository.findTypeByName("Sorcery").getTypeName());
    }

    @Test
    void delete() {
        Type type = repository.findTypeByName("Creature");
        assertTrue(repository.delete(type));
        assertEquals(2, repository.findAllTypes().size());
        assertNull(repository.findTypeByName("Creature"));
    }
}