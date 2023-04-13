package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Card;
import com.example.mtg.model.Rarity;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.repositoryInterfaces.CardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardJdbcRepository implements CardRepository {

    private final JdbcTemplate jdbcTemplate;

    public CardJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> findAllCards() {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id;";
        return jdbcTemplate.query(sql, new CardMapper());
    }

    @Override
    public List<Card> findCardsByName(String cardName) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where card_name like ?;";
        return jdbcTemplate.query(sql, new CardMapper(), "%" + cardName + "%");
    }

    @Override
    public List<Card> findCardsByRarity(Rarity rarity) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where rarity = ?;";
        return jdbcTemplate.query(sql, new CardMapper(), rarity.label);
    }

    @Override
    public List<Card> findCardsByArtist(String artistName) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where artist_name = ?;";
        return jdbcTemplate.query(sql, new CardMapper(), artistName);
    }

    @Override
    public List<Card> findCardsByConvertedManaCost(String convertedManaCost) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where converted_mana_cost = ?;";
        return jdbcTemplate.query(sql, new CardMapper(), convertedManaCost);
    }

    @Override
    public List<Card> findCardsByPower(String power) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where power = ?;";
        return jdbcTemplate.query(sql, new CardMapper(), power);
    }

    @Override
    public List<Card> findCardsByToughness(String toughness) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where toughness = ?;";
        return jdbcTemplate.query(sql, new CardMapper(), toughness);
    }

    @Override
    public List<Card> findCardsByExpansionCode(String expansionCode) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where e.expansion_code =?;";
        return jdbcTemplate.query(sql, new CardMapper(), expansionCode);
    }

    @Override
    public List<Card> findCardsByTextBox(String text) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where text_box like ?;";
        return jdbcTemplate.query(sql, new CardMapper(), "%" + text + "%");
    }

    @Override
    public Card findCardById(String cardId) {
        final String sql =
                "select * " +
                "from card c " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where card_id = ?;";
        return jdbcTemplate.query(sql, new CardMapper(), cardId).stream().findFirst().orElse(null);
    }

    @Override
    public Card add(Card card) {
        final String sql =
                "insert into card " +
                "(card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness, " +
                "expansion_id, text_box) " +
                "values (?,?,?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, card.getCardId(), card.getCardName(), card.getImagePath(), card.getRarity().name(),
                card.getArtistName(), card.getConvertedManaCost(), card.getPower(), card.getToughness(),
                card.getExpansion().getExpansionId(), card.getTextBox());
        return card;
    }

    @Override
    public boolean update(Card card) {
        final String sql =
                "update card " +
                "set card_id = ?, card_name = ?, image_path = ?, rarity = ?, artist_name = ?, converted_mana_cost = ?, " +
                "power = ?, toughness = ?, expansion_id = ?, text_box = ? " +
                "where card_id = ?;";
        return jdbcTemplate.update(sql, card.getCardId(), card.getCardName(), card.getImagePath(), card.getRarity().name(),
                card.getArtistName(), card.getConvertedManaCost(), card.getPower(), card.getToughness(),
                card.getExpansion().getExpansionId(), card.getTextBox(), card.getCardId()) > 0;
    }

    @Override
    public boolean delete(String cardId) {
        final String sql =
                "delete from card " +
                "where card_id = ?;";
        return jdbcTemplate.update(sql, cardId) > 0;
    }
}
