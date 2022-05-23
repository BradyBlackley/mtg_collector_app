package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Keyword;
import com.example.mtg.model.KeywordList;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.KeywordListMapper;
import com.example.mtg.repository.mappers.KeywordMapper;
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
        String sql = "select * from keyword_list;";
        List<KeywordList> keywordLists = jdbcTemplate.query(sql, new KeywordListMapper());
        for (KeywordList keywordList : keywordLists) {
            addCard(keywordList);
            addKeywords(keywordList);
        }
        return keywordLists;
    }

    @Override
    public KeywordList findByCardId(String cardId) {
        String sql = "select * from keyword_list where card_id = ?;";
        KeywordList keywordList = jdbcTemplate.query(sql, new KeywordListMapper(),
                cardId).stream().findFirst().orElse(null);
        if(keywordList != null) {
            addCard(keywordList);
            addKeywords(keywordList);
        }
        return keywordList;
    }

    @Override
    public KeywordList findByKeywordListId(int keywordListId) {
        String sql = "select * from keyword_list where keyword_list_id = ?;";
        KeywordList keywordList = jdbcTemplate.query(sql, new KeywordListMapper(),
                keywordListId).stream().findFirst().orElse(null);
        if(keywordList != null) {
            addCard(keywordList);
            addKeywords(keywordList);
        }
        return keywordList;
    }

    @Override
    public KeywordList add(KeywordList keywordList) {
        String sql = "insert into keyword_list (keyword_id, card_id) values (?,?);";
        int rowsAffected = 0;
        for(Keyword keyword : keywordList.getKeywords()){
            rowsAffected += jdbcTemplate.update(sql, keyword.getKeywordId(), keywordList.getCard().getCardId());
        }
        if (rowsAffected <= 0) {
            return null;
        }
        return keywordList;
    }

    @Override
    public boolean update(KeywordList keywordList) {
        String sql = "update keyword_list set keyword_id = ?, card_id = ? where keyword_list_id = ?;";
        int rowsAffected = 0;
        for(Keyword keyword : keywordList.getKeywords()) {
            rowsAffected += jdbcTemplate.update(sql, keyword.getKeywordId(), keywordList.getCard().getCardId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(int keywordListId) {
        String sql = "delete from keyword_list where keyword_list_id = ?;";
        return jdbcTemplate.update(sql, keywordListId) > 0;
    }

    private void addCard(KeywordList keywordList) {
        String sql = "select * from card c inner join keyword_list kl on c.card_id = kl.card_id where " +
                "kl.keyword_list_id = ?;";
        keywordList.setCard(jdbcTemplate.query(sql, new CardMapper(),
                keywordList.getKeywordListId()).stream().findFirst().orElse(null));
    }

    private void addKeywords(KeywordList keywordList) {
        String sql = "select * from keyword_list where card_id = ?;";
        keywordList.setKeywords(jdbcTemplate.query(sql, new KeywordMapper(),
                keywordList.getCard().getCardId()));
    }
}
