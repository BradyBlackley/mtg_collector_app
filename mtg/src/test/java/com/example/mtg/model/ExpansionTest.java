package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ExpansionTest {

    @Test
    void constructorTests() {
        Expansion expansion = new Expansion();
        Expansion expansion1 = new Expansion(242);
        Expansion expansion2 = new Expansion(242,"Zendikar Rising");
        Expansion expansion3 = new Expansion(242,"Zendikar Rising", "ZNR");
        Expansion expansion4 = new Expansion(242,"Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01"));

        assertNull(expansion.getExpansionCode());

        assertEquals(242, expansion1.getExpansionId());

        assertEquals(242, expansion2.getExpansionId());
        assertEquals("Zendikar Rising", expansion2.getExpansionName());

        assertEquals(242, expansion3.getExpansionId());
        assertEquals("Zendikar Rising", expansion3.getExpansionName());
        assertEquals("ZNR", expansion3.getExpansionCode());

        assertEquals(242, expansion4.getExpansionId());
        assertEquals("Zendikar Rising", expansion4.getExpansionName());
        assertEquals("ZNR", expansion4.getExpansionCode());
        assertEquals(Date.valueOf("2020-09-01"), expansion4.getReleasedDate());
    }

    @Test
    void setGetExpansionId() {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
    }

    @Test
    void setGetExpansionName() {
        Expansion expansion = new Expansion();
        expansion.setExpansionName("Zendikar Rising");
    }

    @Test
    void setGetExpansionCode() {
        Expansion expansion = new Expansion();
        expansion.setExpansionCode("ZNR");
    }

    @Test
    void setGetReleasedDate() {
        Expansion expansion = new Expansion();
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));
    }

    @Test
    void testEquals() {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        Expansion expansion1 = new Expansion();
        expansion1.setExpansionId(242);
        expansion1.setExpansionName("Zendikar Rising");
        expansion1.setExpansionCode("ZNR");
        expansion1.setReleasedDate(Date.valueOf("2020-09-01"));

        Expansion different = new Expansion();
        different.setExpansionId(1);
        different.setExpansionName("Double Masters");
        different.setExpansionCode("2X2");
        different.setReleasedDate(Date.valueOf("2022-07-01"));

        assertFalse(different.equals(expansion));
        assertTrue(expansion.equals(expansion1));
    }

    @Test
    void testHashCode() {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        assertNotNull(expansion.hashCode());
    }

    @Test
    void testToString() {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        assertEquals("{\"expansionId\":242, \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\", " +
                        "\"releasedDate\":\"2020-09-01\"}",
                expansion.toString());
    }
}