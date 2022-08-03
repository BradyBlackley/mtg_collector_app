package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.*;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Typeline.sql"})
@ContextConfiguration(
        classes = {TypelineJdbcRepository.class}
)
class TypelineJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    TypelineJdbcRepository repository;

    @Test
    void findByCardId() {
        assertEquals("ZNR150", repository.findByCardId("ZNR150").getCard().getCardId());
    }

    @Test
    void add() {
        Card card = makeCard();
        Typeline typeline = new Typeline();
        List<Type> types = new ArrayList<>();
        types.add(new Type(1, "Legendary"));
        types.add(new Type(2, "Creature"));
        types.add(new Type(3, "Minotaur"));
        types.add(new Type(4, "Warrior"));
        typeline.setCard(card);
        typeline.setTypes(types);

        assertNotNull(repository.add(typeline));
    }

    @Test
    void update() {
        Typeline typeline = repository.findByCardId("ZNR150");
        Type type = new Type(5, "Wizard");
        typeline.getTypes().add(type);
        assertTrue(repository.update(typeline));
    }

    @Test
    void delete() {
        assertTrue(repository.delete(1, "ZNR150"));
    }

    @Test
    void rsIs0(){
        assertNull(repository.findByCardId(""));
    }

    private Card makeCard() {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(1);
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
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                " Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an" +
                " additional combat phase after this phase. At the beginning of that combat, untap all creatures you" +
                " control.");
        return card;
    }
}