package com.example.mtg.service;

import com.example.mtg.model.*;
import com.example.mtg.repository.repositoryInterfaces.KeywordListRepository;
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
class KeywordListServiceTest {
    @InjectMocks
    KeywordListService service;
    @Mock
    KeywordListRepository repository;
    @Mock
    KeywordService keywordService;
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

    public List<Keyword> getKeywordList() {
        Keyword doubleStrike = new Keyword(1, "Double Strike");
        Keyword flash = new Keyword(2, "Flash");
        Keyword enlist = new Keyword(3, "Enlist");
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(doubleStrike);
        keywords.add(flash);
        keywords.add(enlist);
        return keywords;
    }

    public List<Keyword> getInvalidKeywordList() {
        Keyword doubleStrike = new Keyword(1, "Double St$$rike");
        Keyword flash = new Keyword(2, "Fl@sh");
        Keyword enlist = new Keyword(3, "Enlis7");
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(doubleStrike);
        keywords.add(flash);
        keywords.add(enlist);
        return keywords;
    }

    public KeywordList validKeywordList = new KeywordList(getKeywordList(), validCard);

    public KeywordList invalidKeywordList = new KeywordList(getInvalidKeywordList(), validCard);

    @Test
    void findByCardId() {
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(validKeywordList);
        assertTrue(service.findByCardId(validKeywordList.getCard().getCardId()).isSuccess());
        assertEquals("success", service.findByCardId(validKeywordList.getCard().getCardId()).getMessages().get(0));
    }

    @Test
    void findByCardIdNotFound() {
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(null);
        assertFalse(service.findByCardId(validKeywordList.getCard().getCardId()).isSuccess());
        assertEquals("No keyword list found associated with given card id "
                        + validKeywordList.getCard().getCardId(),
                service.findByCardId(validKeywordList.getCard().getCardId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(null);
        Mockito.when(repository.add(validKeywordList)).thenReturn(validKeywordList);
        assertTrue(service.add(validKeywordList).isSuccess());
        assertEquals("success", service.add(validKeywordList).getMessages().get(0));
    }

    @Test
    void addKeywordOrCardInvalid() {
        assertFalse(service.add(invalidKeywordList).isSuccess());
        assertEquals("Keyword or card associated with given keyword list is not valid", service.add(invalidKeywordList).getMessages().get(0));
    }

    @Test
    void addAlreadyExists() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(validKeywordList);
        assertFalse(service.add(validKeywordList).isSuccess());
        assertEquals("The given keyword list associated with card " + validKeywordList.getCard().getCardId() +
                " already exists", service.add(validKeywordList).getMessages().get(0));
    }

    @Test
    void addFailed() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(null);
        Mockito.when(repository.add(validKeywordList)).thenReturn(null);
        assertFalse(service.add(validKeywordList).isSuccess());
        assertEquals("Failed to add given keyword list " + validKeywordList,
                service.add(validKeywordList).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(validKeywordList);
        Mockito.when(repository.update(validKeywordList)).thenReturn(true);
        assertTrue(service.update(validKeywordList).isSuccess());
        assertEquals("success", service.update(validKeywordList).getMessages().get(0));
    }

    @Test
    void updateKeywordOrCardInvalid() {
        assertFalse(service.update(invalidKeywordList).isSuccess());
        assertEquals("Keyword or card associated with given keyword list is not valid", service.add(invalidKeywordList).getMessages().get(0));
    }

    @Test
    void updateNotFound() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(null);
        assertFalse(service.update(validKeywordList).isSuccess());
        assertEquals("The given keyword list associated with card " + validKeywordList.getCard().getCardId() +
                " is not found", service.update(validKeywordList).getMessages().get(0));
    }

    @Test
    void updateFailed() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(validKeywordList);
        Mockito.when(repository.update(validKeywordList)).thenReturn(false);
        assertFalse(service.update(validKeywordList).isSuccess());
        assertEquals("Failed to update given keyword list " + validKeywordList,
                service.update(validKeywordList).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(validKeywordList);
        Mockito.when(repository.delete(validKeywordList)).thenReturn(true);
        assertTrue(service.delete(validKeywordList).isSuccess());
        assertEquals("success", service.delete(validKeywordList).getMessages().get(0));
    }

    @Test
    void deleteKeywordOrCardInvalid() {
        assertFalse(service.delete(invalidKeywordList).isSuccess());
        assertEquals("Keyword or card associated with given keyword list is not valid", service.add(invalidKeywordList).getMessages().get(0));
    }

    @Test
    void deleteNotFound() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(null);
        assertFalse(service.update(validKeywordList).isSuccess());
        assertEquals("The given keyword list associated with card " + validKeywordList.getCard().getCardId() +
                " is not found", service.delete(validKeywordList).getMessages().get(0));
    }

    @Test
    void deleteFailed() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        Mockito.when(repository.findByCardId(validKeywordList.getCard().getCardId())).thenReturn(validKeywordList);
        Mockito.when(repository.delete(validKeywordList)).thenReturn(false);
        assertFalse(service.delete(validKeywordList).isSuccess());
        assertEquals("Failed to delete given keyword list " + validKeywordList,
                service.delete(validKeywordList).getMessages().get(0));
    }

    @Test
    void validateKeywordList() {
        Mockito.when(cardService.validateCard(validKeywordList.getCard())).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(0))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(1))).thenReturn(true);
        Mockito.when(keywordService.validateKeyword(validKeywordList.getKeywords().get(2))).thenReturn(true);
        assertTrue(service.validateKeywordList(validKeywordList));
    }

    @Test
    void validateKeywordListInvalidKeywords() {
        assertFalse(service.validateKeywordList(validKeywordList));
    }
}