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

@Sql({"classpath:data/KeywordList.sql"})
@ContextConfiguration(
        classes = {KeywordListJdbcRepository.class}
)
class KeywordListJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    KeywordListJdbcRepository repository;

    @Test
    void findByCardId() {
        assertEquals( "Double Strike", repository.findByCardId("ZNR150").getKeywords().get(0).getKeywordName());
        assertEquals("Flying", repository.findByCardId("ZNR150").getKeywords().get(1).getKeywordName());
        assertEquals("Vigilance", repository.findByCardId("ZNR150").getKeywords().get(2).getKeywordName());
        assertEquals("Moraug, Fury of Akoum", repository.findByCardId("ZNR150").getCard().getCardName());
    }

    @Test
    void add() {
        Keyword flash = new Keyword("Flash");
        Keyword firstStrike = new Keyword("First-Strike");
        List<Keyword> keywords = new ArrayList<>();

        keywords.add(flash);
        keywords.add(firstStrike);

        KeywordList keywordList = new KeywordList();

        keywordList.setKeywords(keywords);
        keywordList.setCard(makeCard());

        assertEquals(keywordList, repository.add(keywordList));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
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