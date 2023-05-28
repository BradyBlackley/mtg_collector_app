package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypelineTest {

    @Test
    void constructorTests() {
        List<Type> types = new ArrayList<>();

        Type legendary = new Type();
        legendary.setTypeId(1);
        legendary.setTypeName("Legendary");

        Type creature = new Type();
        creature.setTypeId(2);
        creature.setTypeName("Creature");

        Type minotaur = new Type();
        minotaur.setTypeId(3);
        minotaur.setTypeName("Minotaur");

        Type warrior = new Type();
        warrior.setTypeId(4);
        warrior.setTypeName("Warrior");

        types.add(legendary);
        types.add(creature);
        types.add(minotaur);
        types.add(warrior);

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

        Typeline typeline = new Typeline();
        Typeline typeline1 = new Typeline(types);
        Typeline typeline2 = new Typeline(types, card);

        assertNull(typeline.getTypes());

        assertEquals(types, typeline1.getTypes());

        assertEquals(types, typeline2.getTypes());
        assertEquals(card, typeline2.getCard());
    }

    @Test
    void setGetTypes() {
        Typeline typeline = new Typeline();

        List<Type> types = new ArrayList<>();

        Type legendary = new Type();
        legendary.setTypeId(1);
        legendary.setTypeName("Legendary");

        Type creature = new Type();
        creature.setTypeId(2);
        creature.setTypeName("Creature");

        Type minotaur = new Type();
        minotaur.setTypeId(3);
        minotaur.setTypeName("Minotaur");

        Type warrior = new Type();
        warrior.setTypeId(4);
        warrior.setTypeName("Warrior");

        types.add(legendary);
        types.add(creature);
        types.add(minotaur);
        types.add(warrior);

        typeline.setTypes(types);

        assertEquals(types, typeline.getTypes());
    }

    @Test
    void setGetCard() {

        Typeline typeline = new Typeline();

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

        typeline.setCard(card);

        assertEquals(card, typeline.getCard());
    }

    @Test
    void testEquals() {
        Typeline typeline = new Typeline();
        Typeline typeline1 = new Typeline();
        Typeline different = new Typeline();

        List<Type> types = new ArrayList<>();

        Type legendary = new Type();
        legendary.setTypeId(1);
        legendary.setTypeName("Legendary");

        Type creature = new Type();
        creature.setTypeId(2);
        creature.setTypeName("Creature");

        Type minotaur = new Type();
        minotaur.setTypeId(3);
        minotaur.setTypeName("Minotaur");

        Type warrior = new Type();
        warrior.setTypeId(4);
        warrior.setTypeName("Warrior");

        types.add(legendary);
        types.add(creature);
        types.add(minotaur);
        types.add(warrior);

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

        List<Type> differentTypes = new ArrayList<>();

        Type human = new Type();
        minotaur.setTypeId(3);
        minotaur.setTypeName("Human");

        Type priest = new Type();
        warrior.setTypeId(4);
        warrior.setTypeName("Priest");

        differentTypes.add(legendary);
        differentTypes.add(creature);
        differentTypes.add(minotaur);
        differentTypes.add(warrior);

        Card differentCard = new Card();
        Expansion differentExpansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR134");
        card.setCardName("Moraug");
        card.setImagePath("card_images/zendikar_rising/znr-134-moraug.jpg");
        card.setRarity(Rarity.COMMON);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("5");
        card.setPower("4");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Trample");

        typeline.setTypes(types);
        typeline.setCard(card);

        typeline1.setTypes(types);
        typeline1.setCard(card);

        different.setTypes(differentTypes);
        different.setCard(differentCard);

        assertFalse(typeline.equals(different));
        assertTrue(typeline.equals(typeline1));
    }

    @Test
    void testHashCode() {
        Typeline typeline = new Typeline();

        List<Type> types = new ArrayList<>();

        Type legendary = new Type();
        legendary.setTypeId(1);
        legendary.setTypeName("Legendary");

        Type creature = new Type();
        creature.setTypeId(2);
        creature.setTypeName("Creature");

        Type minotaur = new Type();
        minotaur.setTypeId(3);
        minotaur.setTypeName("Minotaur");

        Type warrior = new Type();
        warrior.setTypeId(4);
        warrior.setTypeName("Warrior");

        types.add(legendary);
        types.add(creature);
        types.add(minotaur);
        types.add(warrior);

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

        typeline.setCard(card);
        typeline.setTypes(types);

        assertNotNull(typeline.hashCode());
    }

    @Test
    void testToString() {
        Typeline typeline = new Typeline();

        List<Type> types = new ArrayList<>();

        Type legendary = new Type();
        legendary.setTypeId(1);
        legendary.setTypeName("Legendary");

        Type creature = new Type();
        creature.setTypeId(2);
        creature.setTypeName("Creature");

        Type minotaur = new Type();
        minotaur.setTypeId(3);
        minotaur.setTypeName("Minotaur");

        Type warrior = new Type();
        warrior.setTypeId(4);
        warrior.setTypeName("Warrior");

        types.add(legendary);
        types.add(creature);
        types.add(minotaur);
        types.add(warrior);

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

        typeline.setCard(card);
        typeline.setTypes(types);

        assertEquals("{\"types\":[{\"typeId\":1, \"typeName\":\"Legendary\"}, {\"typeId\":2," +
                        " \"typeName\":\"Creature\"}, {\"typeId\":3, \"typeName\":\"Minotaur\"}," +
                        " {\"typeId\":4, \"typeName\":\"Warrior\"}], \"card\":{\"cardId\":\"ZNR150\"," +
                        " \"cardName\":\"Moraug, Fury of Akoum\"," +
                        " \"imagePath\":\"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg\"," +
                        " \"rarity\":\"mythic\", \"artistName\":\"Rudy Siswanto\", \"convertedManaCost\":\"6\"," +
                        " \"power\":\"6\", \"toughness\":\"6\", \"expansion\":{\"expansionId\":242," +
                        " \"expansionName\":\"Zendikar Rising\", \"expansionCode\":\"ZNR\"," +
                        " \"releasedDate\":\"2020-09-01\"}," +
                        " \"textBox\":\"Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.\"," +
                        " \"backCard\":\"null\"}}",
                typeline.toString());
    }
}