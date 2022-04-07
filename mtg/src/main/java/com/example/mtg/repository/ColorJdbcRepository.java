package com.example.mtg.repository;

import com.example.mtg.model.Color;
import com.example.mtg.repository.mappers.ColorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ColorJdbcRepository implements ColorRepository{

    private final JdbcTemplate jdbcTemplate;

    public ColorJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Color> findAllColors() {
        final String sql = "select color_id, color_name from color;";
        return jdbcTemplate.query(sql, new ColorMapper());
    }

    @Override
    public Color findColorById(int colorId) {
        final String sql = "select color_id, color_name from color where color_id = ?;";
        return jdbcTemplate.query(sql, new ColorMapper(), colorId).stream().findFirst().orElse(null);
    }

    @Override
    public Color findColorByName(String colorName) {
        final String sql = "select color_id, color_name from color where color_name = ?;";
        return jdbcTemplate.query(sql, new ColorMapper(), colorName).stream().findFirst().orElse(null);
    }

    @Override
    public Color add(Color color) {
        final String sql = "insert into color (color_name) values (?);";
        int rowsAffected = jdbcTemplate.update(sql, color.getColorName());
        if(rowsAffected <= 0) {
            return null;
        }
        return color;
    }

    @Override
    public boolean update(Color color) {
        final String sql = "update color set color_name = ? where color_id = ?;";
        return jdbcTemplate.update(sql, color.getColorName(), color.getColorId()) > 0;
    }

    @Override
    public boolean deleteByName(String colorName) {
        final String sql = "delete from color where color_name = ?;";
        return jdbcTemplate.update(sql, colorName) > 0;
    }
}
