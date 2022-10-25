package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.CardCopy;
import com.example.mtg.repository.mappers.CardCopyMapper;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.UserMapper;
import com.example.mtg.repository.repositoryInterfaces.CardCopyRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardCopyJdbcRepository implements CardCopyRepository {

    private final JdbcTemplate jdbcTemplate;

    public CardCopyJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CardCopy> findAllByUser(String userId) {
        final String sql =
                "select * " +
                "from card_copy " +
                "where user_id = ?;";
        List<CardCopy> cardCopies = jdbcTemplate.query(sql, new CardCopyMapper(), userId);
        for (CardCopy cardCopy : cardCopies) {
            if(cardCopy != null) {
                addUser(cardCopy);
                addCard(cardCopy);
            }
        }
        return cardCopies;
    }

    @Override
    public List<CardCopy> findAllByCardId(String cardId, String userId) {
        final String sql =
                "select * " +
                "from card_copy " +
                "where card_id = ?" +
                "and user_id = ?;";
        List<CardCopy> cardCopies = jdbcTemplate.query(sql, new CardCopyMapper(), cardId, userId);
        for (CardCopy cardCopy : cardCopies) {
            if(cardCopy != null) {
                addUser(cardCopy);
                addCard(cardCopy);
            }
        }
        return cardCopies;
    }

    @Override
    public CardCopy findByCardCopyId(int cardCopyId) {
        final String sql =
                "select * " +
                "from card_copy " +
                "where card_copy_id = ?;";
        CardCopy cardCopy = jdbcTemplate.query(sql,
                new CardCopyMapper(), cardCopyId).stream().findFirst().orElse(null);
        if (cardCopy != null) {
            addUser(cardCopy);
            addCard(cardCopy);
        }
        return cardCopy;
    }

    @Override
    public CardCopy add(CardCopy cardCopy) {
        final String sql =
                "insert into card_copy (card_id, user_id) " +
                "values (?,?);";
        jdbcTemplate.update(sql, cardCopy.getCard().getCardId(), cardCopy.getUser().getUserId());
        addUser(cardCopy);
        addCard(cardCopy);
        return cardCopy;
    }

    @Override
    public boolean update(CardCopy cardCopy) {
        final String sql =
                "update card_copy " +
                "set card_id = ?, user_id = ? " +
                "where card_copy_id = ?;";
        return jdbcTemplate.update(sql, cardCopy.getCard().getCardId(), cardCopy.getUser().getUserId(),
                cardCopy.getCardCopyId()) > 0;
    }

    @Override
    public boolean delete(int cardCopyId) {
        final String sql =
                "delete from card_copy " +
                "where card_copy_id = ?;";
        return jdbcTemplate.update(sql, cardCopyId) > 0;
    }

    private void addUser(CardCopy cardCopy) {
        final String sql =
                "select * " +
                "from user " +
                "where user_id = ?;";
        cardCopy.setUser(jdbcTemplate.query(sql, new UserMapper(),
                cardCopy.getUser().getUserId()).stream().findFirst().orElse(null));
    }

    private void addCard(CardCopy cardCopy) {
        final String sql =
                "select * " +
                "from card " +
                "where card_id = ?;";
        cardCopy.setCard(jdbcTemplate.query(sql, new CardMapper(),
                cardCopy.getCard().getCardId()).stream().findFirst().orElse(null));
    }
}
