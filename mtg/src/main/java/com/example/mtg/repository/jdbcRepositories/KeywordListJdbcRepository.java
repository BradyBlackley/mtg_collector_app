package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Keyword;
import com.example.mtg.model.KeywordList;
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
                "select * " +
                "from keyword_list kl " +
                "inner join keyword k " +
                "on kl.keyword_id = k.keyword_id " +
                "inner join card c " +
                "on c.card_id = kl.card_id " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where kl.card_id = ?;";
        return jdbcTemplate.query(sql, new KeywordListMapper(), cardId);
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
}
