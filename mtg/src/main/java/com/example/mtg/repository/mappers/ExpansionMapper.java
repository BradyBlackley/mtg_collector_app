package com.example.mtg.repository.mappers;

import com.example.mtg.model.Expansion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpansionMapper implements RowMapper<Expansion> {
    @Override
    public Expansion mapRow(ResultSet rs, int i) throws SQLException {
        Expansion expansion = new Expansion();
        expansion.setExpansionId(rs.getInt("expansion_id"));
        expansion.setExpansionName(rs.getString("expansion_name"));
        expansion.setExpansionCode(rs.getString("expansion_code"));
        expansion.setReleasedDate(rs.getDate("released_date"));
        return expansion;
    }
}
