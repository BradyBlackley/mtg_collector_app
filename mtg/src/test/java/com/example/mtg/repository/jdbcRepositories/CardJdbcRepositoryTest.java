package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:schema-h2.sql", "classpath:data/Card.sql"})
class CardJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    CardJdbcRepository repository;

    @Test
    void findAllCards() {
        assertEquals(4, repository.findAllCards().size());
        assertEquals("ZNR150", repository.findAllCards().get(0).getCardId());
        assertEquals("Moraug, Fury of Akoum", repository.findAllCards().get(0).getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg",
                repository.findAllCards().get(0).getImagePath());
        assertEquals(Rarity.MYTHIC, repository.findAllCards().get(0).getRarity());
        assertEquals("Rudy Siswanto",
                repository.findAllCards().get(0).getArtistName());
        assertEquals("6",
                repository.findAllCards().get(0).getConvertedManaCost());
        assertEquals("6", repository.findAllCards().get(0).getPower());
        assertEquals("6", repository.findAllCards().get(0).getToughness());
        assertEquals(1,
                repository.findAllCards().get(0).getExpansion().getExpansionId());
        assertEquals("ZNR",
                repository.findAllCards().get(0).getExpansion().getExpansionCode());
        assertEquals("Zendikar Rising",
                repository.findAllCards().get(0).getExpansion().getExpansionName());
        assertEquals(Date.valueOf("2020-09-01"),
                repository.findAllCards().get(0).getExpansion().getReleasedDate());
        assertEquals("Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                " you control.", repository.findAllCards().get(0).getTextBox());

        assertEquals("ZNR134", repository.findAllCards().get(1).getCardId());
        assertEquals("Akoum Warrior", repository.findAllCards().get(1).getCardName());
        assertEquals("card_images/zendikar_rising/znr-134-akoum-warrior.jpg",
                repository.findAllCards().get(1).getImagePath());
        assertEquals(Rarity.UNCOMMON, repository.findAllCards().get(1).getRarity());
        assertEquals("Karl Kopinski", repository.findAllCards().get(1).getArtistName());
        assertEquals("6", repository.findAllCards().get(1).getConvertedManaCost());
        assertEquals("4", repository.findAllCards().get(1).getPower());
        assertEquals("5", repository.findAllCards().get(1).getToughness());
        assertEquals(1, repository.findAllCards().get(1).getExpansion().getExpansionId());
        assertEquals("ZNR", repository.findAllCards().get(1).getExpansion().getExpansionCode());
        assertEquals("Zendikar Rising", repository.findAllCards().get(1).getExpansion().getExpansionName());
        assertEquals(Date.valueOf("2020-09-01"), repository.findAllCards().get(1).getExpansion().getReleasedDate());
        assertEquals("Trample", repository.findAllCards().get(1).getTextBox());
    }

    @Test
    void findCardsByExactName() {
        assertEquals(1, repository.findCardsByName("Moraug, Fury of Akoum").size());
        assertEquals("ZNR150", repository.findCardsByName("Moraug, Fury of Akoum").get(0).getCardId());
        assertEquals("Moraug, Fury of Akoum",
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg",
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getImagePath());
        assertEquals(Rarity.MYTHIC, repository.findCardsByName("Moraug, Fury of Akoum").get(0).getRarity());
        assertEquals("Rudy Siswanto",
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getArtistName());
        assertEquals("6",
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getConvertedManaCost());
        assertEquals("6", repository.findCardsByName("Moraug, Fury of Akoum").get(0).getPower());
        assertEquals("6", repository.findCardsByName("Moraug, Fury of Akoum").get(0).getToughness());
        assertEquals(1,
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getExpansion().getExpansionId());
        assertEquals("ZNR",
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getExpansion().getExpansionCode());
        assertEquals("Zendikar Rising",
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getExpansion().getExpansionName());
        assertEquals(Date.valueOf("2020-09-01"),
                repository.findCardsByName("Moraug, Fury of Akoum").get(0).getExpansion().getReleasedDate());
        assertEquals("Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                " you control.", repository.findCardsByName("Moraug, Fury of Akoum").get(0).getTextBox());
    }

    @Test
    void findCardsByApproximateName() {
        assertEquals(2, repository.findCardsByName("Akoum").size());
        assertEquals("ZNR150", repository.findCardsByName("Akoum").get(0).getCardId());
        assertEquals("ZNR134", repository.findCardsByName("Akoum").get(1).getCardId());
    }

    @Test
    void findCardsByRarity() {
        assertEquals(0, repository.findCardsByRarity(Rarity.COMMON).size());
        assertEquals(3, repository.findCardsByRarity(Rarity.UNCOMMON).size());
        assertEquals("ZNR134", repository.findCardsByRarity(Rarity.UNCOMMON).get(0).getCardId());
        assertEquals(0, repository.findCardsByRarity(Rarity.RARE).size());
        assertEquals(1, repository.findCardsByRarity(Rarity.MYTHIC).size());
        assertEquals("ZNR150", repository.findCardsByRarity(Rarity.MYTHIC).get(0).getCardId());
    }

    @Test
    void findCardsByArtist() {
        assertEquals(1, repository.findCardsByArtist("Rudy Siswanto").size());
        assertEquals("ZNR150",
                repository.findCardsByArtist("Rudy Siswanto").get(0).getCardId());
        assertEquals(1, repository.findCardsByArtist("Karl Kopinski").size());
        assertEquals("ZNR134",
                repository.findCardsByArtist("Karl Kopinski").get(0).getCardId());
    }

    @Test
    void findCardsByConvertedManaCost() {
        assertEquals(2, repository.findCardsByConvertedManaCost("6").size());
        assertEquals("ZNR150",
                repository.findCardsByConvertedManaCost("6").get(0).getCardId());
        assertEquals("ZNR134",
                repository.findCardsByConvertedManaCost("6").get(1).getCardId());
    }

    @Test
    void findCardsByPower() {
        assertEquals(1, repository.findCardsByPower("6").size());
        assertEquals(1, repository.findCardsByPower("4").size());
        assertEquals("ZNR150",
                repository.findCardsByPower("6").get(0).getCardId());
        assertEquals("ZNR134",
                repository.findCardsByPower("4").get(0).getCardId());
    }

    @Test
    void findCardsByToughness() {
        assertEquals(1, repository.findCardsByToughness("6").size());
        assertEquals(1, repository.findCardsByToughness("5").size());
        assertEquals("ZNR150",
                repository.findCardsByToughness("6").get(0).getCardId());
        assertEquals("ZNR134",
                repository.findCardsByToughness("5").get(0).getCardId());
    }

    @Test
    void findCardsByExpansionCode() {
        assertEquals(4, repository.findCardsByExpansionCode("ZNR").size());
    }

    @Test
    void findCardsByTextBox() {
        assertEquals(1, repository.findCardsByTextBox("Trample").size());
        assertEquals("ZNR134", repository.findCardsByTextBox("Trample").get(0).getCardId());
        assertEquals(1, repository.findCardsByTextBox("additional combat phase").size());
        assertEquals("ZNR150", repository.findCardsByTextBox("additional combat phase").get(0).getCardId());
    }

    @Test
    void findCardById() {
        assertEquals("ZNR150", repository.findCardById("ZNR150").getCardId());
        assertEquals("Moraug, Fury of Akoum", repository.findCardById("ZNR150").getCardName());
        assertEquals("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg",
                repository.findCardById("ZNR150").getImagePath());
        assertEquals(Rarity.MYTHIC, repository.findCardById("ZNR150").getRarity());
        assertEquals("Rudy Siswanto",
                repository.findCardById("ZNR150").getArtistName());
        assertEquals("6",
                repository.findCardById("ZNR150").getConvertedManaCost());
        assertEquals("6", repository.findCardById("ZNR150").getPower());
        assertEquals("6", repository.findCardById("ZNR150").getToughness());
        assertEquals(1,
                repository.findCardById("ZNR150").getExpansion().getExpansionId());
        assertEquals("ZNR",
                repository.findCardById("ZNR150").getExpansion().getExpansionCode());
        assertEquals("Zendikar Rising",
                repository.findCardById("ZNR150").getExpansion().getExpansionName());
        assertEquals(Date.valueOf("2020-09-01"),
                repository.findCardById("ZNR150").getExpansion().getReleasedDate());
        assertEquals("Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                " you control.", repository.findCardById("ZNR150").getTextBox());
    }

    @Test
    void add() {
        assertNotNull(repository.add(makeCard()));
    }

    @Test
    void update() {
        Card card = repository.findCardById("ZNR150");
        card.setCardName("Not Moraug, Fury of Akoum");

        assertTrue(repository.update(card));
    }

    @Test
    void delete() {
        assertFalse(repository.delete(null));
        assertTrue(repository.delete("ZNR150"));
    }

    private Card makeCard() {
        Card card = new Card();
        Expansion expansion = new Expansion();
        expansion.setExpansionId(1);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR063");
        card.setCardName("Jace, Mirror Mage");
        card.setImagePath("card_images/zendikar_rising/znr-63-jace-mirror-mage.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Tyler Jacobson");
        card.setConvertedManaCost("3");
        card.setPower(null);
        card.setToughness(null);
        card.setExpansion(expansion);

        card.setTextBox("Kicker [2 colorless] When Jace, Mirror Mage enters the battlefield, if Jace was kicked, create " +
                "a token that's a copy of Jace, Mirror Mage, except it's not legendary and it's starting loyalty is 1. " +
                "[+1 Loyalty]: Scry 2. [+0 Loyalty]: Draw a card and reveal it. Remove a number of loyalty counters " +
                "equal to that card's converted mana cost from Jace, Mirror Mage.");
        return card;
    }
}