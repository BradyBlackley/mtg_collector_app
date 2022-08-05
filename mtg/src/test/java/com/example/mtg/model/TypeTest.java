package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {

    @Test
    void constructorTests() {
        Type type = new Type();
        Type type1 = new Type(1);
        Type type2 = new Type("Legendary");
        Type type3 = new Type(1, "Legendary");

        assertNull(type.getTypeName());

        assertEquals(1, type1.getTypeId());

        assertEquals("Legendary", type2.getTypeName());

        assertEquals(1, type3.getTypeId());
        assertEquals("Legendary", type3.getTypeName());
    }

    @Test
    void setGetTypeId() {
        Type type = new Type();
        type.setTypeId(1);

        assertEquals(1, type.getTypeId());
    }

    @Test
    void setGetTypeName() {
        Type type = new Type();
        type.setTypeName("Legendary");

        assertEquals("Legendary", type.getTypeName());
    }

    @Test
    void testEquals() {
        Type type = new Type();
        type.setTypeId(1);
        type.setTypeName("Legendary");

        Type type1 = new Type();
        type1.setTypeId(1);
        type1.setTypeName("Legendary");

        Type different = new Type();
        different.setTypeId(2);
        different.setTypeName("Creature");

        assertFalse(type.equals(different));
        assertTrue(type.equals(type1));
    }

    @Test
    void testHashCode() {
        Type type = new Type();
        type.setTypeId(1);
        type.setTypeName("Legendary");

        assertNotNull(type.hashCode());
    }

    @Test
    void testToString() {
        Type type = new Type();
        type.setTypeId(1);
        type.setTypeName("Legendary");

        assertEquals("{\"typeId\":1, \"typeName\":\"Legendary\"}", type.toString());
    }
}