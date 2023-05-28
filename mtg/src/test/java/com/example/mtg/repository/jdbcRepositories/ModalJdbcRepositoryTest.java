package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Modal;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/Modal.sql"})
@ContextConfiguration(
        classes = {ModalJdbcRepository.class}
)
class ModalJdbcRepositoryTest extends CommonRepoTest {

//    @Autowired
//    ModalJdbcRepository repository;
//
//    @Test
//    void findByFrontCardId() {
//        assertEquals("Spikefield Hazard", repository.findByFrontCardId("ZNR166F").getfrontCard().getCardName());
//        assertEquals("Spikefield Cave", repository.findByFrontCardId("ZNR166F").getbackCard().getCardName());
//    }
//
//    @Test
//    void findByBackCardId() {
//        assertEquals("Spikefield Hazard", repository.findByBackCardId("ZNR166B").getfrontCard().getCardName());
//        assertEquals("Spikefield Cave", repository.findByBackCardId("ZNR166B").getbackCard().getCardName());
//
//    }
//
//    @Test
//    void findByModalId() {
//        assertEquals("Spikefield Hazard", repository.findByModalId("ZNR166").getfrontCard().getCardName());
//        assertEquals("Spikefield Cave", repository.findByModalId("ZNR166").getbackCard().getCardName());
//    }
//
//    @Test
//    void add() {
//        Card front = makeFrontCard();
//        Card back = makeBackCard();
//
//        Modal modal = new Modal("ZNR216", front, back);
//
//        assertNotNull(repository.add(modal));
//        assertEquals("Vastwood Fortification", repository.findByModalId("ZNR216").getfrontCard().getCardName());
//        assertEquals("Vastwood Thicket", repository.findByModalId("ZNR216").getbackCard().getCardName());
//
//    }
//
//    @Test
//    void update() {
//        Modal modal = repository.findByModalId("ZNR166");
//
//        Card newFront = makeFrontCard();
//        modal.setfrontCard(newFront);
//
//        assertTrue(repository.update(modal));
//        assertNotNull(repository.findByModalId("ZNR166"));
//        assertEquals("Put a +1/+1 counter on target creature.", repository.findByModalId("ZNR166").getfrontCard().getTextBox());
//    }
//
//    @Test
//    void delete() {
//        assertFalse(repository.delete("ZNR100"));
//        assertTrue(repository.delete("ZNR166"));
//        assertNull(repository.findByModalId("ZNR166"));
//    }
//
//    private Card makeFrontCard(){
//        Card front = new Card();
//        front.setCardId("ZNR216F");
//        front.setCardName("Vastwood Fortification");
//        front.setImagePath("card_images/zendikar_rising/znr-216-vastwood-fortification.jpg");
//        front.setRarity(Rarity.UNCOMMON);
//        front.setArtistName("Sidharth Chaturvedi");
//        front.setConvertedManaCost("1");
//        front.setPower(null);
//        front.setToughness(null);
//        front.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
//                Date.valueOf("2020-09-01")));
//        front.setTextBox("Put a +1/+1 counter on target creature.");
//        return front;
//    }
//
//    private Card makeBackCard(){
//        Card back = new Card();
//        back.setCardId("ZNR216B");
//        back.setCardName("Vastwood Thicket");
//        back.setImagePath("card_images/zendikar_rising/znr-216-vastwood-thicket.jpg");
//        back.setRarity(Rarity.UNCOMMON);
//        back.setArtistName("Sidharth Chaturvedi");
//        back.setConvertedManaCost(null);
//        back.setPower(null);
//        back.setToughness(null);
//        back.setExpansion(new Expansion(1, "Zendikar Rising", "ZNR",
//                Date.valueOf("2020-09-01")));
//        back.setTextBox("Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]");
//        return back;
//    }
}