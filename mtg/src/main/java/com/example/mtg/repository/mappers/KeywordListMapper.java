package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.KeywordList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KeywordListMapper implements RowMapper<KeywordList> {
    @Override
    public KeywordList mapRow(ResultSet rs, int rowNum) throws SQLException {
        KeywordList keywordList = new KeywordList();
        keywordList.setKeywordListId(rs.getInt("keyword_list_id"));
        Card card = new Card();
        card.setCardId(rs.getString("card_id"));
        keywordList.setCard(card);
        return keywordList;
    }
}
