package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColorIdentityTest {

    @Test
    void constructorTests() {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        Card card = new Card();
        card.setCardId("ZNR150");

        ColorIdentity colorIdentity = new ColorIdentity();
        ColorIdentity colorIdentity1 = new ColorIdentity(card.getCardId());
        ColorIdentity colorIdentity2 = new ColorIdentity(card.getCardId(), colors);

        assertNull(colorIdentity.getColors());

        assertEquals(card.getCardId(), colorIdentity1.getCardId());

        assertEquals(card.getCardId(), colorIdentity2.getCardId());
        assertEquals(colors, colorIdentity2.getColors());
    }

    @Test
    void getSetCard() {
        Card card = new Card();
        card.setCardId("ZNR150");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCardId(card.getCardId());

        assertEquals(card.getCardId(), colorIdentity.getCardId());
    }

    @Test
    void getSetColors() {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setColors(colors);

        assertEquals(colors, colorIdentity.getColors());
    }

    @Test
    void testEquals() {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        List<Color> differentColors = new ArrayList<>();
        differentColors.add(Color.BLACK);
        differentColors.add(Color.BLUE);

        Card card = new Card();
        card.setCardId("ZNR150");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCardId(card.getCardId());
        colorIdentity.setColors(colors);

        ColorIdentity colorIdentity1 = new ColorIdentity();
        colorIdentity1.setCardId(card.getCardId());
        colorIdentity1.setColors(colors);

        ColorIdentity different = new ColorIdentity();
        different.setCardId(card.getCardId());
        different.setColors(differentColors);

        assertFalse(colorIdentity.equals(different));
        assertTrue(colorIdentity.equals(colorIdentity1));
    }

    @Test
    void testHashCode() {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        Card card = new Card();
        card.setCardId("ZNR150");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCardId(card.getCardId());
        colorIdentity.setColors(colors);

        assertNotNull(colorIdentity.hashCode());
    }

    @Test
    void testToString() {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        Card card = new Card();
        card.setCardId("ZNR150");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCardId(card.getCardId());
        colorIdentity.setColors(colors);

        assertEquals("{\"cardId\":\"ZNR150\", \"colors\":[{\"colorId\":6, \"colorName\":\"green\"}, {\"colorId\":5, \"colorName\":\"red\"}]}",
                colorIdentity.toString());
    }
}