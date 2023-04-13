package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Color;
import com.example.mtg.model.ColorIdentity;
import com.example.mtg.repository.mappers.ColorIdentityMapper;
import com.example.mtg.repository.repositoryInterfaces.ColorIdentityRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ColorIdentityJdbcRepository implements ColorIdentityRepository {

    private final JdbcTemplate jdbcTemplate;

    public ColorIdentityJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ColorIdentity findByCardId(String cardId) {
        final String sql =
                "select ci.color_identity_id, ci.card_id, c.color_id, c.color_name " +
                "from color_identity ci " +
                "inner join color c " +
                "on ci.color_id = c.color_id " +
                "inner join card ca " +
                "on ci.card_id = ca.card_id " +
                "inner join expansion e " +
                "on ca.expansion_id = e.expansion_id " +
                "where ci.card_id = ?;";
        return  jdbcTemplate.query(sql, new ColorIdentityMapper(), cardId);
    }

    @Override
    public ColorIdentity add(ColorIdentity colorIdentity) {
        final String sql = "insert into color_identity (card_id, color_id) values (?,?);";
        for (Color color : colorIdentity.getColors()){
            jdbcTemplate.update(sql, colorIdentity.getCard().getCardId(), color.id);
        }
        return colorIdentity;
    }

    @Override
    public boolean update(ColorIdentity colorIdentity) {
        final String sql = "update color_identity set card_id = ?, color_id = ? where card_id = ? and color_id = ?;";
        int rowsAffected = 0;
        for (Color color : colorIdentity.getColors()){
            rowsAffected += jdbcTemplate.update(sql, colorIdentity.getCard().getCardId(), color.id,
                    colorIdentity.getCard().getCardId(), color.id);
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(ColorIdentity colorIdentity) {
        final String sql = "delete from color_identity where card_id =?;";
        return jdbcTemplate.update(sql, colorIdentity.getCard().getCardId()) > 0;
    }
}
