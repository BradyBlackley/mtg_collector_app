package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Rarity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardRepository {

    List<Card> findAllCards();

    List<Card> findCardsByName(String cardName);

    List<Card> findCardsByRarity(Rarity rarity);

    List<Card> findCardsByArtist(String artistName);

    List<Card> findCardsByConvertedManaCost(String convertedManaCost);

    List<Card> findCardsByPower(String power);

    List<Card> findCardsByToughness(String toughness);

    List<Card> findCardsByExpansionCode(String expansionId);

    List<Card> findCardsByTextBox(String text);

    Card findCardById(String cardId);

    Card add(Card card);

    boolean update(Card card);

    @Transactional
    boolean delete(String cardId);
}
