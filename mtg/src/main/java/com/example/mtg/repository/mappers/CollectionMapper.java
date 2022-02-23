package com.example.mtg.repository.mappers;

import com.example.mtg.model.Collection;
import com.example.mtg.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollectionMapper implements RowMapper<Collection> {

    @Override
    public Collection mapRow(ResultSet rs, int i) throws SQLException {
        Collection collection = new Collection();
        collection.setCollectionId(rs.getInt("collection_id"));
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        collection.setUser(user);
        return collection;
    }
}
