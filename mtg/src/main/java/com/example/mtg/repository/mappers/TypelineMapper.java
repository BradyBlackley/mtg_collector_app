package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Type;
import com.example.mtg.model.Typeline;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypelineMapper implements ResultSetExtractor<Typeline> {
    @Override
    public Typeline extractData(ResultSet rs) throws SQLException, DataAccessException {
        Typeline typeline = new Typeline();
        List<Type> types = new ArrayList<Type>();

        Card card = new Card();

        while(rs.next()) {
            Type type = new Type();
            type.setTypeId(rs.getInt("type_id"));
            type.setTypeName(rs.getString("type_name"));
            types.add(type);
            card.setCardId(rs.getString("card_id"));
        }

        typeline.setTypes(types);
        typeline.setCard(card);
        return typeline;
    }
}
