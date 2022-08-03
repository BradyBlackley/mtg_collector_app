package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Color;
import com.example.mtg.model.ColorIdentity;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.ColorIdentityMapper;
import com.example.mtg.repository.mappers.ColorMapper;
import com.example.mtg.repository.repositoryInterfaces.ColorIdentityRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ColorIdentityJdbcRepository implements ColorIdentityRepository {

    private final JdbcTemplate jdbcTemplate;

    public ColorIdentityJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ColorIdentity findByCardId(String cardId) {
        final String sql = "select ci.color_identity_id, ci.card_id, c.color_id, c.color_name " +
                "from color_identity ci " +
                "inner join color c " +
                "on ci.color_id = c.color_id " +
                "where card_id = ?;";
        ColorIdentity colorIdentity = jdbcTemplate.query(sql, new ColorIdentityMapper(),
                cardId);
        if(colorIdentity != null) {
            addCard(colorIdentity);
        }
        return  colorIdentity;
    }

    @Override
    public ColorIdentity add(ColorIdentity colorIdentity) {
        final String sql = "insert into color_identity (card_id, color_id) values (?,?);";
        for (Color color : colorIdentity.getColors()){
            jdbcTemplate.update(sql, colorIdentity.getCard().getCardId(), color.getColorId());
        }
        return colorIdentity;
    }

    @Override
    public boolean update(ColorIdentity colorIdentity, String newCardId, int newColorId) {
        final String sql = "update color_identity set card_id = ?, color_id = ? where card_id = ? and color_id = ?;";
        int rowsAffected = 0;
        for (Color color : colorIdentity.getColors()){
            rowsAffected += jdbcTemplate.update(sql, newCardId, newColorId,
                    colorIdentity.getCard().getCardId(), color.getColorId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(ColorIdentity colorIdentity) {
        final String sql = "delete from color_identity where card_id =?;";
        return jdbcTemplate.update(sql, colorIdentity.getCard().getCardId()) > 0;
    }

    private void addCard(ColorIdentity colorIdentity) {
        final String sql = "select * from card where card_id = ?;";
        colorIdentity.setCard(jdbcTemplate.query(sql, new CardMapper(),
                colorIdentity.getCard().getCardId()).stream().findFirst().orElse(null));
    }
}
