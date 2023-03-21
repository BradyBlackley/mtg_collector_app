package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.CardCopy;
import com.example.mtg.repository.mappers.CardCopyMapper;
import com.example.mtg.repository.repositoryInterfaces.CardCopyRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
                "from card_copy cc " +
                "inner join card c " +
                "on cc.card_id = c.card_id " +
                "inner join `user` usr " +
                "on cc.user_id = usr.user_id " +
                "where cc.user_id = ?;";
        return jdbcTemplate.query(sql, new CardCopyMapper(), userId);
    }

    @Override
    public List<CardCopy> findAllByCardId(String cardId, String userId) {
        final String sql =
                "select * " +
                "from card_copy cc " +
                "inner join card c " +
                "on cc.card_id = c.card_id " +
                "inner join `user` usr " +
                "on cc.user_id = usr.user_id " +
                "where cc.card_id = ? " +
                "and cc.user_id = ?;";
        return jdbcTemplate.query(sql, new CardCopyMapper(), cardId, userId);
    }

    @Override
    public CardCopy findByCardCopyId(int cardCopyId) {
        final String sql =
                "select * " +
                "from card_copy cc " +
                "inner join card c " +
                "on cc.card_id = c.card_id " +
                "inner join `user` usr " +
                "on cc.user_id = usr.user_id " +
                "where card_copy_id = ?;";
        return jdbcTemplate.query(sql, new CardCopyMapper(), cardCopyId).stream().findFirst().orElse(null);
    }

    @Override
    public CardCopy add(CardCopy cardCopy) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql =
                "insert into card_copy (card_id, user_id) " +
                "values (?,?);";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql);
            ps.setString(1, cardCopy.getCard().getCardId());
            ps.setString(2, cardCopy.getUser().getUserId());
            return ps;
        }, keyHolder);

        if(keyHolder.getKey() != null) {
            cardCopy.setCardCopyId(keyHolder.getKey().intValue());
        }

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
}
