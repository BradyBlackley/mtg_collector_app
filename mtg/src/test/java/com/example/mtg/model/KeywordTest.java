package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeywordTest {

    @Test
    void constructorTests() {
        Keyword keyword = new Keyword();
        Keyword keyword1 = new Keyword(1);
        Keyword keyword2 = new Keyword(1, "Trample");

        assertNull(keyword.getKeywordName());

        assertEquals(1, keyword1.getKeywordId());

        assertEquals(1, keyword2.getKeywordId());
        assertEquals("Trample", keyword2.getKeywordName());
    }

    @Test
    void getSetKeywordId() {
        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);

        assertEquals(1, keyword.getKeywordId());
    }

    @Test
    void getSetKeywordName() {
        Keyword keyword = new Keyword();
        keyword.setKeywordName("Trample");

        assertEquals("Trample", keyword.getKeywordName());
    }

    @Test
    void testEquals() {
        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");

        Keyword keyword1 = new Keyword();
        keyword1.setKeywordId(1);
        keyword1.setKeywordName("Trample");

        Keyword different = new Keyword();
        different.setKeywordId(1);
        different.setKeywordName("Flash");

        assertNotEquals(keyword, different);
        assertEquals(keyword, keyword1);
    }

    @Test
    void testHashCode() {
        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");

        assertNotNull(keyword.hashCode());
    }

    @Test
    void testToString() {
        Keyword keyword = new Keyword();
        keyword.setKeywordId(1);
        keyword.setKeywordName("Trample");

        assertEquals("{\"keywordId\":1, \"keywordName\":\"Trample\"}", keyword.toString());
    }
}