package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CardCopyTest {

    @Test
    void constructorTests() {
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

        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        CardCopy cardCopy = new CardCopy();
        CardCopy cardCopy1 = new CardCopy(1);
        CardCopy cardCopy2 = new CardCopy(1, card);
        CardCopy cardCopy3 = new CardCopy(1, card, user.getUserId());

        assertNull(cardCopy.getCard());

        assertEquals(1, cardCopy1.getCardCopyId());

        assertEquals(1, cardCopy2.getCardCopyId());
        assertEquals(card, cardCopy2.getCard());

        assertEquals(1, cardCopy3.getCardCopyId());
        assertEquals(card, cardCopy3.getCard());
        assertEquals(user.getUserId(), cardCopy3.getUserId());
    }

    @Test
    void setGetCardCopyId() {
        CardCopy cardCopy = new CardCopy();
        cardCopy.setCardCopyId(1);

        assertEquals(1, cardCopy.getCardCopyId());
    }

    @Test
    void setGetCard() {
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

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);

        assertEquals(card, cardCopy.getCard());
    }

    @Test
    void setGetUser() {
        CardCopy cardCopy = new CardCopy();

        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        cardCopy.setUserId(user.getUserId());

        assertEquals(user.getUserId(), cardCopy.getUserId());
    }

    @Test
    void testEquals() {
        CardCopy cardCopy = new CardCopy();
        CardCopy cardCopy1 = new CardCopy();
        CardCopy different = new CardCopy();

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

        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        cardCopy.setCardCopyId(1);
        cardCopy.setCard(card);
        cardCopy.setUserId(user.getUserId());

        cardCopy1.setCardCopyId(1);
        cardCopy1.setCard(card);
        cardCopy1.setUserId(user.getUserId());

        different.setCardCopyId(2);
        different.setCard(card);
        different.setUserId(user.getUserId());

        assertFalse(different.equals(cardCopy));
        assertTrue(cardCopy.equals(cardCopy1));
    }

    @Test
    void testHashCode() {
        CardCopy cardCopy = new CardCopy();
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

        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        cardCopy.setCardCopyId(1);
        cardCopy.setCard(card);
        cardCopy.setUserId(user.getUserId());

        assertNotNull(cardCopy.hashCode());
    }

    @Test
    void testToString() {
        CardCopy cardCopy = new CardCopy();
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

        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        cardCopy.setCardCopyId(1);
        cardCopy.setCard(card);
        cardCopy.setUserId(user.getUserId());

        assertEquals("{\"cardCopyId\":1, \"card\":{\"cardId\":\"ZNR150\", \"cardName\":\"Moraug, Fury of Akoum\", " +
                        "\"imagePath\":\"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg\", " +
                        "\"rarity\":\"mythic\", \"artistName\":\"Rudy Siswanto\", \"convertedManaCost\":\"6\", " +
                        "\"power\":\"6\", \"toughness\":\"6\", \"expansion\":{\"expansionId\":242, " +
                        "\"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\", " +
                        "\"releasedDate\":\"2020-09-01\"}, \"textBox\":\"Each creature you control gets +1/+0 for " +
                        "each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under " +
                        "your control, if it''s your main phase, there''s an additional combat phase after this phase. " +
                        "At the beginning of that combat, untap all creatures you control.\"," +
                        " \"backCard\":\"null\"}, " +
                        "\"userId\":\"5d209ac0-9102-11ec-b909-0242ac120002\"}",
                cardCopy.toString());
    }
}