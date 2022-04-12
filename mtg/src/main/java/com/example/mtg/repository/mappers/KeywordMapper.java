package com.example.mtg.repository.mappers;

import com.example.mtg.model.Keyword;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KeywordMapper implements RowMapper<Keyword> {

    @Override
    public Keyword mapRow(ResultSet rs, int i) throws SQLException {
        Keyword keyword = new Keyword();
        keyword.setKeywordId(rs.getInt("keyword_id"));
        keyword.setKeywordName(rs.getString("keyword_name"));
        return keyword;
    }
}
