package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.*;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/CardCopy.sql"})
@ContextConfiguration(
        classes = {CardCopyJdbcRepository.class}
)
class CardCopyJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    CardCopyJdbcRepository repository;

    @Test
    void findAllByUser() {
        assertEquals(4, repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").size());
        assertEquals("ZNR150",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getCard().getCardId());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getUser().getUserId());
        assertEquals(1,
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(0).getCardCopyId());
        assertEquals("ZNR134",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(1).getCard().getCardId());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(1).getUser().getUserId());
        assertEquals(2,
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(1).getCardCopyId());
        assertEquals("ZNR134",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(2).getCard().getCardId());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(2).getUser().getUserId());
        assertEquals(3,
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(2).getCardCopyId());
        assertEquals("ZNR134",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(3).getCard().getCardId());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(3).getUser().getUserId());
        assertEquals(4,
                repository.findAllByUser("5d209ac0-9102-11ec-b909-0242ac120002").get(3).getCardCopyId());

        assertEquals(2, repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").size());
        assertEquals("ZNR166F",
                repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").get(0).getCard().getCardId());
        assertEquals("9a219974-9102-11ec-b909-0242ac120002",
                repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").get(0).getUser().getUserId());
        assertEquals("ZNR166B",
                repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").get(1).getCard().getCardId());
        assertEquals("9a219974-9102-11ec-b909-0242ac120002",
                repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").get(1).getUser().getUserId());
    }

    @Test
    void findAllByCardId() {
        assertEquals(3,
                repository.findAllByCardId("ZNR134", "5d209ac0-9102-11ec-b909-0242ac120002").size());
        assertEquals(1,
                repository.findAllByCardId("ZNR166F", "9a219974-9102-11ec-b909-0242ac120002").size());
        assertEquals(1,
                repository.findAllByCardId("ZNR166B", "9a219974-9102-11ec-b909-0242ac120002").size());
    }

    @Test
    void findByCardCopyId() {
        assertEquals("ZNR150", repository.findByCardCopyId(1).getCard().getCardId());
        assertEquals("ZNR134", repository.findByCardCopyId(2).getCard().getCardId());
        assertEquals("ZNR134", repository.findByCardCopyId(3).getCard().getCardId());
        assertEquals("ZNR134", repository.findByCardCopyId(4).getCard().getCardId());
        assertEquals("ZNR166F", repository.findByCardCopyId(5).getCard().getCardId());
        assertEquals("ZNR166B", repository.findByCardCopyId(6).getCard().getCardId());
    }

    @Test
    void add() {
        assertEquals(2, repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").size());
        assertNotNull(repository.add(makeCardCopy()));
        assertEquals(3, repository.findAllByUser("9a219974-9102-11ec-b909-0242ac120002").size());
    }

    @Test
    void update() {
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findByCardCopyId(1).getUser().getUserId());
        CardCopy cardCopy = repository.findByCardCopyId(1);
        cardCopy.setUser(new User("9a219974-9102-11ec-b909-0242ac120002"));
        assertTrue(repository.update(cardCopy));
        assertEquals("9a219974-9102-11ec-b909-0242ac120002",
                repository.findByCardCopyId(1).getUser().getUserId());
    }

    @Test
    void delete() {
        assertFalse(repository.delete(100));
        assertTrue(repository.delete(1));
    }

    private CardCopy makeCardCopy() {
        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(new Card("ZNR150"));
        cardCopy.setUser(new User("9a219974-9102-11ec-b909-0242ac120002"));
        return cardCopy;
    }
}