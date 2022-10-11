package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.KeywordList;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KeywordListRepository {

    KeywordList findByCardId(String cardId);

    KeywordList add(KeywordList keywordList);

    boolean update(KeywordList kewordList);

    @Transactional
    boolean delete(KeywordList keywordList);
}
