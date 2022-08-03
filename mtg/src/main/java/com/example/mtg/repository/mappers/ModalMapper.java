package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Modal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModalMapper implements RowMapper<Modal> {

    @Override
    public Modal mapRow(ResultSet rs, int i) throws SQLException {
        Modal modal = new Modal();
        Card frontCard = new Card();
        Card backCard = new Card();
        modal.setModalId(rs.getString("modal_id"));
        frontCard.setCardId(rs.getString("front_card_id"));
        backCard.setCardId(rs.getString("back_card_id"));
        modal.setfrontCard(frontCard);
        modal.setbackCard(backCard);
        return modal;
    }
}
