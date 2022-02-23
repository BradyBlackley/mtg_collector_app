package com.example.mtg.repository;

import com.example.mtg.model.Library;
import com.example.mtg.repository.mappers.LibraryMapper;
import com.example.mtg.repository.mappers.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibraryJdbcRepository implements LibraryRepository {

    private final JdbcTemplate jdbcTemplate;

    public LibraryJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Library> findAllLibrariesByUser(String userId) {
        final String sql = "select library_id, library_name, user_id from library where user_id = ?;";
        List<Library> libraries = jdbcTemplate.query(sql, new LibraryMapper(), userId);
        for (Library library : libraries) {
            if(library != null) {
                addUser(library);
            }
        }
        return libraries;
    }

    @Override
    public Library findLibraryById(int libraryId) {
        final String sql = "select library_id, library_name, user_id from library where library_id = ?;";
        Library library = jdbcTemplate.query(sql, new LibraryMapper(), libraryId).stream().findFirst().orElse(null);
        if(library != null) {
            addUser(library);
        }
        return library;
    }

    @Override
    public Library findLibraryByName(String libraryName) {
        final String sql = "select library_id, library_name, user_id from library where library_name = ?;";
        Library library = jdbcTemplate.query(sql, new LibraryMapper(), libraryName).stream().findFirst().orElse(null);
        if(library != null) {
            addUser(library);
        }
        return library;
    }

    @Override
    public Library add(Library library) {
        final String sql = "insert into library (library_name, user_id) values (?,?);";
        int rowsAffected = jdbcTemplate.update(sql, library.getLibraryName(), library.getUser().getUserId());
        if(rowsAffected <= 0) {
            return null;
        }
        addUser(library);
        return library;
    }

    @Override
    public boolean update(Library library) {
        return false;
    }

    @Override
    public boolean deleteById(int libraryId) {
        return false;
    }

    private void addUser(Library library) {
        final String sql = "select user_id, username, password from `user` where user_id = ?;";
        library.setUser(jdbcTemplate.query(sql, new UserMapper(),
                library.getUser().getUserId()).stream().findFirst().orElse(null));
    }
}
