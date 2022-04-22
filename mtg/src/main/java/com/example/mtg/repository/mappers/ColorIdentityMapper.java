package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Color;
import com.example.mtg.model.ColorIdentity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ColorIdentityMapper implements RowMapper<ColorIdentity> {
    @Override
    public ColorIdentity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ColorIdentity colorIdentity = new ColorIdentity();
        colorIdentity.setColorIdentityId(rs.getInt("color_identity_id"));
        Card card = new Card();
        card.setCardId(rs.getString("card_id"));
        colorIdentity.setCard(card);
        return colorIdentity;
    }
}
