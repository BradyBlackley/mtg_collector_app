package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Type;
import com.example.mtg.model.Typeline;
import com.example.mtg.repository.mappers.TypelineMapper;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TypelineJdbcRepository implements TypelineRepository {

    private final JdbcTemplate jdbcTemplate;

    public TypelineJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Typeline findByCardId(String cardId) {
        final String sql =
                "select * from typeline tl " +
                "inner join `type` t " +
                "on tl.type_id = t.type_id " +
                "inner join card c " +
                "on tl.card_id = c.card_id " +
                "inner join `expansion` e " +
                "on c.expansion_id = e.expansion_id " +
                "where tl.card_id = ?;";
        return jdbcTemplate.query(sql, new TypelineMapper(), cardId);
    }

    @Override
    public Typeline add(Typeline typeline) {
        final String sql =
                "insert into typeline (type_id, card_id) " +
                "values (?,?);";
        for (Type type : typeline.getTypes()) {
            jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId());
        }
        return typeline;
    }

    @Override
    public boolean update(Typeline typeline) {
        final String sql =
                "update typeline " +
                "set type_id = ?, card_id = ? " +
                "where type_id = ? and card_id = ?;";
        int rowsAffected = 0;
        for (Type type : typeline.getTypes()) {
            rowsAffected += jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId(),
                    type.getTypeId(), typeline.getCard().getCardId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(Typeline typeline) {
        final String sql =
                "delete from typeline " +
                "where type_id = ? and card_id = ?;";
        int rowsAffected = 0;
        for (Type type : typeline.getTypes()) {
            rowsAffected += jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId());
        }
        return rowsAffected > 0;
    }
}
