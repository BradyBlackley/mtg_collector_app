package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Keyword;
import com.example.mtg.model.KeywordList;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.KeywordListMapper;
import com.example.mtg.repository.mappers.KeywordMapper;
import com.example.mtg.repository.repositoryInterfaces.KeywordListRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class KeywordListJdbcRepository implements KeywordListRepository {

    private final JdbcTemplate jdbcTemplate;

    public KeywordListJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

    private void addCard(KeywordList keywordList) {
        String sql = "select * from card c inner join keyword_list kl on c.card_id = kl.card_id where " +
                "kl.keyword_list_id = ?;";
        keywordList.setCard(jdbcTemplate.query(sql, new CardMapper(),
                keywordList.getKeywordListId()).stream().findFirst().orElse(null));
    }

    private void addKeywords(KeywordList keywordList) {
        String sql =
                "select * from keyword k inner join keyword_list kl on k.keyword_id = kl.keyword_id where kl.card_id = ?;";
        keywordList.setKeywords(jdbcTemplate.query(sql, new KeywordMapper(),
                keywordList.getCard().getCardId()));
    }
}
