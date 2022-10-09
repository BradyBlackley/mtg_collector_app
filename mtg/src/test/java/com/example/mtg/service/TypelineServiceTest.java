package com.example.mtg.service;

import com.example.mtg.model.*;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
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
public class TypelineServiceTest {

    @InjectMocks
    private TypelineService service;
    @Mock
    TypelineRepository repository;
    @Mock
    TypeService typeService;
    @Mock
    CardService cardService;

    public Type validType = new Type(1, "Creature");

    public Type validType1 = new Type(2, "Land");

    public Type validType2 = new Type(3, "Legendary");

    public Card validCard = new Card("ZNR150", "Moraug, Fury of Akoum",
            "card_images\\zendikar_rising\\znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
            "Rudy Siswanto", "6", "6", "6", new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                    " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                    " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                    " you control.");

    public List<Type> getTypeList() {
        List<Type> typeList = new ArrayList<>();
        typeList.add(validType);
        typeList.add(validType1);
        typeList.add(validType2);

        return typeList;
    }

    public Typeline validTypeline = new Typeline(getTypeList(), validCard);


    @Test
    void findByCardId() {
        Mockito.when(repository.findByCardId(validCard.getCardId())).thenReturn(validTypeline);
        assertTrue(service.findByCardId(validCard.getCardId()).isSuccess());
        assertEquals("success", service.findByCardId(validCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByCardIdNoneFound() {
        Mockito.when(repository.findByCardId(validCard.getCardId())).thenReturn(null);
        assertFalse(service.findByCardId(validCard.getCardId()).isSuccess());
        assertEquals("No typeline found associated with given card id " + validCard.getCardId(),
                service.findByCardId(validCard.getCardId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(null);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(0))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(1))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(2))).thenReturn(true);
        Mockito.when(cardService.validateCard(validTypeline.getCard())).thenReturn(true);
        Mockito.when(repository.add(validTypeline)).thenReturn(validTypeline);
        assertTrue(service.add(validTypeline).isSuccess());
        assertEquals("success", service.add(validTypeline).getMessages().get(0));
    }

    @Test
    void addAlreadyExists() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        assertFalse(service.add(validTypeline).isSuccess());
        assertEquals("Typeline associated with given card " + validTypeline.getCard() + " already exists",
                service.add(validTypeline).getMessages().get(0));
    }

    @Test
    void addNotValid() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(null);
        assertFalse(service.add(validTypeline).isSuccess());
        assertEquals("Card or types associated with given typeline " + validTypeline + " are not valid",
                service.add(validTypeline).getMessages().get(0));
    }

    @Test
    void addFailed() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(null);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(0))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(1))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(2))).thenReturn(true);
        Mockito.when(cardService.validateCard(validTypeline.getCard())).thenReturn(true);
        Mockito.when(repository.add(validTypeline)).thenReturn(null);
        assertFalse(service.add(validTypeline).isSuccess());
        assertEquals("Failed to add given typeline", service.add(validTypeline).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(0))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(1))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(2))).thenReturn(true);
        Mockito.when(cardService.validateCard(validTypeline.getCard())).thenReturn(true);
        Mockito.when(repository.update(validTypeline)).thenReturn(true);
        assertTrue(service.update(validTypeline).isSuccess());
        assertEquals("success", service.update(validTypeline).getMessages().get(0));
    }

    @Test
    void updateNotFound() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(null);
        assertFalse(service.update(validTypeline).isSuccess());
        assertEquals("Given typeline " + validTypeline.getCard() + " is not found",
                service.update(validTypeline).getMessages().get(0));
    }

    @Test
    void updateNotValid() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        assertFalse(service.update(validTypeline).isSuccess());
        assertEquals("Card or types associated with given typeline " + validTypeline + " are not valid",
                service.update(validTypeline).getMessages().get(0));
    }

    @Test
    void updateFailed() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(0))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(1))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(2))).thenReturn(true);
        Mockito.when(cardService.validateCard(validTypeline.getCard())).thenReturn(true);
        Mockito.when(repository.update(validTypeline)).thenReturn(false);
        assertFalse(service.update(validTypeline).isSuccess());
        assertEquals("Failed to update given typeline", service.update(validTypeline).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(0))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(1))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(2))).thenReturn(true);
        Mockito.when(cardService.validateCard(validTypeline.getCard())).thenReturn(true);
        Mockito.when(repository.delete(validTypeline)).thenReturn(true);
        assertTrue(service.delete(validTypeline).isSuccess());
        assertEquals("success", service.delete(validTypeline).getMessages().get(0));
    }

    @Test
    void deleteNotFound() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(null);
        assertFalse(service.delete(validTypeline).isSuccess());
        assertEquals("Given typeline " + validTypeline.getCard() + " is not found",
                service.delete(validTypeline).getMessages().get(0));
    }

    @Test
    void deleteNotValid() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        assertFalse(service.delete(validTypeline).isSuccess());
        assertEquals("Card or types associated with given typeline are not valid",
                service.delete(validTypeline).getMessages().get(0));
    }

    @Test
    void deleteFailed() {
        Mockito.when(repository.findByCardId(validTypeline.getCard().getCardId())).thenReturn(validTypeline);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(0))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(1))).thenReturn(true);
        Mockito.when(typeService.validateType(validTypeline.getTypes().get(2))).thenReturn(true);
        Mockito.when(cardService.validateCard(validTypeline.getCard())).thenReturn(true);
        Mockito.when(repository.delete(validTypeline)).thenReturn(false);
        assertFalse(service.delete(validTypeline).isSuccess());
        assertEquals("Failed to delete given typeline", service.delete(validTypeline).getMessages().get(0));
    }
}
