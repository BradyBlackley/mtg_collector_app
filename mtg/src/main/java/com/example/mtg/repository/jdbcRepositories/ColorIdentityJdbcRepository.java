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
    public List<ColorIdentity> findAll() {
        final String sql = "select * from color_identity;";
        List<ColorIdentity> colorIdentities = jdbcTemplate.query(sql, new ColorIdentityMapper());
        for (ColorIdentity colorIdentity : colorIdentities) {
            addCard(colorIdentity);
            addColors(colorIdentity);
        }
        return colorIdentities;
    }

    @Override
    public ColorIdentity findByColorIdentityId(int colorIdentityId) {
        final String sql = "select * from color_identity where color_identity_id = ?;";
        ColorIdentity colorIdentity = jdbcTemplate.query(sql, new ColorIdentityMapper(),
                colorIdentityId).stream().findFirst().orElse(null);
        if(colorIdentity != null) {
            addCard(colorIdentity);
            addColors(colorIdentity);
        }
        return  colorIdentity;
    }

    @Override
    public ColorIdentity add(ColorIdentity colorIdentity) {
        final String sql = "insert into color_identity (card_id, color_id) values (card_id = ?, color_id = ?)" +
                " where color_identity_id = ?;";
        int rowsAffected = 0;
        for (Color color : colorIdentity.getColors()){
            rowsAffected += jdbcTemplate.update(sql, colorIdentity.getCard().getCardId(), color.getColorId());
        }
        if (rowsAffected <= 0) {
            return null;
        }
        return colorIdentity;
    }

    @Override
    public boolean update(ColorIdentity colorIdentity) {
        final String sql = "update color_identity set card_id = ?, color_id = ? where color_identity_id = ?;";
        int rowsAffected = 0;
        for (Color color : colorIdentity.getColors()){
            rowsAffected += jdbcTemplate.update(sql, colorIdentity.getCard().getCardId(), color.getColorId(),
                    colorIdentity.getColorIdentityId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(int colorIdentityId) {
        final String sql = "delete from color_identity where color_identity_id = ?;";
        return jdbcTemplate.update(sql, colorIdentityId) > 0;
    }

    private void addCard(ColorIdentity colorIdentity) {
        final String sql = "select * from card where card_id = ?;";
        colorIdentity.setCard(jdbcTemplate.query(sql, new CardMapper(),
                colorIdentity.getCard().getCardId()).stream().findFirst().orElse(null));
    }

    private void addColors(ColorIdentity colorIdentity) {
        final String sql = "select * from color_identity ci inner join color c on ci.color_id =" +
                " c.color_id where ci.card_id = ?;";
        List<Color> colors = jdbcTemplate.query(sql, new ColorMapper(), colorIdentity.getCard().getCardId());
    }
}
