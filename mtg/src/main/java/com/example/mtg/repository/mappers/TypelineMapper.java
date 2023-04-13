package com.example.mtg.repository.mappers;

import com.example.mtg.model.Type;
import com.example.mtg.model.Typeline;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypelineMapper implements ResultSetExtractor<Typeline> {
    @Override
    public Typeline extractData(ResultSet rs) throws SQLException, DataAccessException {
        if(!rs.next()){
            return null;
        }
        Typeline typeline = new Typeline();
        List<Type> types = new ArrayList<>();
        typeline.setCard(new CardMapper().mapRow(rs,0));

        do {
            Type type = new Type();
            type.setTypeId(rs.getInt("type_id"));
            type.setTypeName(rs.getString("type_name"));
            types.add(type);
        }while(rs.next());

        typeline.setTypes(types);
        return typeline;
    }
}
