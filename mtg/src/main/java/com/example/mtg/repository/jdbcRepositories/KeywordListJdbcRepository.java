package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.KeywordList;
import com.example.mtg.repository.repositoryInterfaces.KeywordListRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class KeywordListJdbcRepository implements KeywordListRepository {

    private final JdbcTemplate jdbcTemplate;

    public KeywordListJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KeywordList> findAll() {
        return null;
    }

    @Override
    public KeywordList findByKeywordListId(int keywordListId) {
        return null;
    }

    @Override
    public KeywordList add(KeywordList keywordList) {
        return null;
    }

    @Override
    public boolean update(KeywordList keywordList) {
        return false;
    }

    @Override
    public boolean delete(int keywordListId) {
        return false;
    }
}
