package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardCopyToLibraryTest {

    @Test
    void constructorTests() {
        List<CardCopy> cardCopies = new ArrayList<>();

        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        Card card = new Card();
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
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);
        cardCopy.setUser(user);

        cardCopies.add(cardCopy);

        Library library = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUser(user);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        CardCopyToLibrary cardCopyToLibrary1 = new CardCopyToLibrary(cardCopies);
        CardCopyToLibrary cardCopyToLibrary2 = new CardCopyToLibrary(cardCopies, library);

        assertNull(cardCopyToLibrary.getCardCopies());

        assertEquals(cardCopies, cardCopyToLibrary1.getCardCopies());

        assertEquals(cardCopies, cardCopyToLibrary2.getCardCopies());
        assertEquals(library, cardCopyToLibrary2.getLibrary());
    }

    @Test
    void getSetCardCopies() {
        List<CardCopy> cardCopies = new ArrayList<>();

        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        Card card = new Card();
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
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);
        cardCopy.setUser(user);

        cardCopies.add(cardCopy);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setCardCopies(cardCopies);

        assertEquals(cardCopies, cardCopyToLibrary.getCardCopies());
    }

    @Test
    void getSetLibrary() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        Library library = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUser(user);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setLibrary(library);
    }

    @Test
    void testEquals() {
        List<CardCopy> cardCopies = new ArrayList<>();

        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        Card card = new Card();
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
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);
        cardCopy.setUser(user);

        cardCopies.add(cardCopy);

        Library library = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUser(user);

        Library library1 = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Dragon Deck");
        library.setUser(user);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setCardCopies(cardCopies);
        cardCopyToLibrary.setLibrary(library);

        CardCopyToLibrary cardCopyToLibrary1 = new CardCopyToLibrary();
        cardCopyToLibrary1.setCardCopies(cardCopies);
        cardCopyToLibrary1.setLibrary(library);

        CardCopyToLibrary different = new CardCopyToLibrary();
        different.setCardCopies(cardCopies);
        different.setLibrary(library1);

        assertFalse(cardCopyToLibrary.equals(different));
        assertTrue(cardCopyToLibrary.equals(cardCopyToLibrary1));
    }

    @Test
    void testHashCode() {
        List<CardCopy> cardCopies = new ArrayList<>();

        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        Card card = new Card();
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
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);
        cardCopy.setUser(user);

        cardCopies.add(cardCopy);

        Library library = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUser(user);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setCardCopies(cardCopies);
        cardCopyToLibrary.setLibrary(library);

        assertNotNull(cardCopyToLibrary.hashCode());
    }

    @Test
    void testToString() {
        List<CardCopy> cardCopies = new ArrayList<>();

        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        Card card = new Card();
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
        user.setUsername("TimTheMagicMan");
        user.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);
        cardCopy.setUser(user);

        cardCopies.add(cardCopy);

        Library library = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Zombie Deck");
        library.setUser(user);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setCardCopies(cardCopies);
        cardCopyToLibrary.setLibrary(library);

        assertEquals("{cardCopies:[{\"cardCopyId\":0, \"card\":{\"cardId\":\"ZNR150\"," +
                        " \"cardName\":\"Moraug, Fury of Akoum\"," +
                        " \"imagePath\":\"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg\"," +
                        " \"rarity\":\"mythic\", \"artistName\":\"Rudy Siswanto\", \"convertedManaCost\":\"6\"," +
                        " \"power\":\"6\", \"toughness\":\"6\", \"expansion\":{\"expansionId\":242," +
                        " \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\"," +
                        " \"releasedDate\":\"2020-09-01\"}," +
                        " \"textBox\":\"Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.\"}," +
                        " \"user\":{\"userId\":\"5d209ac0-9102-11ec-b909-0242ac120002\"," +
                        " \"username\":\"TimTheMagicMan\"," +
                        " \"password\":\"5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8\"}}]," +
                        " library:{\"libraryId\":1, \"libraryName\":\"Zombie Deck\"," +
                        " \"user\":{\"userId\":\"5d209ac0-9102-11ec-b909-0242ac120002\", \"username\":\"TimTheMagicMan\"," +
                        " \"password\":\"5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8\"}}}",
                cardCopyToLibrary.toString());
    }
}