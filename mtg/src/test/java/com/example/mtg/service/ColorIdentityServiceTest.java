package com.example.mtg.service;

import com.example.mtg.model.*;
import com.example.mtg.repository.repositoryInterfaces.ColorIdentityRepository;
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
class ColorIdentityServiceTest {

    @InjectMocks
    ColorIdentityService service;
    @Mock
    ColorIdentityRepository repository;
    @Mock
    CardService cardService;

    public Card validCard = new Card("ZNR150", "Moraug, Fury of Akoum",
            "card_images\\zendikar_rising\\znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
            "Rudy Siswanto", "6", "6", "6", new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                    " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                    " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                    " you control.");

    public List<Color> getColorList() {
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.RED);
        return colorList;
    }

    public Result<Card> getValidCardResult() {
        Result<Card> result = new Result<>();
        result.setPayload(validCard);
        result.addMessage("success", ResultType.SUCCESS);
        return result;
    }

    public Result<Card> getInvalidCardResult() {
        Result<Card> result = new Result<>();
        result.setPayload(validCard);
        result.addMessage("invalid", ResultType.NOT_FOUND);
        return result;
    }

    public ColorIdentity validColorIdentity = new ColorIdentity(validCard.getCardId(), getColorList());

    @Test
    void findByCardId() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertTrue(service.findByCardId(validColorIdentity.getCardId()).isSuccess());
        assertEquals("success", service.findByCardId(validColorIdentity.getCardId()).getMessages().get(0));
    }

    @Test
    void findByCardIdNonFound() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(null);
        assertFalse(service.findByCardId(validColorIdentity.getCardId()).isSuccess());
        assertEquals("No color identities found associated with given card id " +
                        validColorIdentity.getCardId(),
                service.findByCardId(validColorIdentity.getCardId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.add(validColorIdentity)).thenReturn(validColorIdentity);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getValidCardResult());
        assertTrue(service.add(validColorIdentity).isSuccess());
        assertEquals("success", service.add(validColorIdentity).getMessages().get(0));
    }

    @Test
    void addAlreadyExists() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertFalse(service.add(validColorIdentity).isSuccess());
        assertEquals("The given color identity " + validColorIdentity + " already exists",
                service.add(validColorIdentity).getMessages().get(0));
    }

    @Test
    void addCardNotFound() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(null);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getInvalidCardResult());
        assertFalse(service.add(validColorIdentity).isSuccess());
        assertEquals("The card " + validColorIdentity.getCardId() + " associated with given color identity "
                        + validColorIdentity + " is not found ",
                service.add(validColorIdentity).getMessages().get(0));
    }

    @Test
    void addFailed() {
        Mockito.when(repository.add(validColorIdentity)).thenReturn(validColorIdentity);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getValidCardResult());
        Mockito.when(repository.add(validColorIdentity)).thenReturn(null);
        assertFalse(service.add(validColorIdentity).isSuccess());
        assertEquals("Failed to add given color identity" + validColorIdentity,
                service.add(validColorIdentity).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.update(validColorIdentity)).thenReturn(true);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getValidCardResult());
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertTrue(service.update(validColorIdentity).isSuccess());
        assertEquals("success", service.update(validColorIdentity).getMessages().get(0));
    }

    @Test
    void updateDoesNotExist() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(null);
        assertFalse(service.update(validColorIdentity).isSuccess());
        assertEquals("The given color identity " + validColorIdentity + " is not found",
                service.update(validColorIdentity).getMessages().get(0));
    }

    @Test
    void updateCardNotFound() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(null);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getInvalidCardResult());
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertFalse(service.update(validColorIdentity).isSuccess());
        assertEquals("The card " + validColorIdentity.getCardId() + " associated with given color identity "
                        + validColorIdentity + " is not found ",
                service.update(validColorIdentity).getMessages().get(0));
    }

    @Test
    void updateFailed() {
        Mockito.when(repository.update(validColorIdentity)).thenReturn(false);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getValidCardResult());
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertFalse(service.update(validColorIdentity).isSuccess());
        assertEquals("Failed to update given color identity" + validColorIdentity,
                service.update(validColorIdentity).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(repository.delete(validColorIdentity)).thenReturn(true);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getValidCardResult());
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertTrue(service.delete(validColorIdentity).isSuccess());
        assertEquals("success", service.delete(validColorIdentity).getMessages().get(0));
    }

    @Test
    void deleteDoesNotExist() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(null);
        assertFalse(service.delete(validColorIdentity).isSuccess());
        assertEquals("The given color identity " + validColorIdentity + " is not found",
                service.delete(validColorIdentity).getMessages().get(0));
    }

    @Test
    void deleteCardNotFound() {
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(null);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getInvalidCardResult());
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertFalse(service.delete(validColorIdentity).isSuccess());
        assertEquals("The card " + validColorIdentity.getCardId() + " associated with given color identity "
                        + validColorIdentity + " is not found ",
                service.delete(validColorIdentity).getMessages().get(0));
    }

    @Test
    void deleteFailed() {
        Mockito.when(repository.delete(validColorIdentity)).thenReturn(false);
        Mockito.when(cardService.findCardById(validColorIdentity.getCardId())).thenReturn(getValidCardResult());
        Mockito.when(repository.findByCardId(validColorIdentity.getCardId())).thenReturn(validColorIdentity);
        assertEquals("Failed to delete given color identity" + validColorIdentity,
                service.delete(validColorIdentity).getMessages().get(0));
    }
}