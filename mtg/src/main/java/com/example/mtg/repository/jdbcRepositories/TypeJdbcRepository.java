package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Type;
import com.example.mtg.repository.mappers.TypeMapper;
import com.example.mtg.repository.repositoryInterfaces.TypeRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TypeJdbcRepository implements TypeRepository {

    private final JdbcTemplate jdbcTemplate;

    public TypeJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Type> findAllTypes() {
        final String sql = "select * from type;";
        return jdbcTemplate.query(sql, new TypeMapper());
    }

    @Override
    public Type findTypeByName(String typeName) {
        final String sql = "select * from type where type_name = ?;";
        return jdbcTemplate.query(sql, new TypeMapper(), typeName).stream().findFirst().orElse(null);
    }

    @Override
    public Type add(Type type) {
        final String sql = "insert into type (type_name) values (?);";
        int rowsAffected = jdbcTemplate.update(sql, type.getTypeName());
        if(rowsAffected <= 0) {
            return null;
        }
        return type;
    }

    @Override
    public boolean update(Type type) {
        final String sql = "update type set type_name = ? where type_id = ?;";
        return jdbcTemplate.update(sql, type.getTypeName(), type.getTypeId()) > 0;
    }

    @Override
    public boolean delete(Type type) {
        final String sql = "delete from type where type_name = ?";
        return jdbcTemplate.update(sql, type.getTypeName()) > 0;
    }
}
