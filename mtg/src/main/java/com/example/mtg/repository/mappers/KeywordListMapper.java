package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Keyword;
import com.example.mtg.model.KeywordList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KeywordListMapper implements ResultSetExtractor<KeywordList> {
    @Override
    public KeywordList extractData(ResultSet rs) throws SQLException, DataAccessException {
        if(!rs.next()){
            return null;
        }
        KeywordList keywordList = new KeywordList();
        List<Keyword> keywords = new ArrayList<>();
        keywordList.setCard(new CardMapper().mapRow(rs,0));
        do {
            Keyword keyword = new Keyword();
            keyword.setKeywordId(rs.getInt("keyword_id"));
            keyword.setKeywordName(rs.getString("keyword_name"));
            keywords.add(keyword);
        } while(rs.next());
        keywordList.setKeywords(keywords);
        return keywordList;
    }
}
