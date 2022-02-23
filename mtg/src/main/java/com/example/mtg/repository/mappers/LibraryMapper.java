package com.example.mtg.repository.mappers;

import com.example.mtg.model.Library;
import com.example.mtg.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryMapper implements RowMapper<Library> {

    @Override
    public Library mapRow(ResultSet rs, int i) throws SQLException {
        Library library = new Library();
        User user = new User();
        library.setLibraryId(rs.getInt("library_id"));
        library.setLibraryName(rs.getString("library_name"));
        user.setUserId(rs.getString("user_id"));
        library.setUser(user);
        return library;
    }
}
