package com.example.mtg.service;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.jdbcRepositories.CardJdbcRepository;
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
class CardServiceTest {

    @InjectMocks
    CardService service;
    @Mock
    CardJdbcRepository repository;
    @Mock
    ExpansionService expansionService;

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

    public List<Card> getCardsList() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(validCard);
        cardList.add(validCard1);

        return cardList;
    }

    public Result<Expansion> getValidExpansionResult() {
        Result<Expansion> result = new Result<>();
        result.setPayload(validCard.getExpansion());
        result.addMessage("success", ResultType.SUCCESS);
        return result;
    }

    @Test
    void findAllCards() {
        Mockito.when(repository.findAllCards()).thenReturn(getCardsList());
        assertTrue(service.findAllCards().isSuccess());
        assertEquals("success", service.findAllCards().getMessages().get(0));
    }

    @Test
    void findAllCardsNoneFound() {
        Mockito.when(repository.findAllCards()).thenReturn(null);
        assertFalse(service.findAllCards().isSuccess());
        assertEquals("No cards found", service.findAllCards().getMessages().get(0));
    }

    @Test
    void findCardsByName() {
        Mockito.when(repository.findCardsByName(validCard.getCardName())).thenReturn(getCardsList());
        assertTrue(service.findCardsByName(validCard.getCardName()).isSuccess());
        assertEquals("success", service.findAllCards().getMessages().get(0));
    }

    @Test
    void findCardsByNameNoneFound() {
        Mockito.when(repository.findCardsByName(validCard.getCardName())).thenReturn(null);
        assertFalse(service.findCardsByName(validCard.getCardName()).isSuccess());
        assertEquals("No cards found by given name " + validCard.getCardName(),
                service.findCardsByName(validCard.getCardName()).getMessages().get(0));
    }

    @Test
    void findCardsByRarity() {
        Mockito.when(repository.findCardsByRarity(validCard.getRarity())).thenReturn(getCardsList());
        assertTrue(service.findCardsByRarity(validCard.getRarity()).isSuccess());
        assertEquals("success", service.findCardsByRarity(validCard.getRarity()).getMessages().get(0));
    }

    @Test
    void findCardsByRarityNoneFound() {
        Mockito.when(repository.findCardsByRarity(validCard.getRarity())).thenReturn(null);
        assertFalse(service.findCardsByRarity(validCard.getRarity()).isSuccess());
        assertEquals("No cards found by given rarity " + validCard.getRarity().label,
                service.findCardsByRarity(validCard.getRarity()).getMessages().get(0));
    }

    @Test
    void findCardsByArtist() {
        Mockito.when(repository.findCardsByArtist(validCard.getArtistName())).thenReturn(getCardsList());
        assertTrue(service.findCardsByArtist(validCard.getArtistName()).isSuccess());
        assertEquals("success", service.findCardsByArtist(validCard.getArtistName()).getMessages().get(0));
    }

    @Test
    void findCardsByArtistNoneFound() {
        Mockito.when(repository.findCardsByArtist(validCard.getArtistName())).thenReturn(null);
        assertFalse(service.findCardsByArtist(validCard.getArtistName()).isSuccess());
        assertEquals("No cards found by given artist name " + validCard.getArtistName(),
                service.findCardsByArtist(validCard.getArtistName()).getMessages().get(0));
    }

    @Test
    void findCardsByConvertedManaCost() {
        Mockito.when(repository.findCardsByConvertedManaCost(validCard.getConvertedManaCost())).thenReturn(getCardsList());
        assertTrue(service.findCardsByConvertedManaCost(validCard.getConvertedManaCost()).isSuccess());
        assertEquals("success",
                service.findCardsByConvertedManaCost(validCard.getConvertedManaCost()).getMessages().get(0));
    }

    @Test
    void findCardsByConvertedManaCostNoneFound() {
        Mockito.when(repository.findCardsByConvertedManaCost(validCard.getConvertedManaCost())).thenReturn(null);
        assertFalse(service.findCardsByConvertedManaCost(validCard.getConvertedManaCost()).isSuccess());
        assertEquals("No cards found with given converted mana cost " + validCard.getConvertedManaCost(),
                service.findCardsByConvertedManaCost(validCard.getConvertedManaCost()).getMessages().get(0));
    }

    @Test
    void findCardsByPower() {
        Mockito.when(repository.findCardsByPower(validCard.getPower())).thenReturn(getCardsList());
        assertTrue(service.findCardsByPower(validCard.getPower()).isSuccess());
        assertEquals("success", service.findCardsByPower(validCard.getPower()).getMessages().get(0));
    }

    @Test
    void findCardsByPowerNoneFound() {
        Mockito.when(repository.findCardsByPower(validCard.getPower())).thenReturn(null);
        assertFalse(service.findCardsByPower(validCard.getPower()).isSuccess());
        assertEquals("No cards found with given power " + validCard.getPower(),
                service.findCardsByPower(validCard.getPower()).getMessages().get(0));
    }

    @Test
    void findCardsByToughness() {
        Mockito.when(repository.findCardsByToughness(validCard.getToughness())).thenReturn(getCardsList());
        assertTrue(service.findCardsByToughness(validCard.getToughness()).isSuccess());
        assertEquals("success", service.findCardsByToughness(validCard.getToughness()).getMessages().get(0));
    }

    @Test
    void findCardsByToughnessNoneFound() {
        Mockito.when(repository.findCardsByToughness(validCard.getToughness())).thenReturn(null);
        assertFalse(service.findCardsByToughness(validCard.getToughness()).isSuccess());
        assertEquals("No cards found with given toughness " + validCard.getToughness(),
                service.findCardsByToughness(validCard.getToughness()).getMessages().get(0));
    }

    @Test
    void findCardsByExpansionCode() {
        Mockito.when(repository.findCardsByExpansionCode(validCard.getExpansion().getExpansionCode())).thenReturn(getCardsList());
        assertTrue(service.findCardsByExpansionCode(validCard.getExpansion().getExpansionCode()).isSuccess());
        assertEquals("success",
                service.findCardsByExpansionCode(validCard.getExpansion().getExpansionCode()).getMessages().get(0));
    }

    @Test
    void findCardsByExpansionCodeNoneFound() {
        Mockito.when(repository.findCardsByExpansionCode(validCard.getExpansion().getExpansionCode())).thenReturn(null);
        assertFalse(service.findCardsByExpansionCode(validCard.getExpansion().getExpansionCode()).isSuccess());
        assertEquals("No cards found with given expansion code " + validCard.getExpansion().getExpansionCode(),
                service.findCardsByExpansionCode(validCard.getExpansion().getExpansionCode()).getMessages().get(0));
    }

    @Test
    void findCardsByTextBox() {
        Mockito.when(repository.findCardsByTextBox(validCard.getTextBox())).thenReturn(getCardsList());
        assertTrue(service.findCardsByTextBox(validCard.getTextBox()).isSuccess());
        assertEquals("success", service.findCardsByTextBox(validCard.getTextBox()).getMessages().get(0));
    }

    @Test
    void findCardsByTextBoxNoneFound() {
        Mockito.when(repository.findCardsByTextBox(validCard.getTextBox())).thenReturn(null);
        assertFalse(service.findCardsByTextBox(validCard.getTextBox()).isSuccess());
        assertEquals("No cards found with given text " + validCard.getTextBox(),
                service.findCardsByTextBox(validCard.getTextBox()).getMessages().get(0));
    }

    @Test
    void findCardById() {
        Mockito.when(repository.findCardById(validCard.getCardId())).thenReturn(validCard);
        assertTrue(service.findCardById(validCard.getCardId()).isSuccess());
        assertEquals("success", service.findCardById(validCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findCardByIdNoneFound() {
        Mockito.when(repository.findCardById(validCard.getCardId())).thenReturn(null);
        assertFalse(service.findCardById(validCard.getCardId()).isSuccess());
        assertEquals("No card found with given card id " + validCard.getCardId(),
                service.findCardById(validCard.getCardId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(expansionService.findExpansionByCode(
                validCard.getExpansion().getExpansionCode())).thenReturn(getValidExpansionResult());
        Mockito.when(repository.findCardById(validCard.getCardId())).thenReturn(null);
        Mockito.when(repository.add(validCard)).thenReturn(validCard);

        assertTrue(service.add(validCard).isSuccess());
        assertEquals("success", service.add(validCard).getMessages().get(0));
    }

    @Test
    void addFailInvalidCardId() {
        Card temp = validCard;
        temp.setCardId("Z$R150");
        Result<Card> result = service.add(temp);

        assertFalse(result.isSuccess());
        assertEquals("The given card id " + temp.getCardId() + " is invalid", result.getMessages().get(0));
    }

    @Test
    void addFailInvalidCardName() {
        Card temp = validCard;
        temp.setCardName("Moraug,_F8ry_of Ak00m");
        Result<Card> result = service.add(temp);

        assertFalse(result.isSuccess());
        assertEquals("The given card name " + temp.getCardName() + " is invalid", result.getMessages().get(0));
    }

    @Test
    void addFailInvalidImagePath() {

    }

    @Test
    void addFailInvalidRarity() {

    }

    @Test
    void addFailInvalidArtistName() {

    }

    @Test
    void addFailInvalidConvertedManaCost() {

    }

    @Test
    void addFailInvalidPower() {

    }

    @Test
    void addFailInvalidToughness() {

    }

    @Test
    void addFailInvalidExpansion() {

    }

    @Test
    void addFailCardAlreadyExists() {

    }

    @Test
    void addFailedToAdd() {

    }

    @Test
    void update() {

    }

    @Test
    void update1() {

    }

    @Test
    void update2() {

    }

    @Test
    void update3() {

    }

    @Test
    void update4() {

    }

    @Test
    void update5() {

    }

    @Test
    void update6() {

    }

    @Test
    void update7() {

    }

    @Test
    void update8() {

    }

    @Test
    void update9() {

    }

    @Test
    void update10() {

    }

    @Test
    void update11() {

    }

    @Test
    void delete() {

    }

    @Test
    void delete1() {

    }

    @Test
    void delete2() {

    }

    @Test
    void delete3() {

    }
}