package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RarityTest {

    @Test
    void label() {
        assertEquals("common", Rarity.COMMON.label);
        assertEquals("uncommon", Rarity.UNCOMMON.label);
        assertEquals("rare", Rarity.RARE.label);
        assertEquals("mythic", Rarity.MYTHIC.label);
    }

    @Test
    void values() {
        assertEquals(4, Rarity.values().length);
    }
}