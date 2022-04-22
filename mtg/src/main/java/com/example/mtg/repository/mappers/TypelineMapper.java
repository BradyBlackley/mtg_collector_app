package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Typeline;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypelineMapper implements RowMapper<Typeline> {
    @Override
    public Typeline mapRow(ResultSet rs, int rowNum) throws SQLException {
        Typeline typeline = new Typeline();
        typeline.setTypelineId(rs.getInt("typeline_id"));
        Card card = new Card();
        card.setCardId(rs.getString("card_id"));
        typeline.setCard(card);
        return typeline;
    }
}
