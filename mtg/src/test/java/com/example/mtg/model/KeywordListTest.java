package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeywordListTest {

    @Test
    void constructorTests() {
        List<Keyword> keywords = new ArrayList<>();

        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");
        keywords.add(keyword);

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

        KeywordList keywordList = new KeywordList();
        KeywordList keywordList1 = new KeywordList(keywords);
        KeywordList keywordList2 = new KeywordList(keywords, card);

        assertNull(keywordList.getKeywords());

        assertEquals(keywords, keywordList1.getKeywords());

        assertEquals(keywords, keywordList2.getKeywords());
        assertEquals(card, keywordList2.getCard());
    }

    @Test
    void getSetKeywords() {
        KeywordList keywordList = new KeywordList();
        List<Keyword> keywords = new ArrayList<>();
        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");
        keywords.add(keyword);
        keywordList.setKeywords(keywords);

        assertEquals(keywords, keywordList.getKeywords());
    }

    @Test
    void getSetCard() {
        KeywordList keywordList = new KeywordList();
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
        keywordList.setCard(card);

        assertEquals(card, keywordList.getCard());
    }

    @Test
    void testEquals() {
        List<Keyword> keywords = new ArrayList<>();

        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");
        keywords.add(keyword);

        List<Keyword> differentKeywords = new ArrayList<>();

        Keyword differentKeyword = new Keyword();
        differentKeyword.setKeywordId(2);
        differentKeyword.setKeywordName("Flash");
        differentKeywords.add(differentKeyword);

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

        KeywordList keywordList = new KeywordList();
        keywordList.setKeywords(keywords);
        keywordList.setCard(card);

        KeywordList keywordList1 = new KeywordList();
        keywordList1.setKeywords(keywords);
        keywordList1.setCard(card);

        KeywordList different = new KeywordList();
        different.setKeywords(differentKeywords);
        different.setCard(card);

        assertFalse(keywordList.equals(different));
        assertTrue(keywordList.equals(keywordList1));
    }

    @Test
    void testHashCode() {
        List<Keyword> keywords = new ArrayList<>();

        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");
        keywords.add(keyword);

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

        KeywordList keywordList = new KeywordList();
        keywordList.setKeywords(keywords);
        keywordList.setCard(card);

        assertNotNull(keywordList.hashCode());
    }

    @Test
    void testToString() {
        List<Keyword> keywords = new ArrayList<>();

        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");
        keywords.add(keyword);

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

        KeywordList keywordList = new KeywordList();
        keywordList.setKeywords(keywords);
        keywordList.setCard(card);

        assertEquals("{\"keywords\":[{\"keywordId\":1, \"keywordName\":\"Trample\"}]," +
                        " \"card\":{\"cardId\":\"ZNR150\", \"cardName\":\"Moraug, Fury of Akoum\"," +
                        " \"imagePath\":\"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg\"," +
                        " \"rarity\":\"mythic\", \"artistName\":\"Rudy Siswanto\", \"convertedManaCost\":\"6\"," +
                        " \"power\":\"6\", \"toughness\":\"6\", \"expansion\":{\"expansionId\":242," +
                        " \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\"," +
                        " \"releasedDate\":\"2020-09-01\"}, \"textBox\":\"Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.\"}}",
                keywordList.toString());
    }
}