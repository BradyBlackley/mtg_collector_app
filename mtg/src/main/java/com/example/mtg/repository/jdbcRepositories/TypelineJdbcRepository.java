package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Type;
import com.example.mtg.model.Typeline;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.TypelineMapper;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class TypelineJdbcRepository implements TypelineRepository {

    private final JdbcTemplate jdbcTemplate;

    public TypelineJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Typeline findByCardId(String cardId) {
        final String sql =
                "select tl.typeline_id, t.type_id, tl.card_id, t.type_name " +
                "from typeline tl " +
                "inner join `type` t " +
                "on tl.type_id = t.type_id " +
                "where card_id = ?;";
        Typeline typeline = jdbcTemplate.query(sql,
                new TypelineMapper(), cardId);
        if(typeline != null) {
            addCard(typeline);
        }
        return typeline;
    }

    @Override
    public Typeline add(Typeline typeline) {
        final String sql = "insert into typeline (type_id, card_id) values (?,?);";
        for (Type type : typeline.getTypes()) {
            jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId());
        }
        return typeline;
    }

    @Override
    public boolean update(Typeline typeline) {
        final String sql = "update typeline set type_id = ?, card_id = ? where type_id = ? and card_id = ?;";
        int rowsAffected = 0;
        for (Type type : typeline.getTypes()) {
            rowsAffected += jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId(),
                    type.getTypeId(), typeline.getCard().getCardId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(int typeId, String cardId) {
        final String sql = "delete from typeline where type_id = ? and card_id = ?;";
        return jdbcTemplate.update(sql, typeId, cardId) > 0;
    }

    private void addCard(Typeline typeline) {
        final String sql = 
                "select * " +
                "from card c " +
                "where c.card_id = ?;";
        typeline.setCard(jdbcTemplate.query(sql, new CardMapper(),
                typeline.getCard().getCardId()).stream().findFirst().orElse(null));

    }

}
