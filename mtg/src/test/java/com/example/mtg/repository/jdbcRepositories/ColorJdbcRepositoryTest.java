package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Color;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Color.sql"})
@ContextConfiguration(
        classes = {ColorJdbcRepository.class}
)
class ColorJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    ColorJdbcRepository repository;

    @Test
    void findAllColors() {
        assertNotNull(repository.findAllColors());
        assertEquals(2, repository.findAllColors().size());
        assertEquals(1, repository.findAllColors().get(0).getColorId());
        assertEquals("black", repository.findAllColors().get(0).getColorName());
        assertEquals(2, repository.findAllColors().get(1).getColorId());
        assertEquals("green", repository.findAllColors().get(1).getColorName());
    }

    @Test
    void findColorById() {
        assertNotNull(repository.findColorById(1));
        assertNull(repository.findColorById(0));
        assertEquals("black", repository.findColorById(1).getColorName());
        assertEquals("green", repository.findColorById(2).getColorName());
    }

    @Test
    void findColorByName() {
        assertNotNull(repository.findColorByName("black"));
        assertNull(repository.findColorByName("pink"));
        assertEquals("black", repository.findColorByName("black").getColorName());
        assertEquals(1, repository.findColorByName("black").getColorId());
        assertEquals("green", repository.findColorByName("green").getColorName());
        assertEquals(2, repository.findColorByName("green").getColorId());
    }

    @Test
    void add() {
        assertNotNull(repository.add(makeColor()));
        assertEquals(3, repository.findAllColors().size());
        assertEquals("red", repository.findColorByName("red").getColorName());
        assertEquals(3, repository.findColorByName("red").getColorId());
    }

    @Test
    void update() {
        Color color = repository.findColorById(1);
        color.setColorName("blue");
        assertTrue(repository.update(color));
        assertEquals("blue", repository.findColorById(1).getColorName());
        assertEquals(1, repository.findColorById(1).getColorId());
        assertEquals(2, repository.findAllColors().size());
    }

    @Test
    void deleteByName() {
        assertFalse(repository.deleteByName("pink"));
        assertTrue(repository.deleteByName("black"));
        assertEquals(1, repository.findAllColors().size());
    }

    private Color makeColor() {
        return new Color("red");
    }
}