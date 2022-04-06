package com.example.mtg.repository.mappers;

import com.example.mtg.model.Color;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorMapper implements RowMapper<Color> {

    @Override
    public Color mapRow(ResultSet rs, int i) throws SQLException {
        Color color = new Color();
        color.setColorId(rs.getInt("color_id"));
        color.setColorName(rs.getString("color_name"));
        return color;
    }
}
