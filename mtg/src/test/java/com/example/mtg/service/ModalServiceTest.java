package com.example.mtg.service;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Modal;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.jdbcRepositories.ModalJdbcRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModalServiceTest {

    @InjectMocks
    ModalService service;
    @Mock
    ModalJdbcRepository repository;
    @Mock
    CardService cardService;

    public Card validFrontCard = new Card("ZNR215F", "Turntimber Symbiosis",
            "card_images\\zendikar_rising\\znr-215-turntimber-symbiosis.jpg", Rarity.MYTHIC,
            "Randy Vargas", "7", null, null, new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Look at the top seven cards of your library. You may put a creature card from among them into the" +
                    " battlefield. If that card has a converted mana cost 3 or less, it enters with three additional " +
                    "+1/+1 counters on it. Put the rest on the bottom of your library in a random order.");

    public Card validBackCard = new Card("ZNR215B", "Turntimber, Serpentine Wood",
            "card_images\\zendikar_rising\\znr-215-turntimber-serpentine-wood.jpg", Rarity.MYTHIC,
            "Randy Vargas", null, null, null, new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "As Turntimber, Serpentine Wood enters the battlefield, you may pay 3 life. If you don't, it enters " +
                    "the battlefield tapped. [tap]: Add [green]");

    public Card invalidFrontCard = new Card("ZNR215", "Turntimber Symbiosis",
            "card_images\\zendikar_rising\\znr-215-turntimber-symbiosis.jpg", Rarity.MYTHIC,
            "Randy Vargas", "7", null, null, new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Look at the top seven cards of your library. You may put a creature card from among them into the" +
                    " battlefield. If that card has a converted mana cost 3 or less, it enters with three additional " +
                    "+1/+1 counters on it. Put the rest on the bottom of your library in a random order.");

    public Card invalidBackCard = new Card("ZNR215", "Turntimber, Serpentine Wood",
            "card_images\\zendikar_rising\\znr-215-turntimber-serpentine-wood.jpg", Rarity.MYTHIC,
            "Randy Vargas", null, null, null, new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "As Turntimber, Serpentine Wood enters the battlefield, you may pay 3 life. If you don't, it enters " +
                    "the battlefield tapped. [tap]: Add [green]");

    public Modal validModal = new Modal("ZNR215", validFrontCard, validBackCard);
    public Modal invalidModal = new Modal("B@d", invalidFrontCard, invalidBackCard);

    @Test
    void findByFrontCardId() {
        Mockito.when(repository.findByFrontCardId(validFrontCard.getCardId())).thenReturn(validModal);
        assertTrue(service.findByFrontCardId(validFrontCard.getCardId()).isSuccess());
        assertEquals("success", service.findByFrontCardId(validFrontCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByFrontCardId_NoneFound() {
        Mockito.when(repository.findByFrontCardId(validFrontCard.getCardId())).thenReturn(null);
        assertFalse(service.findByFrontCardId(validFrontCard.getCardId()).isSuccess());
        assertEquals("No cards found by given front card id " + validFrontCard.getCardId(),
                service.findByFrontCardId(validFrontCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByBackCardId() {
        Mockito.when(repository.findByBackCardId(validFrontCard.getCardId())).thenReturn(validModal);
        assertTrue(service.findByBackCardId(validFrontCard.getCardId()).isSuccess());
        assertEquals("success", service.findByBackCardId(validFrontCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByBackCardId_NoneFound() {
        Mockito.when(repository.findByBackCardId(validFrontCard.getCardId())).thenReturn(null);
        assertFalse(service.findByBackCardId(validFrontCard.getCardId()).isSuccess());
        assertEquals("No cards found by given back card id " + validFrontCard.getCardId(),
                service.findByBackCardId(validFrontCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByModalId() {
        Mockito.when(repository.findByModalId(validFrontCard.getCardId())).thenReturn(validModal);
        assertTrue(service.findByModalId(validFrontCard.getCardId()).isSuccess());
        assertEquals("success", service.findByModalId(validFrontCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByModalId_NoneFound() {
        Mockito.when(repository.findByModalId(validFrontCard.getCardId())).thenReturn(null);
        assertFalse(service.findByModalId(validFrontCard.getCardId()).isSuccess());
        assertEquals("No cards found by given modal id " + validFrontCard.getCardId(),
                service.findByModalId(validFrontCard.getCardId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.add(validModal)).thenReturn(validModal);
        assertTrue(service.add(validModal).isSuccess());
        assertEquals("success", service.add(validModal).getMessages().get(0));
    }

    @Test
    void add_InvalidModal() {
        assertFalse(service.add(invalidModal).isSuccess());
        assertEquals("The given modal " + invalidModal + " is invalid",
                service.add(invalidModal).getMessages().get(0));
    }

    @Test
    void add_ModalAlreadyExists() {
        Mockito.when(repository.findByModalId(validModal.getModalId())).thenReturn(validModal);
        assertFalse(service.add(validModal).isSuccess());
        assertEquals("The given modal " + validModal + " already exists",
                service.add(validModal).getMessages().get(0));
    }

    @Test
    void add_Failed() {
        Mockito.when(repository.findByModalId(validModal.getModalId())).thenReturn(validModal);
        Mockito.when(service.add(validModal)).thenReturn(null);
        assertFalse(service.add(validModal).isSuccess());
        assertEquals("Failed to add given modal " + validModal,
                service.add(validModal).getMessages().get(0));
    }
}