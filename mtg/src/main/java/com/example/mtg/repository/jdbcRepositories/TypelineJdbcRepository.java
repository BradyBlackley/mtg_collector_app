package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Type;
import com.example.mtg.model.Typeline;
import com.example.mtg.repository.mappers.CardMapper;
import com.example.mtg.repository.mappers.TypeMapper;
import com.example.mtg.repository.mappers.TypelineMapper;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TypelineJdbcRepository implements TypelineRepository {

    private final JdbcTemplate jdbcTemplate;

    public TypelineJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Typeline> findAll() {
        final String sql = "select * from typeline;";
        List<Typeline> typelines = jdbcTemplate.query(sql, new TypelineMapper());
        for (Typeline typeline : typelines) {
            if(typeline != null) {
                addCard(typeline);
                addTypes(typeline);
            }
        }
        return typelines;
    }

    @Override
    public List<Typeline> findByCardId(String cardId) {
        final String sql = "select * from typeline where card_id = ?;";
        List<Typeline> typelines = jdbcTemplate.query(sql, new TypelineMapper(), cardId);
        for (Typeline typeline : typelines) {
            if(typeline != null){
                addCard(typeline);
                addTypes(typeline);
            }
        }
        return typelines;
    }

    @Override
    public Typeline findByTypelineId(int typelineId) {
        final String sql = "select * from typeline where typeline_id = ?;";
        Typeline typeline = jdbcTemplate.query(sql, new TypelineMapper(), typelineId).stream().findFirst().orElse(null);
        if (typeline != null) {
            addCard(typeline);
            addTypes(typeline);
        }
        return typeline;
    }

    @Override
    public Typeline add(Typeline typeline) {
        final String sql = "insert into typeline (type_id, card_id) values (?,?);";
        int rowsAffected = 0;
        for (Type type : typeline.getTypes()) {
            rowsAffected += jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId());
        }
        if (rowsAffected <= 0) {
            return null;
        }
        addCard(typeline);
        addTypes(typeline);
        return typeline;
    }

    @Override
    public boolean update(Typeline typeline) {
        final String sql = "update typeline set type_id = ?, card_id = ? where typeline_id = ?;";
        int rowsAffected = 0;
        for (Type type : typeline.getTypes()) {
            rowsAffected += jdbcTemplate.update(sql, type.getTypeId(), typeline.getCard().getCardId(), typeline.getTypelineId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(int typelineId) {
        final String sql = "delete from typeline where typeline_id = ?;";
        return jdbcTemplate.update(sql, typelineId) > 0;
    }

    private void addCard(Typeline typeline) {
        final String sql = "select card_id from typeline where typeline_id = ?;";
        typeline.setCard(jdbcTemplate.query(sql, new CardMapper(),
                typeline.getTypelineId()).stream().findFirst().orElse(null));

    }

    private void addTypes(Typeline typeline) {
        final String sql = "select * from type t inner join typeline tl on t.type_id =" +
                " tl.type_id where card_id = ?;";
        typeline.setTypes(jdbcTemplate.query(sql, new TypeMapper(),
                typeline.getCard().getCardId()));
    }


}
