package com.example.mtg.repository.mappers;

import com.example.mtg.model.Modal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModalMapper implements RowMapper<Modal> {

    @Override
    public Modal mapRow(ResultSet rs, int i) throws SQLException {
        Modal modal = new Modal();
        modal.setModalId(rs.getString("modal_id"));
        modal.setfrontCard(new CardMapper().mapRow(rs,0));
        modal.setbackCard(new CardMapper().mapRow(rs,0));
        return modal;
    }
}
