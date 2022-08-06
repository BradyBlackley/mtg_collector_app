package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ModalTest {

    @Test
    void constructorTests() {
        Card front = new Card();
        front.setCardId("ZNR216F");
        front.setCardName("Vastwood Fortification");
        front.setImagePath("card_images/zendikar_rising/znr-216-vastwood-fortification.jpg");
        front.setRarity(Rarity.UNCOMMON);
        front.setArtistName("Sidharth Chaturvedi");
        front.setConvertedManaCost("1");
        front.setPower(null);
        front.setToughness(null);
        front.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        front.setTextBox("Put a +1/+1 counter on target creature.");

        Card back = new Card();
        back.setCardId("ZNR216B");
        back.setCardName("Vastwood Thicket");
        back.setImagePath("card_images/zendikar_rising/znr-216-vastwood-thicket.jpg");
        back.setRarity(Rarity.UNCOMMON);
        back.setArtistName("Sidharth Chaturvedi");
        back.setConvertedManaCost(null);
        back.setPower(null);
        back.setToughness(null);
        back.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        back.setTextBox("Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]");

        Modal modal = new Modal();
        Modal modal1 = new Modal("ZNR166");
        Modal modal2 = new Modal("ZNR166", front);
        Modal modal3 = new Modal("ZNR166", front, back);

        assertNull(modal.getModalId());

        assertEquals("ZNR166", modal1.getModalId());

        assertEquals("ZNR166", modal2.getModalId());
        assertEquals(front, modal2.getfrontCard());

        assertEquals("ZNR166", modal3.getModalId());
        assertEquals(front, modal3.getfrontCard());
        assertEquals(back, modal3.getbackCard());
    }

    @Test
    void setGetModalId() {
        Modal modal = new Modal();
        modal.setModalId("ZNR166");
    }

    @Test
    void setGetfrontCard() {
        Modal modal = new Modal();

        Card front = new Card();
        front.setCardId("ZNR216F");
        front.setCardName("Vastwood Fortification");
        front.setImagePath("card_images/zendikar_rising/znr-216-vastwood-fortification.jpg");
        front.setRarity(Rarity.UNCOMMON);
        front.setArtistName("Sidharth Chaturvedi");
        front.setConvertedManaCost("1");
        front.setPower(null);
        front.setToughness(null);
        front.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        front.setTextBox("Put a +1/+1 counter on target creature.");

        modal.setfrontCard(front);
    }

    @Test
    void setGetbackCard() {
        Modal modal = new Modal();

        Card back = new Card();
        back.setCardId("ZNR216B");
        back.setCardName("Vastwood Thicket");
        back.setImagePath("card_images/zendikar_rising/znr-216-vastwood-thicket.jpg");
        back.setRarity(Rarity.UNCOMMON);
        back.setArtistName("Sidharth Chaturvedi");
        back.setConvertedManaCost(null);
        back.setPower(null);
        back.setToughness(null);
        back.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        back.setTextBox("Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]");

        modal.setbackCard(back);
    }

    @Test
    void testEquals() {
        Modal modal = new Modal();
        Modal modal1 = new Modal();
        Modal different = new Modal();

        Card front = new Card();
        front.setCardId("ZNR216F");
        front.setCardName("Vastwood Fortification");
        front.setImagePath("card_images/zendikar_rising/znr-216-vastwood-fortification.jpg");
        front.setRarity(Rarity.UNCOMMON);
        front.setArtistName("Sidharth Chaturvedi");
        front.setConvertedManaCost("1");
        front.setPower(null);
        front.setToughness(null);
        front.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        front.setTextBox("Put a +1/+1 counter on target creature.");

        Card back = new Card();
        back.setCardId("ZNR216B");
        back.setCardName("Vastwood Thicket");
        back.setImagePath("card_images/zendikar_rising/znr-216-vastwood-thicket.jpg");
        back.setRarity(Rarity.UNCOMMON);
        back.setArtistName("Sidharth Chaturvedi");
        back.setConvertedManaCost(null);
        back.setPower(null);
        back.setToughness(null);
        back.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        back.setTextBox("Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]");

        modal.setModalId("ZNR216");
        modal.setfrontCard(front);
        modal.setbackCard(back);

        modal1.setModalId("ZNR216");
        modal1.setfrontCard(front);
        modal1.setbackCard(back);

        different.setModalId("ZNR200");
        different.setfrontCard(front);
        different.setbackCard(back);

        assertFalse(modal.equals(different));
        assertTrue(modal.equals(modal1));
    }

    @Test
    void testHashCode() {
        Modal modal = new Modal();

        Card front = new Card();
        front.setCardId("ZNR216F");
        front.setCardName("Vastwood Fortification");
        front.setImagePath("card_images/zendikar_rising/znr-216-vastwood-fortification.jpg");
        front.setRarity(Rarity.UNCOMMON);
        front.setArtistName("Sidharth Chaturvedi");
        front.setConvertedManaCost("1");
        front.setPower(null);
        front.setToughness(null);
        front.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        front.setTextBox("Put a +1/+1 counter on target creature.");

        Card back = new Card();
        back.setCardId("ZNR216B");
        back.setCardName("Vastwood Thicket");
        back.setImagePath("card_images/zendikar_rising/znr-216-vastwood-thicket.jpg");
        back.setRarity(Rarity.UNCOMMON);
        back.setArtistName("Sidharth Chaturvedi");
        back.setConvertedManaCost(null);
        back.setPower(null);
        back.setToughness(null);
        back.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        back.setTextBox("Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]");

        modal.setModalId("ZNR216");
        modal.setfrontCard(front);
        modal.setbackCard(back);

        assertNotNull(modal.hashCode());
    }

    @Test
    void testToString() {
        Modal modal = new Modal();

        Card front = new Card();
        front.setCardId("ZNR216F");
        front.setCardName("Vastwood Fortification");
        front.setImagePath("card_images/zendikar_rising/znr-216-vastwood-fortification.jpg");
        front.setRarity(Rarity.UNCOMMON);
        front.setArtistName("Sidharth Chaturvedi");
        front.setConvertedManaCost("1");
        front.setPower(null);
        front.setToughness(null);
        front.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        front.setTextBox("Put a +1/+1 counter on target creature.");

        Card back = new Card();
        back.setCardId("ZNR216B");
        back.setCardName("Vastwood Thicket");
        back.setImagePath("card_images/zendikar_rising/znr-216-vastwood-thicket.jpg");
        back.setRarity(Rarity.UNCOMMON);
        back.setArtistName("Sidharth Chaturvedi");
        back.setConvertedManaCost(null);
        back.setPower(null);
        back.setToughness(null);
        back.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
                Date.valueOf("2020-09-01")));
        back.setTextBox("Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]");

        modal.setModalId("ZNR216");
        modal.setfrontCard(front);
        modal.setbackCard(back);

        assertEquals("{\"modalId\":\"ZNR216\", \"frontCard\":{\"cardId\":\"ZNR216F\", \"cardName\":\"Vastwood Fortification\", \"imagePath\":\"card_images/zendikar_rising/znr-216-vastwood-fortification.jpg\", \"rarity\":\"uncommon\", \"artistName\":\"Sidharth Chaturvedi\", \"convertedManaCost\":\"1\", \"power\":\"null\", \"toughness\":\"null\", \"expansion\":{\"expansionId\":1, \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\", \"releasedDate\":\"2020-09-01\"}, \"textBox\":\"Put a +1/+1 counter on target creature.\"}, \"backCard\":{\"cardId\":\"ZNR216B\", \"cardName\":\"Vastwood Thicket\", \"imagePath\":\"card_images/zendikar_rising/znr-216-vastwood-thicket.jpg\", \"rarity\":\"uncommon\", \"artistName\":\"Sidharth Chaturvedi\", \"convertedManaCost\":\"null\", \"power\":\"null\", \"toughness\":\"null\", \"expansion\":{\"expansionId\":1, \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\", \"releasedDate\":\"2020-09-01\"}, \"textBox\":\"Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]\"}}",
                modal.toString());
    }
}