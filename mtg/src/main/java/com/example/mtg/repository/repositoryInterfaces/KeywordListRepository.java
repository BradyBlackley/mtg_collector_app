package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.KeywordList;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KeywordListRepository {

    List<KeywordList> findAll();

    KeywordList findByCardId(String cardId);

    KeywordList findByKeywordListId(int keywordListId);

    KeywordList add(KeywordList keywordList);

    boolean update(KeywordList keywordList);

    @Transactional
    boolean delete(int keywordListId);
}
