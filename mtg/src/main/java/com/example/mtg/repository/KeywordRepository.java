package com.example.mtg.repository;

import com.example.mtg.model.Keyword;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KeywordRepository {
    List<Keyword> findAllKeywords();

    Keyword findKeywordById(int keywordId);

    Keyword findKeywordByName(String keywordName);

    Keyword add(Keyword keyword);

    boolean update(Keyword keyword);

    @Transactional
    boolean deleteByName(String keywordName);
}
