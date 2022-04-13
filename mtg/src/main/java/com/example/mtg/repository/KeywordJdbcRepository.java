package com.example.mtg.repository;

import com.example.mtg.model.Keyword;
import com.example.mtg.repository.mappers.KeywordMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class KeywordJdbcRepository implements KeywordRepository {

    private final JdbcTemplate jdbcTemplate;

    public KeywordJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Keyword> findAllKeywords() {
        final String sql = "select * from keyword;";
        return jdbcTemplate.query(sql, new KeywordMapper());
    }

    @Override
    public Keyword findKeywordById(int keywordId) {
        final String sql = "select * from keyword where keyword_id = ?;";
        return jdbcTemplate.query(sql, new KeywordMapper(), keywordId).stream().findFirst().orElse(null);
    }

    @Override
    public Keyword findKeywordByName(String keywordName) {
        final String sql = "select * from keyword where keyword_name = ?;";
        return jdbcTemplate.query(sql, new KeywordMapper(), keywordName).stream().findFirst().orElse(null);
    }

    @Override
    public Keyword add(Keyword keyword) {
        final String sql = "insert into keyword (keyword_name) values (?);";
        int rowsAffected = jdbcTemplate.update(sql, keyword.getKeywordName());
        if(rowsAffected <= 0) {
            return null;
        }
        return keyword;
    }

    @Override
    public boolean update(Keyword keyword) {
        final String sql = "update keyword set keyword_name = ? where keyword_id = ?;";
        return jdbcTemplate.update(sql, keyword.getKeywordName()) > 0;
    }

    @Override
    public boolean deleteByName(Keyword keyword) {
        final String sql = "delete from keyword where keyword_name = ?;";
        return jdbcTemplate.update(sql, keyword.getKeywordName()) > 0;
    }
}
