package com.example.mtg.service;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.repositoryInterfaces.CardRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CardService {
    @Autowired
    private CardRepository repository;
    @Autowired
    private ExpansionService expansionService;

    public Result<List<Card>> findAllCards() {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findAllCards());
        if(result.getPayload() == null) {
            result.addMessage("No cards found", ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByName(String cardName) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByName(cardName));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given name " + cardName, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByRarity(Rarity rarity) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByRarity(rarity));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given rarity " + rarity.label, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByArtist(String artistName) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByArtist(artistName));
        if(result.getPayload() == null) {
            result.addMessage("No cards found by given artist name " + artistName, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByConvertedManaCost(String convertedManaCost) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByConvertedManaCost(convertedManaCost));
        if(result.getPayload() == null) {
            result.addMessage("No cards found with given converted mana cost " + convertedManaCost, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByPower(String power) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByPower(power));
        if(result.getPayload() == null) {
            result.addMessage("No cards found with given power " + power, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByToughness(String toughness) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByToughness(toughness));
        if(result.getPayload() == null) {
            result.addMessage("No cards found with given toughness " + toughness, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByExpansionCode(String expansionCode) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByExpansionCode(expansionCode));
        if(result.getPayload() == null) {
            result.addMessage("No cards found with given expansion code " + expansionCode, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<List<Card>> findCardsByTextBox(String text) {
        Result<List<Card>> result = new Result<>();
        result.setPayload(repository.findCardsByTextBox(text));
        if(result.getPayload() == null) {
            result.addMessage("No cards found with given text " + text, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Card> findCardById(String cardId) {
        Result<Card> result = new Result<>();
        result.setPayload(repository.findCardById(cardId));
        if(result.getPayload() == null) {
            result.addMessage("No card found with given card id " + cardId, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }
        return result;
    }

    public Result<Card> add(Card card) {
        Result<Card> result = new Result<>();
        Result<Expansion> expansionResult =
                expansionService.findExpansionByCode(card.getExpansion().getExpansionCode());

        if(!validateCardId(card.getCardId())) {
            result.addMessage("The given card id " + card.getCardId() + " is invalid", ResultType.INVALID);
        } else if (!validateCardName(card.getCardName())) {
            result.addMessage("The given card name " + card.getCardName() + " is invalid", ResultType.INVALID);
        } else if (!validateCardImagePath(card.getImagePath())) {
            result.addMessage("The given card image path " + card.getImagePath() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardArtistName(card.getArtistName())) {
            result.addMessage("The given card artist name " + card.getArtistName() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardConvertedManaCost(card.getConvertedManaCost())) {
            result.addMessage("The given card converted mana cost " + card.getConvertedManaCost() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardPower(card.getPower())) {
            result.addMessage("The given card power " + card.getPower() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardToughness(card.getToughness())) {
            result.addMessage("The given card toughness " + card.getToughness() + " is invalid",
                    ResultType.INVALID);
        } else if (expansionResult.getPayload() == null || !expansionResult.isSuccess()) {
            result.addMessage(expansionResult.getMessages().get(0), expansionResult.getType());
            result.addMessage("The given expansion " + card.getExpansion() + " associated with card "
                    + card + " is invalid", ResultType.INVALID);
        } else if (repository.findCardById(card.getCardId()) != null) {
            result.addMessage("The given card " + card + " already exists",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.add(card));
            if(result.getPayload() == null) {
                result.addMessage("Failed to add given card " + card, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            }
        }
        return result;
    }

    public Result<Boolean> update(Card card) {
        Result<Boolean> result = new Result<>();
        result.setPayload(false);
        Result<Expansion> expansionResult =
                expansionService.findExpansionByCode(card.getExpansion().getExpansionCode());

        if(!validateCardId(card.getCardId())) {
            result.addMessage("The given card id " + card.getCardId() + " is invalid", ResultType.INVALID);
        } else if (!validateCardName(card.getCardName())) {
            result.addMessage("The given card name " + card.getCardName() + " is invalid", ResultType.INVALID);
        } else if (!validateCardImagePath(card.getImagePath())) {
            result.addMessage("The given card image path " + card.getImagePath() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardArtistName(card.getArtistName())) {
            result.addMessage("The given card artist name " + card.getArtistName() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardConvertedManaCost(card.getConvertedManaCost())) {
            result.addMessage("The given card converted mana cost " + card.getConvertedManaCost() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardPower(card.getPower())) {
            result.addMessage("The given card power " + card.getPower() + " is invalid",
                    ResultType.INVALID);
        } else if (!validateCardToughness(card.getToughness())) {
            result.addMessage("The given card toughness " + card.getToughness() + " is invalid",
                    ResultType.INVALID);
        } else if (expansionResult.getPayload() == null || !expansionResult.isSuccess()) {
            result.addMessage(expansionResult.getMessages().get(0), expansionResult.getType());
            result.addMessage("The given expansion " + card.getExpansion() + " associated with card "
                    + card + " is invalid", ResultType.INVALID);
        } else if (repository.findCardById(card.getCardId()) == null) {
            result.addMessage("The given card " + card + " is not found",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.update(card));
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
            result.setPayload(true);

        }
        return result;
    }

    public Result<Boolean> delete(Card card) {
        Result<Boolean> result = new Result<>();

        if(!validateCardId(card.getCardId())) {
            result.addMessage("The given card id " + card.getCardId() + " is invalid", ResultType.INVALID);
        } else if (repository.findCardById(card.getCardId()) == null) {
            result.addMessage("The given card " + card + " is not found",
                    ResultType.INVALID);
        } else {
            result.setPayload(repository.delete(card.getCardId()));
            if(!result.getPayload()) {
                result.addMessage("Failed to delete given card " + card, ResultType.ERROR);
            } else {
                result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
                result.setPayload(true);
            }
        }
        return result;
    }

    public boolean validateCard(Card card) {
        return validateCardId(card.getCardId())
                && validateCardName(card.getCardName())
                && validateCardImagePath(card.getImagePath())
                && validateCardArtistName(card.getArtistName())
                && validateCardConvertedManaCost(card.getConvertedManaCost())
                && validateCardPower(card.getPower())
                && validateCardToughness(card.getToughness());
    }

    private boolean validateCardId(String cardId) {
        Pattern pattern = Pattern.compile("^[A-Z\\d]{3}\\d{3}$");
        Matcher matcher = pattern.matcher(cardId);
        return matcher.matches();
    }

    private boolean validateCardName(String cardName) {
        Pattern pattern = Pattern.compile("^[a-zA-Z:,\\d\\s]*$");
        Matcher matcher = pattern.matcher(cardName);
        return matcher.matches();
    }

    private boolean validateCardImagePath(String imagePath) {
        Pattern pattern = Pattern.compile("^card_images\\\\[a-z-_]*\\\\[a-z\\d-_]*\\.jpg$");
        Matcher matcher = pattern.matcher(imagePath);
        return matcher.matches();
    }

    private boolean validateCardArtistName(String artistName) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher matcher = pattern.matcher(artistName);
        return matcher.matches();
    }

    private boolean validateCardConvertedManaCost(String convertedManaCost) {
        Pattern pattern = Pattern.compile("^[0-9X]*$");
        Matcher matcher = pattern.matcher(convertedManaCost);
        return matcher.matches();
    }

    private boolean validateCardPower(String power) {
        Pattern pattern = Pattern.compile("^[0-9X]*$");
        Matcher matcher = pattern.matcher(power);
        return matcher.matches();
    }

    private boolean validateCardToughness(String toughness) {
        Pattern pattern = Pattern.compile("^[0-9X]*$");
        Matcher matcher = pattern.matcher(toughness);
        return matcher.matches();
    }

}
