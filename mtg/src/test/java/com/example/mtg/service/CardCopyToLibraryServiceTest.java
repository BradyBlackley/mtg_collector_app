package com.example.mtg.service;

import com.example.mtg.model.*;
import com.example.mtg.repository.repositoryInterfaces.CardCopyToLibraryRepository;
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
class CardCopyToLibraryServiceTest {

    @InjectMocks
    CardCopyToLibraryService service;
    @Mock
    CardCopyToLibraryRepository repository;
    @Mock
    CardCopyService cardCopyService;
    @Mock
    LibraryService libraryService;

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

    public String validUserId = "965db958-18ed-11ed-861d-0242ac120002";

    public CardCopy validCardCopy = new CardCopy(1, validCard, validUserId);

    public CardCopy validCardCopy1 = new CardCopy(1, validCard1, validUserId);

    public Library validLibrary = new Library(1, "Dragons", validUserId);

    public List<CardCopy> getCardCopies() {
        List<CardCopy> cardCopies = new ArrayList<>();
        cardCopies.add(validCardCopy);
        cardCopies.add(validCardCopy1);
        return cardCopies;
    }

    public CardCopyToLibrary validCardCopyToLibrary = new CardCopyToLibrary(getCardCopies(), validLibrary);

    public Result<CardCopyToLibrary> getValidResult() {
        Result<CardCopyToLibrary> result = new Result<>();
        result.setPayload(validCardCopyToLibrary);
        result.addMessage("success", ResultType.SUCCESS);
        return result;
    }

    @Test
    void findByLibraryId() {
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(validCardCopyToLibrary);
        assertTrue(service.findByLibraryId(validCardCopyToLibrary).isSuccess());
        assertEquals("success", service.findByLibraryId(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void findByLibraryIdNoCardCopiesFound() {
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(null);
        assertFalse(service.findByLibraryId(validCardCopyToLibrary).isSuccess());
        assertEquals("No card copies found associated with given library "
                + validCardCopyToLibrary.getLibrary(),
                service.findByLibraryId(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.add(validCardCopyToLibrary)).thenReturn(validCardCopyToLibrary);
        assertTrue(service.add(validCardCopyToLibrary).isSuccess());
        assertEquals("success", service.add(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void addInvalidCardCopyToLibrary() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        assertFalse(service.add(validCardCopyToLibrary).isSuccess());
        assertEquals("Card copy or library associated with given card copy to library is not valid",
                service.add(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void addCardCopyToLibraryAlreadyExists() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(validCardCopyToLibrary);
        assertFalse(service.add(validCardCopyToLibrary).isSuccess());
        assertEquals("Card copy to library already exists",
                service.add(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void addCardCopyToLibraryFailed() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(null);
        Mockito.when(repository.add(validCardCopyToLibrary)).thenReturn(null);
        assertFalse(service.add(validCardCopyToLibrary).isSuccess());
        assertEquals("Failed to add given card copy to library " + validCardCopyToLibrary,
                service.add(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(validCardCopyToLibrary);
        Mockito.when(repository.update(validCardCopyToLibrary)).thenReturn(true);
        assertTrue(service.update(validCardCopyToLibrary).isSuccess());
        assertEquals("success", service.update(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void updateInvalidCardCopyToLibrary() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        assertFalse(service.update(validCardCopyToLibrary).isSuccess());
        assertEquals("Card copy or library associated with given card copy to library is not valid",
                service.update(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void updateCardCopyToLibraryDoesNotExist() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(null);
        assertFalse(service.update(validCardCopyToLibrary).isSuccess());
        assertEquals("Given card copy to library is not found",
                service.update(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void updateCardCopyToLibraryFailed() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(validCardCopyToLibrary);
        Mockito.when(repository.update(validCardCopyToLibrary)).thenReturn(false);
        assertFalse(service.update(validCardCopyToLibrary).isSuccess());
        assertEquals("Failed to update given card copy to library " + validCardCopyToLibrary,
                service.update(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(validCardCopyToLibrary);
        Mockito.when(repository.delete(validCardCopyToLibrary)).thenReturn(true);
        assertTrue(service.delete(validCardCopyToLibrary).isSuccess());
        assertEquals("success", service.delete(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void deleteInvalidCardCopyToLibrary() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        assertFalse(service.delete(validCardCopyToLibrary).isSuccess());
        assertEquals("Card copy or library associated with given card copy to library is not valid",
                service.delete(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void deleteCardCopyToLibraryDoesNotExist() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(null);
        assertFalse(service.delete(validCardCopyToLibrary).isSuccess());
        assertEquals("Given card copy to library is not found",
                service.delete(validCardCopyToLibrary).getMessages().get(0));
    }

    @Test
    void deleteCardCopyToLibraryFailed() {
        Mockito.when(service.validateCardCopyToLibrary(validCardCopyToLibrary)).thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(1)))
                .thenReturn(true);
        Mockito.when(cardCopyService.validateCardCopy(validCardCopyToLibrary.getCardCopies().get(0)))
                .thenReturn(true);
        Mockito.when(libraryService.validateLibrary(validCardCopyToLibrary.getLibrary()))
                .thenReturn(true);
        Mockito.when(repository.findByLibraryId(validCardCopyToLibrary.getLibrary().getLibraryId()))
                .thenReturn(validCardCopyToLibrary);
        Mockito.when(repository.delete(validCardCopyToLibrary)).thenReturn(false);
        assertFalse(service.delete(validCardCopyToLibrary).isSuccess());
        assertEquals("Failed to delete given card copy to library " + validCardCopyToLibrary,
                service.delete(validCardCopyToLibrary).getMessages().get(0));
    }
}