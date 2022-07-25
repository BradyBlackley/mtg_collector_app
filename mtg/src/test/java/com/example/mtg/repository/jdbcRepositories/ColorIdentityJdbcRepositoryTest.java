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

@Sql({"classpath:data/ColorIdentity.sql"})
@ContextConfiguration(
        classes = {ColorIdentityJdbcRepository.class}
)
class ColorIdentityJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    ColorIdentityJdbcRepository repository;

    @Test
    void findByCardId() {
        assertEquals(2, repository.findByCardId("ZNR150").getColors().size());
        assertEquals("black", repository.findByCardId("ZNR150").getColors().get(0).getColorName());
        assertEquals("green", repository.findByCardId("ZNR150").getColors().get(1).getColorName());
    }

    @Test
    void add() {
        Color red = new Color(3,"red");
        Color white = new Color(4,"white");
        Color blue = new Color(5,"blue");
        List<Color> colors = new ArrayList();
        colors.add(red);
        colors.add(white);
        colors.add(blue);
        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setColors(colors);
        colorIdentity.setCard(repository.findByCardId("ZNR150").getCard());

        assertNotNull(repository.add(colorIdentity));
    }

    @Test
    void update() {
        assertTrue(repository.update(repository.findByCardId("ZNR150"), "ZNR150", 6));
    }

    @Test
    void delete() {
        assertTrue(repository.delete(repository.findByCardId("ZNR150")));
        assertNull(repository.findByCardId("ZNR150"));
    }
}