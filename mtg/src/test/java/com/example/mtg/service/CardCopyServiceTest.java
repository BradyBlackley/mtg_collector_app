package com.example.mtg.service;

import com.example.mtg.model.*;
import com.example.mtg.repository.jdbcRepositories.CardCopyJdbcRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CardCopyServiceTest {

    @InjectMocks
    CardCopyService service;
    @Mock
    CardCopyJdbcRepository repository;
    @Mock
    CardService cardService;
    @Mock
    UserService userService;

    public Card validCard = new Card("ZNR150", "Moraug, Fury of Akoum",
            "card_images\\zendikar_rising\\znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
            "Rudy Siswanto", "6", "6", "6", new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                    " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                    " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                    " you control.");

    public Card validCard1 = new Card("ZNR063", "Jace, Mirror Mage",
            "card_images\\zendikar_rising\\znr-63-jace-mirror-mage.jpg", Rarity.MYTHIC,
            "Tyler Jacobson", "3", null, null, new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Kicker [2 colorless] When Jace, Mirror Mage enters the battlefield, if Jace was kicked, create " +
                    "a token that's a copy of Jace, Mirror Mage, except it's not legendary and it's starting loyalty is 1. " +
                    "[+1 Loyalty]: Scry 2. [+0 Loyalty]: Draw a card and reveal it. Remove a number of loyalty counters " +
                    "equal to that card's converted mana cost from Jace, Mirror Mage.");

    public Card invalidCard = new Card("ZNR150$", "Moraug, Fury of Akoum",
            "card_images\\zendikar_rising\\znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
            "Rudy Siswanto", "6", "6", "6", new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                    " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                    " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                    " you control.");

    public User validUser = new User("965db958-18ed-11ed-861d-0242ac120002", "Bob",
            "Money$M4n");

    public CardCopy validCardCopy = new CardCopy(1, validCard, validUser);

    public CardCopy validCardCopy1 = new CardCopy(2, validCard1, validUser);

    public CardCopy invalidCardCopy = new CardCopy(3, invalidCard, validUser);

    public List<CardCopy> getCardsList() {
        List<CardCopy> cardCopyList = new ArrayList<>();
        cardCopyList.add(validCardCopy);
        cardCopyList.add(validCardCopy1);

        return cardCopyList;
    }

    public Result<Card> getValidCardResult() {
        Result<Card> cardResult = new Result<>();
        cardResult.addMessage("success", ResultType.SUCCESS);
        cardResult.setPayload(validCard);
        return cardResult;
    }

    public Result<Card> getInvalidCardResult() {
        Result<Card> cardResult = new Result<>();
        cardResult.addMessage("The given card id " + invalidCard.getCardId() + " is invalid", ResultType.INVALID);
        cardResult.setPayload(invalidCard);
        return cardResult;
    }

    public Result<User> getValidUserResult() {
        Result<User> userResult = new Result<>();
        userResult.addMessage("success", ResultType.SUCCESS);
        userResult.setPayload(validUser);
        return userResult;
    }

    public Result<User> getInvalidUserResult() {
        Result<User> userResult = new Result<>();
        userResult.addMessage("The provided user id " + validUser.getUserId() + " is " + ResultType.INVALID.label,
                ResultType.INVALID);
        userResult.setPayload(validUser);
        return userResult;
    }

    @Test
    void findAllByUser() {
        Mockito.when(repository.findAllByUser(validCardCopy.getUser().getUserId())).thenReturn(getCardsList());
        assertTrue(service.findAllByUser(validUser.getUserId()).isSuccess());
        assertEquals("success", service.findAllByUser(validUser.getUserId()).getMessages().get(0));
    }

    @Test
    void findAllByUserNoneFound() {
        Mockito.when(repository.findAllByUser(validCardCopy.getUser().getUserId())).thenReturn(null);
        assertFalse(service.findAllByUser(validCardCopy.getUser().getUserId()).isSuccess());
        assertEquals("No card copies found associated with given user " + validCardCopy.getUser().getUserId(),
                service.findAllByUser(validUser.getUserId()).getMessages().get(0));
    }

    @Test
    void findAllByCardId() {
        Mockito.when(repository.findAllByCardId(validCardCopy.getCard().getCardId(),
                validCardCopy.getUser().getUserId())).thenReturn(getCardsList());
        assertTrue(service.findAllByCardId(validCardCopy.getCard().getCardId(),
                validCardCopy.getUser().getUserId()).isSuccess());
        assertEquals("success", service.findAllByCardId(validCardCopy.getCard().getCardId(),
                validCardCopy.getUser().getUserId()).getMessages().get(0));
    }

    @Test
    void findAllByCardIdNoneFound() {
        Mockito.when(repository.findAllByCardId(validCardCopy.getCard().getCardId(),
                validCardCopy.getUser().getUserId())).thenReturn(null);
        assertFalse(service.findAllByCardId(validCardCopy.getCard().getCardId(),
                validCardCopy.getUser().getUserId()).isSuccess());
        assertEquals("No card copies found associated with given card id " + validCardCopy.getCard().getCardId(),
                service.findAllByCardId(validCardCopy.getCard().getCardId(),
                validCardCopy.getUser().getUserId()).getMessages().get(0));
    }

    @Test
    void findByCardCopyId() {
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        assertTrue(service.findByCardCopyId(validCardCopy.getCardCopyId()).isSuccess());
        assertEquals("success", service.findByCardCopyId(validCardCopy.getCardCopyId()).getMessages().get(0));
    }

    @Test
    void findByCardCopyIdNoneFound() {
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(null);
        assertFalse(service.findByCardCopyId(validCardCopy.getCardCopyId()).isSuccess());
        assertEquals("No card copy found associated with given card copy id " + validCardCopy.getCardCopyId(),
                service.findByCardCopyId(validCardCopy.getCardCopyId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.add(validCardCopy)).thenReturn(validCardCopy);
        assertTrue(service.add(validCardCopy).isSuccess());
        assertEquals("success", service.add(validCardCopy).getMessages().get(0));
    }

    @Test
    void addCardCopyIdInvalid() {
        CardCopy temp = validCardCopy;
        temp.setCardCopyId(-1);
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        assertFalse(service.add(validCardCopy).isSuccess());
        assertEquals("The given card copy id " + validCardCopy.getCardCopyId() + " is invalid",
                service.add(validCardCopy).getMessages().get(0));
    }

    @Test
    void addCardCopyIdAlreadyExists() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        assertFalse(service.add(validCardCopy).isSuccess());
        assertEquals("The given card copy id " + validCardCopy.getCardCopyId() + " already exists",
                service.add(validCardCopy).getMessages().get(0));
    }

    @Test
    void addCardCopyCardIsInvalid() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getInvalidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(null);
        assertFalse(service.add(validCardCopy).isSuccess());
        assertEquals("The given user " + validCardCopy.getUser() + " associated with card copy "
                        + validCardCopy + " is invalid",
                service.add(validCardCopy).getMessages().get(1));
    }

    @Test
    void addCardCopyUserIsInvalid() {
        Mockito.when(cardService.findCardById(invalidCardCopy.getCard().getCardId())).thenReturn(getInvalidCardResult());
        Mockito.when(userService.findById(invalidCardCopy.getUser().getUserId())).thenReturn(null);
        Mockito.when(repository.findByCardCopyId(invalidCardCopy.getCardCopyId())).thenReturn(null);
        assertFalse(service.add(invalidCardCopy).isSuccess());
        assertEquals("The given card " + invalidCardCopy.getCard() + " associated with card copy "
                        + invalidCardCopy + " is invalid",
                service.add(invalidCardCopy).getMessages().get(1));
    }

    @Test
    void addFailed() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        assertFalse(service.add(validCardCopy).isSuccess());
        assertEquals("Failed to add given card copy " + validCardCopy,
                service.add(validCardCopy).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        Mockito.when(repository.update(validCardCopy)).thenReturn(true);
        assertTrue(service.update(validCardCopy).isSuccess());
        assertEquals("success", service.update(validCardCopy).getMessages().get(0));
    }

    @Test
    void updateCardCopyIdInvalid() {
        CardCopy temp = validCardCopy;
        temp.setCardCopyId(-1);
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        assertFalse(service.update(validCardCopy).isSuccess());
        assertEquals("The given card copy id " + validCardCopy.getCardCopyId() + " is invalid",
                service.update(validCardCopy).getMessages().get(0));
    }

    @Test
    void updateCardCopyIdDoesNotExist() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(null);
        assertFalse(service.update(validCardCopy).isSuccess());
        assertEquals("The given card copy id " + validCardCopy.getCardCopyId() + " is not found",
                service.update(validCardCopy).getMessages().get(0));
    }

    @Test
    void updateCardCopyUserIsInvalid() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getInvalidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        assertFalse(service.update(validCardCopy).isSuccess());
        assertEquals("The given user " + validCardCopy.getUser() + " associated with card copy "
                        + validCardCopy + " is invalid",
                service.update(validCardCopy).getMessages().get(1));
    }

    @Test
    void updateCardCopyCardIsInvalid() {
        Mockito.when(cardService.findCardById(invalidCardCopy.getCard().getCardId())).thenReturn(getInvalidCardResult());
        Mockito.when(userService.findById(invalidCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(invalidCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        assertFalse(service.update(invalidCardCopy).isSuccess());
        assertEquals("The given card " + invalidCardCopy.getCard() + " associated with card copy "
                        + invalidCardCopy + " is invalid",
                service.update(invalidCardCopy).getMessages().get(1));
    }

    @Test
    void updateFailed() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        Mockito.when(repository.update(validCardCopy)).thenReturn(false);
        assertFalse(service.update(validCardCopy).isSuccess());
        assertEquals("Failed to update given card copy " + validCardCopy,
                service.update(validCardCopy).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        Mockito.when(repository.delete(validCardCopy.getCardCopyId())).thenReturn(true);
        assertTrue(service.delete(validCardCopy).isSuccess());
        assertEquals("success", service.delete(validCardCopy).getMessages().get(0));
    }

    @Test
    void deleteCardCopyIdInvalid() {
        CardCopy temp = validCardCopy;
        temp.setCardCopyId(-1);
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        assertFalse(service.delete(validCardCopy).isSuccess());
        assertEquals("The given card copy id " + validCardCopy.getCardCopyId() + " is invalid",
                service.delete(validCardCopy).getMessages().get(0));
    }

    @Test
    void deleteCardCopyIdDoesNotExist() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(null);
        assertFalse(service.delete(validCardCopy).isSuccess());
        assertEquals("The given card copy id " + validCardCopy.getCardCopyId() + " is not found",
                service.delete(validCardCopy).getMessages().get(0));
    }

    @Test
    void deleteCardCopyUserIsInvalid() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getInvalidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        assertFalse(service.delete(validCardCopy).isSuccess());
        assertEquals("The given user " + validCardCopy.getUser() + " associated with card copy "
                        + validCardCopy + " is invalid",
                service.delete(validCardCopy).getMessages().get(1));
    }

    @Test
    void deleteCardCopyCardIsInvalid() {
        Mockito.when(cardService.findCardById(invalidCardCopy.getCard().getCardId())).thenReturn(getInvalidCardResult());
        Mockito.when(userService.findById(invalidCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(invalidCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        assertFalse(service.delete(invalidCardCopy).isSuccess());
        assertEquals("The given card " + invalidCardCopy.getCard() + " associated with card copy "
                        + invalidCardCopy + " is invalid",
                service.delete(invalidCardCopy).getMessages().get(1));
    }

    @Test
    void deleteFailed() {
        Mockito.when(cardService.findCardById(validCardCopy.getCard().getCardId())).thenReturn(getValidCardResult());
        Mockito.when(userService.findById(validCardCopy.getUser().getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findByCardCopyId(validCardCopy.getCardCopyId())).thenReturn(validCardCopy);
        Mockito.when(repository.delete(validCardCopy.getCardCopyId())).thenReturn(false);
        assertFalse(service.delete(validCardCopy).isSuccess());
        assertEquals("Failed to delete given card copy " + validCardCopy,
                service.delete(validCardCopy).getMessages().get(0));
    }

    @Test
    void validateCardCopy() {
        Mockito.when(cardService.validateCard(validCardCopy.getCard())).thenReturn(true);
        Mockito.when(userService.validateUser(validCardCopy.getUser())).thenReturn(true);
        assertTrue(service.validateCardCopy(validCardCopy));
        assertFalse(service.validateCardCopy(invalidCardCopy));
    }
}