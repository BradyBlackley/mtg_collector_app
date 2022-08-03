package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Expansion;
import com.example.mtg.repository.mappers.ExpansionMapper;
import com.example.mtg.repository.repositoryInterfaces.ExpansionRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ExpansionJdbcRepository implements ExpansionRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExpansionJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Expansion> findAllExpansions() {
        final String sql = "select * from expansion;";
        return jdbcTemplate.query(sql, new ExpansionMapper());
    }

    @Override
    public Expansion findExpansionByName(String expansionName) {
        final String sql = "select * from expansion where expansion_name = ?;";
        return jdbcTemplate.query(sql, new ExpansionMapper(), expansionName).stream().findFirst().orElse(null);
    }

    @Override
    public Expansion add(Expansion expansion) {
        final String sql = "insert into expansion (expansion_name, expansion_code, released_date) values (?,?,?);";
        jdbcTemplate.update(sql, expansion.getExpansionName(), expansion.getExpansionCode(),
                expansion.getReleasedDate());
        return expansion;
    }

    @Override
    public boolean update(Expansion expansion) {
        final String sql = "update expansion set expansion_name = ?, expansion_code = ?, released_date =? " +
                "where expansion_id = ?";
        return jdbcTemplate.update(sql, expansion.getExpansionName(), expansion.getExpansionCode(),
                expansion.getReleasedDate(), expansion.getExpansionId()) > 0;
    }

    @Override
    public boolean delete(Expansion expansion) {
        final String sql = "delete from expansion where expansion_id = ?";
        return jdbcTemplate.update(sql, expansion.getExpansionId()) > 0;
    }
}
