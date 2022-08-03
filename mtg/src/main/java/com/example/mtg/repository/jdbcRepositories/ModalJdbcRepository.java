package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Modal;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.ModalMapper;
import com.example.mtg.repository.repositoryInterfaces.ModalRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class ModalJdbcRepository implements ModalRepository {

    private final JdbcTemplate jdbcTemplate;

    public ModalJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Modal findByFrontCardId(String cardId) {
        final String sql =
                "select * " +
                "from modal m " +
                "inner join card c " +
                "on m.front_card_id = c.card_id " +
                "where m.front_card_id = ?;";
        Modal modal = jdbcTemplate.query(sql, new ModalMapper(), cardId).stream().findFirst().orElse(null);
        if (modal != null) {
            addCards(modal);
        }
        return modal;
    }

    @Override
    public Modal findByBackCardId(String cardId) {
        final String sql =
                "select * " +
                "from modal m " +
                "inner join card c " +
                "on m.back_card_id = c.card_id " +
                "where m.back_card_id = ?;";
        Modal modal = jdbcTemplate.query(sql, new ModalMapper(), cardId).stream().findFirst().orElse(null);
        if (modal != null) {
            addCards(modal);
        }
        return modal;
    }

    @Override
    public Modal findByModalId(String modalId) {
        final String sql =
                "select * " +
                "from modal " +
                "where modal_id = ?;";
        Modal modal = jdbcTemplate.query(sql, new ModalMapper(), modalId).stream().findFirst().orElse(null);
        if (modal != null) {
            addCards(modal);
        }
        return modal;
    }

    @Override
    public Modal add(Modal modal) {
        final String sql =
                "insert into modal (modal_id, front_card_id, back_card_id)" +
                " values (?,?,?);";
        jdbcTemplate.update(sql, modal.getModalId(), modal.getfrontCard().getCardId(), modal.getbackCard().getCardId());
        addCards(modal);
        return modal;
    }

    @Override
    public boolean update(Modal modal) {
        final String sql =
                "update modal " +
                "set modal_id = ?, front_card_id = ?, back_card_id = ? " +
                "where modal_id = ?;";
        return jdbcTemplate.update(sql, modal.getModalId(), modal.getfrontCard().getCardId(),
                modal.getbackCard().getCardId(), modal.getModalId()) > 0;
    }

    @Override
    public boolean delete(String modalId) {
        final String sql =
                "delete from modal " +
                "where modal_id = ?;";
        return jdbcTemplate.update(sql, modalId) > 0;
    }

    private void addCards(Modal modal) {
        final String sql =
                "select * " +
                "from card " +
                "where card_id = ?;";
        modal.setfrontCard(jdbcTemplate.query(sql, new CardMapper(),
                modal.getfrontCard().getCardId()).stream().findFirst().orElse(null));
        modal.setbackCard(jdbcTemplate.query(sql, new CardMapper(),
                modal.getbackCard().getCardId()).stream().findFirst().orElse(null));
    }
}
