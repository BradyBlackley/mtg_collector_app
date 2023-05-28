package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
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
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR150");
        card.setCardName("Moraug, Fury of Akoum");
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("6");
        card.setPower("6");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        ColorIdentity colorIdentity = new ColorIdentity();
        ColorIdentity colorIdentity1 = new ColorIdentity(card);
        ColorIdentity colorIdentity2 = new ColorIdentity(card, colors);

        assertNull(colorIdentity.getColors());

        assertEquals(card, colorIdentity1.getCard());

        assertEquals(card, colorIdentity2.getCard());
        assertEquals(colors, colorIdentity2.getColors());
    }

    @Test
    void getSetCard() {
        Card card = new Card();
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR150");
        card.setCardName("Moraug, Fury of Akoum");
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("6");
        card.setPower("6");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCard(card);

        assertEquals(card, colorIdentity.getCard());
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
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR150");
        card.setCardName("Moraug, Fury of Akoum");
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("6");
        card.setPower("6");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCard(card);
        colorIdentity.setColors(colors);

        ColorIdentity colorIdentity1 = new ColorIdentity();
        colorIdentity1.setCard(card);
        colorIdentity1.setColors(colors);

        ColorIdentity different = new ColorIdentity();
        different.setCard(card);
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
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR150");
        card.setCardName("Moraug, Fury of Akoum");
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("6");
        card.setPower("6");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCard(card);
        colorIdentity.setColors(colors);

        assertNotNull(colorIdentity.hashCode());
    }

    @Test
    void testToString() {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.RED);

        Card card = new Card();
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR150");
        card.setCardName("Moraug, Fury of Akoum");
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("6");
        card.setPower("6");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setCard(card);
        colorIdentity.setColors(colors);

        assertEquals("{\"card\":{\"cardId\":\"ZNR150\", \"cardName\":\"Moraug, Fury of Akoum\"," +
                " \"imagePath\":\"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg\", \"rarity\":\"mythic\"," +
                " \"artistName\":\"Rudy Siswanto\", \"convertedManaCost\":\"6\", \"power\":\"6\", \"toughness\":\"6\"," +
                " \"expansion\":{\"expansionId\":242, \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\"," +
                " \"releasedDate\":\"2020-09-01\"}, \"textBox\":\"Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.\"," +
                " \"backCard\":\"null\"}, \"colors\":[{\"colorId\":6, \"colorName\":\"green\"}, {\"colorId\":5, \"colorName\":\"red\"}]}",
                colorIdentity.toString());
    }
}