//package com.example.mtg.model;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ColorTest {
//
//    @Test
//    void constructorTests() {
//        Color color = new Color();
//        Color color1 = new Color(1);
//        Color color2 = new Color("black");
//        Color color3 = new Color(1, "black");
//
//        assertNull(color.getColorName());
//
//        assertEquals(1, color1.getColorId());
//
//        assertEquals("black", color2.getColorName());
//
//        assertEquals(1, color3.getColorId());
//        assertEquals("black", color3.getColorName());
//    }
//
//    @Test
//    void setGetColorId() {
//        Color color = new Color();
//        color.setColorId(1);
//
//        assertEquals(1, color.getColorId());
//    }
//
//    @Test
//    void setGetColorName() {
//        Color color = new Color();
//        color.setColorName("black");
//
//        assertEquals("black", color.getColorName());
//    }
//
//    @Test
//    void testEquals() {
//        Color color = new Color();
//        color.setColorId(1);
//        color.setColorName("black");
//
//        Color color1 = new Color();
//        color1.setColorId(1);
//        color1.setColorName("black");
//
//        Color different = new Color();
//        different.setColorId(2);
//        different.setColorName("white");
//
//        assertFalse(different.equals(color));
//        assertTrue(color.equals(color1));
//    }
//
//    @Test
//    void testHashCode() {
//        Color color = new Color();
//        color.setColorId(1);
//        color.setColorName("black");
//
//        assertNotNull(color.hashCode());
//    }
//
//    @Test
//    void testToString() {
//        Color color = new Color();
//        color.setColorId(1);
//        color.setColorName("black");
//
//        assertEquals("{\"colorId\":1, \"colorName\":\"black\"}", color.toString());
//    }
//}