package com.example.mtg.repository;

import com.example.mtg.model.Collection;
import com.example.mtg.repository.mappers.CollectionMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollectionJdbcRepository implements CollectionRepository {

    private final JdbcTemplate jdbcTemplate;

    public CollectionJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Collection> findAll() {
        final String sql = "select collection_id, user_id from collection;";
        return jdbcTemplate.query(sql, new CollectionMapper());
    }

    @Override
    public Collection findById(int collectionId) {
        return null;
    }

    @Override
    public Collection add(Collection collection) {
        return null;
    }

    @Override
    public boolean update(Collection collection) {
        return false;
    }

    @Override
    public boolean deleteById(String collectionId) {
        return false;
    }
}
