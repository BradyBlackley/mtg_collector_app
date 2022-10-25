package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Keyword;
import com.example.mtg.model.KeywordList;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.KeywordListMapper;
import com.example.mtg.repository.repositoryInterfaces.KeywordListRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KeywordListJdbcRepository implements KeywordListRepository {

    private final JdbcTemplate jdbcTemplate;

    public KeywordListJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public KeywordList findByCardId(String cardId) {
        String sql = 
                "select kl.keyword_list_id, k.keyword_id, kl.card_id, k.keyword_name " +
                "from keyword_list kl " +
                "inner join keyword k " +
                "on kl.keyword_id = k.keyword_id " +
                "where card_id = ?;";
        KeywordList keywordList = jdbcTemplate.query(sql, new KeywordListMapper(),
                cardId);
        if(keywordList != null) {
            addCard(keywordList);
        }
        return keywordList;
    }

    @Override
    public KeywordList add(KeywordList keywordList) {
        String sql =
                "insert into keyword_list (keyword_id, card_id)" +
                " values (?,?);";
        for(Keyword keyword : keywordList.getKeywords()){
            jdbcTemplate.update(sql, keyword.getKeywordId(), keywordList.getCard().getCardId());
        }
        return keywordList;
    }

    @Override
    public boolean update(KeywordList keywordList) {
        String sql = "update keyword_list set keyword_id = ?, card_id = ? where keyword_id = ? and card_id = ?;";
        int rowsAffected = 0;
        for(Keyword keyword : keywordList.getKeywords()){
            rowsAffected += jdbcTemplate.update(sql, keyword.getKeywordId(), keywordList.getCard().getCardId(),
                    keyword.getKeywordId(), keywordList.getCard().getCardId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(KeywordList keywordList) {
        String sql = "delete from keyword_list where keyword_id = ? and card_id = ?;";
        int rowsAffected = 0;
        rowsAffected += jdbcTemplate.update(sql, keywordList.getKeywords().get(0).getKeywordId(), keywordList.getCard().getCardId());
        return rowsAffected > 0;
    }

    private void addCard(KeywordList keywordList) {
        String sql =
                "select * " +
                "from card c" +
                " where card_id = ?;";
        keywordList.setCard(jdbcTemplate.query(sql, new CardMapper(),
                keywordList.getCard().getCardId()).stream().findFirst().orElse(null));
    }
}
