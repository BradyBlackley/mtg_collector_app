package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Expansion;
import com.example.mtg.model.Rarity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Card> {
    @Override
    public Card mapRow(ResultSet rs, int i) throws SQLException {
        Card card = new Card();
        card.setCardId(rs.getString("card_id"));
        card.setCardName(rs.getString("card_name"));
        card.setImagePath(rs.getString("image_path"));
        card.setRarity(Rarity.valueOf(rs.getString("rarity")));
        card.setArtistName(rs.getString("artist_name"));
        card.setConvertedManaCost(rs.getString("converted_mana_cost"));
        card.setPower(rs.getString("power"));
        card.setToughness(rs.getString("toughness"));
        Expansion expansion = new Expansion();
        expansion.setExpansionId(rs.getInt("expansion_id"));
        card.setExpansion(expansion);
        card.setTextBox(rs.getString("text_box"));
        return card;
    }
}
