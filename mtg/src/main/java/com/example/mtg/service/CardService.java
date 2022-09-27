package com.example.mtg.service;

import com.example.mtg.model.Card;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.jdbcRepositories.CardJdbcRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardJdbcRepository repository;

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

    //TODO: Second half
    public Result<Card> add() {

        return null;
    }

    public Result<Boolean> update() {

        return null;
    }

    public Result<Boolean> delete() {

        return null;
    }

}
