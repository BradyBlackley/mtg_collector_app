package com.example.mtg.repository.mappers;


import com.example.mtg.model.Card;
import com.example.mtg.model.CardCopy;
import com.example.mtg.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardCopyMapper implements RowMapper<CardCopy> {
    @Override
    public CardCopy mapRow(ResultSet rs, int i) throws SQLException {
        CardCopy cardCopy = new CardCopy();
        cardCopy.setCardCopyId(rs.getInt("card_copy_id"));
        Card card = new CardMapper().mapRow(rs,i);
        cardCopy.setCard(card);
        User user = new UserMapper().mapRow(rs,i);
        cardCopy.setUser(user);
        return cardCopy;
    }
}
