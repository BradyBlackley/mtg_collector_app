package com.example.mtg.repository;

import com.example.mtg.model.Keyword;

import java.util.List;

public class KeywordJdbcRepository implements KeywordRepository {
    @Override
    public List<Keyword> findAllKeywords() {
        return null;
    }

    @Override
    public Keyword findKeywordById(int keywordId) {
        return null;
    }

    @Override
    public Keyword findKeywordByName(String keywordName) {
        return null;
    }

    @Override
    public Keyword add(Keyword keyword) {
        return null;
    }

    @Override
    public boolean update(Keyword keyword) {
        return false;
    }

    @Override
    public boolean deleteByName(String keywordName) {
        return false;
    }
}
