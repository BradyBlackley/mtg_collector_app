package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.ExpansionMapper;
import com.example.mtg.repository.repositoryInterfaces.CardRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CardJdbcRepository implements CardRepository {

    private final JdbcTemplate jdbcTemplate;

    public CardJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> findAllCards() {
        final String sql = "select * from card;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper());
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByName(String cardName) {
        final String sql = "select * from card where card_name = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), cardName);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByRarity(Rarity rarity) {
        final String sql = "select * from card where rarity = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), rarity.label);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByArtist(String artistName) {
        final String sql = "select * from card where artist_name = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), artistName);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByConvertedManaCost(String convertedManaCost) {
        final String sql = "select * from card where converted_mana_cost = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), convertedManaCost);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByPower(String power) {
        final String sql = "select * from card where power = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), power);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByToughness(String toughness) {
        final String sql = "select * from card where toughness = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), toughness);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByExpansion(Expansion expansion) {
        final String sql = "select * from card where expansion = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), expansion.getExpansionId());
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByTextBox(String text) {
        final String sql = "select * from card where text_box = ?;";
        List<Card> cards = jdbcTemplate.query(sql, new CardMapper(), text);
        for(Card card : cards) {
            if(card != null){
                addExpansion(card);
            }
        }
        return cards;
    }

    @Override
    public Card findCardById(String cardId) {
        final String sql = "select * from card where card_id = ?;";
        Card card = jdbcTemplate.query(sql, new CardMapper(), cardId).stream().findFirst().orElse(null);
        if(card != null){
            addExpansion(card);
        }
        return card;
    }

    @Override
    public Card add(Card card) {
        final String sql = "insert into card (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, " +
                "power, toughness, expansion_id, text_box) values (?,?,?,?,?,?,?,?,?,?);";
        int rowsAffected = jdbcTemplate.update(sql, card.getCardId(), card.getCardName(), card.getImagePath(),
                card.getRarity(), card.getArtistName(), card.getConvertedManaCost(), card.getPower(),
                card.getToughness(), card.getExpansion().getExpansionId(), card.getTextBox());
        if(rowsAffected <= 0) {
            return null;
        }
        addExpansion(card);
        return card;
    }

    @Override
    public boolean update(Card card) {
        final String sql = "update card set card_id = ?, card_name = ?, image_path = ?, rarity = ?, artist_name = ?, " +
                "converted_mana_cost = ?, power = ?, toughness = ?, expansion_id = ?, text_box = ? where card_id = ?;";
        return jdbcTemplate.update(sql, card.getCardId(), card.getCardName(), card.getImagePath(), card.getRarity(),
                card.getArtistName(), card.getConvertedManaCost(), card.getPower(), card.getToughness(),
                card.getExpansion().getExpansionId(), card.getTextBox()) > 0;
    }

    @Override
    public boolean delete(Card card) {
        final String sql = "delete from card where card_id = ?;";
        return jdbcTemplate.update(sql, card.getCardId()) > 0;
    }

    private void addExpansion(Card card) {
        final String sql = "select * from expansion where expansion_id = ?;";
        card.setExpansion(jdbcTemplate.query(sql, new ExpansionMapper(),
                card.getExpansion().getExpansionId()).stream().findFirst().orElse(null));
    }
}
