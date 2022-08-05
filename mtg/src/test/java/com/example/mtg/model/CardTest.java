package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void constructorTests() {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));
        Card card = new Card();
        Card card1 = new Card("ZNR150");
        Card card2 = new Card("ZNR150", "Moraug, Fury of Akoum");
        Card card3 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        Card card4 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC);
        Card card5 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
                "Rudy Siswanto");
        Card card6 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
                "Rudy Siswanto", "6");
        Card card7 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
                "Rudy Siswanto", "6", "6");
        Card card8 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
                "Rudy Siswanto", "6", "6", "6");
        Card card9 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
                "Rudy Siswanto", "6", "6", "6", expansion);
        Card card10 = new Card("ZNR150", "Moraug, Fury of Akoum",
                "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
                "Rudy Siswanto", "6", "6", "6", expansion,
                "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - " +
                        "Whenever a land enters the battlefield under your control, if it''s your main phase, there''s " +
                        "an additional combat phase after this phase. At the beginning of that combat, untap all " +
                        "creatures you control.");

        assertNull(card.getCardId());

        assertEquals("ZNR150", card1.getCardId());

        assertEquals("ZNR150", card2.getCardId());
        assertEquals("Moraug, Fury of Akoum", card2.getCardName());

        assertEquals("ZNR150", card3.getCardId());
        assertEquals("Moraug, Fury of Akoum", card3.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card3.getImagePath());

        assertEquals("ZNR150", card4.getCardId());
        assertEquals("Moraug, Fury of Akoum", card4.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card4.getImagePath());
        assertEquals(Rarity.MYTHIC, card4.getRarity());

        assertEquals("ZNR150", card5.getCardId());
        assertEquals("Moraug, Fury of Akoum", card5.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card5.getImagePath());
        assertEquals(Rarity.MYTHIC, card5.getRarity());
        assertEquals("Rudy Siswanto", card5.getArtistName());

        assertEquals("ZNR150", card6.getCardId());
        assertEquals("Moraug, Fury of Akoum", card6.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card6.getImagePath());
        assertEquals(Rarity.MYTHIC, card6.getRarity());
        assertEquals("Rudy Siswanto", card6.getArtistName());
        assertEquals("6", card6.getConvertedManaCost());

        assertEquals("ZNR150", card7.getCardId());
        assertEquals("Moraug, Fury of Akoum", card7.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card7.getImagePath());
        assertEquals(Rarity.MYTHIC, card7.getRarity());
        assertEquals("Rudy Siswanto", card7.getArtistName());
        assertEquals("6", card7.getConvertedManaCost());
        assertEquals("6", card7.getPower());

        assertEquals("ZNR150", card8.getCardId());
        assertEquals("Moraug, Fury of Akoum", card8.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card8.getImagePath());
        assertEquals(Rarity.MYTHIC, card8.getRarity());
        assertEquals("Rudy Siswanto", card8.getArtistName());
        assertEquals("6", card8.getConvertedManaCost());
        assertEquals("6", card8.getPower());
        assertEquals("6", card8.getToughness());

        assertEquals("ZNR150", card9.getCardId());
        assertEquals("Moraug, Fury of Akoum", card9.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card9.getImagePath());
        assertEquals(Rarity.MYTHIC, card9.getRarity());
        assertEquals("Rudy Siswanto", card9.getArtistName());
        assertEquals("6", card9.getConvertedManaCost());
        assertEquals("6", card9.getPower());
        assertEquals("6", card9.getToughness());
        assertEquals(expansion, card9.getExpansion());

        assertEquals("ZNR150", card10.getCardId());
        assertEquals("Moraug, Fury of Akoum", card10.getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card10.getImagePath());
        assertEquals(Rarity.MYTHIC, card10.getRarity());
        assertEquals("Rudy Siswanto", card10.getArtistName());
        assertEquals("6", card10.getConvertedManaCost());
        assertEquals("6", card10.getPower());
        assertEquals("6", card10.getToughness());
        assertEquals(expansion, card10.getExpansion());
        assertEquals("Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - " +
                "Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an " +
                "additional combat phase after this phase. At the beginning of that combat, untap all creatures you " +
                "control.", card10.getTextBox());

    }

    @Test
    void setGetCardId() {
        Card card = new Card();
        card.setCardId("ZNR150");
        assertEquals("ZNR150", card.getCardId());
    }

    @Test
    void setGetCardName() {
        Card card = new Card();
        card.setCardName("Moraug, Fury of Akoum");
        assertEquals("Moraug, Fury of Akoum", card.getCardName());
    }

    @Test
    void setGetImagePath() {
        Card card = new Card();
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", card.getImagePath());
    }

    @Test
    void setGetRarity() {
        Card card = new Card();
        card.setRarity(Rarity.MYTHIC);
        assertEquals(Rarity.MYTHIC, card.getRarity());
    }

    @Test
    void setGetArtistName() {
        Card card = new Card();
        card.setArtistName("Rudy Siswanto");
        assertEquals("Rudy Siswanto", card.getArtistName());
    }

    @Test
    void setGetConvertedManaCost() {
        Card card = new Card();
        card.setConvertedManaCost("6");
        assertEquals("6", card.getConvertedManaCost());
    }

    @Test
    void setGetPower() {
        Card card = new Card();
        card.setPower("6");
        assertEquals("6", card.getPower());
    }

    @Test
    void setGetToughness() {
        Card card = new Card();
        card.setToughness("6");
        assertEquals("6", card.getToughness());
    }

    @Test
    void setGetExpansion() {
        Card card = new Card();
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));
        card.setExpansion(expansion);
        assertEquals(242, card.getExpansion().getExpansionId());
        assertEquals("Zendikar Rising", card.getExpansion().getExpansionName());
        assertEquals("ZNR", card.getExpansion().getExpansionCode());
        assertEquals(Date.valueOf("2020-09-01"), card.getExpansion().getReleasedDate());
    }

    @Test
    void setGetTextBox() {
        Card card = new Card();
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");
        assertEquals("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.",
                card.getTextBox());
    }

    @Test
    void testEquals() {
        Card card = new Card();
        Card card2 = new Card();
        Card different = new Card();
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

        card2.setCardId("ZNR150");
        card2.setCardName("Moraug, Fury of Akoum");
        card2.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card2.setRarity(Rarity.MYTHIC);
        card2.setArtistName("Rudy Siswanto");
        card2.setConvertedManaCost("6");
        card2.setPower("6");
        card2.setToughness("6");
        card2.setExpansion(expansion);
        card2.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        different.setCardId("ZNR015");
        different.setCardName("Moraug");
        different.setImagePath("card_images/zendikar_rising/znr-015-moraug.jpg");
        different.setRarity(Rarity.COMMON);
        different.setArtistName("John Johnson");
        different.setConvertedManaCost("1");
        different.setPower("2");
        different.setToughness("3");
        different.setExpansion(expansion);
        different.setTextBox("Trample");

        assertFalse(different.equals(card));
        assertTrue(card.equals(card2));
    }

    @Test
    void testHashCode() {
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

        assertNotNull(card.hashCode());
    }

    @Test
    void testToString() {
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

        assertEquals("{\"cardId\":\"ZNR150\", \"cardName\":\"Moraug, Fury of Akoum\", " +
                "\"imagePath\":\"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg\", \"rarity\":\"mythic\", " +
                "\"artistName\":\"Rudy Siswanto\", \"convertedManaCost\":\"6\", \"power\":\"6\", \"toughness\":\"6\", " +
                "\"expansion\":{\"expansionId\":242, \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\", " +
                "\"releasedDate\":\"2020-09-01\"}, \"textBox\":\"Each creature you control gets +1/+0 for each time it " +
                "has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s " +
                "your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, " +
                "untap all creatures you control.\"}", card.toString());

    }
}