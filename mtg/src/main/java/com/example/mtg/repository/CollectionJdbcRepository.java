package com.example.mtg.repository;

import com.example.mtg.model.Collection;
import com.example.mtg.model.User;
import com.example.mtg.repository.mappers.CollectionMapper;
import com.example.mtg.repository.mappers.UserMapper;
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
    public Collection findByCollectionId(int collectionId) {
        final String sql = "select collection_id, user_id from collection where collection_id = ?;";
        Collection collection = jdbcTemplate.query(sql, new CollectionMapper(), collectionId).stream().findFirst().orElse(null);

        if(collection != null){
            addUser(collection);
        }

        return collection;
    }

    @Override
    public Collection findByUserId(String userId) {
        final String sql = "select collection_id, user_id from collection where user_id = ?;";
        return jdbcTemplate.query(sql, new CollectionMapper(), userId).stream().findFirst().orElse(null);
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

    private void addUser(Collection collection) {
        final String sql = "select user_id, username, password from `user` where user_id = ?;";

        User user = jdbcTemplate.query(sql, new UserMapper(), collection.getUser().getUserId()).stream().findFirst().orElse(null);

        collection.setUser(user);
    }


}
