package com.example.mtg.repository.mappers;

import com.example.mtg.model.CardCopy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardCopyMapper implements RowMapper<CardCopy> {
    @Override
    public CardCopy mapRow(ResultSet rs, int i) throws SQLException {
        CardCopy cardCopy = new CardCopy();
        cardCopy.setCardCopyId(rs.getInt("card_copy_id"));
        cardCopy.setCard(new CardMapper().mapRow(rs,i));
        cardCopy.setUserId(rs.getString("user_id"));
        return cardCopy;
    }
}
