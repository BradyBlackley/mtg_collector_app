package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Color;
import com.example.mtg.model.ColorIdentity;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:schema-h2.sql", "classpath:data/ColorIdentity.sql"})
class ColorIdentityJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    ColorIdentityJdbcRepository repository;

    @Test
    void findByCardId() {
        assertEquals(2, repository.findByCardId("ZNR150").getColors().size());
        assertEquals("red", repository.findByCardId("ZNR150").getColors().get(0).label);
        assertEquals("green", repository.findByCardId("ZNR150").getColors().get(1).label);
    }

    @Test
    void add() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setColors(colors);
        colorIdentity.setCard(repository.findByCardId("ZNR150").getCard());

        assertNotNull(repository.add(colorIdentity));
    }

    @Test
    void update() {
        assertTrue(repository.update(repository.findByCardId("ZNR150")));
    }

    @Test
    void delete() {
        assertTrue(repository.delete(repository.findByCardId("ZNR150")));
        assertNull(repository.findByCardId("ZNR150"));
    }
}