package com.example.mtg.repository.mappers;

import com.example.mtg.model.Library;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryMapper implements RowMapper<Library> {

    @Override
    public Library mapRow(ResultSet rs, int i) throws SQLException {
        Library library = new Library();
        library.setLibraryId(rs.getInt("library_id"));
        library.setLibraryName(rs.getString("library_name"));
        library.setUserId(rs.getString("user_id"));
        return library;
    }
}
