package com.example.mtg.repository.mappers;

import com.example.mtg.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMapper implements RowMapper<Type> {
    @Override
    public Type mapRow(ResultSet rs, int i) throws SQLException {
        Type type = new Type();
        type.setTypeId(rs.getInt("type_id"));
        type.setTypeName(rs.getString("type_name"));
        return type;
    }
}
