package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Library;
import com.example.mtg.repository.mappers.LibraryMapper;
import com.example.mtg.repository.repositoryInterfaces.LibraryRepository;
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
        return libraries;
    }

    @Override
    public Library findLibraryByName(String libraryName, String userid) {
        final String sql = "select library_id, library_name, user_id from library where library_name = ? and user_id = ?;";
        Library library = jdbcTemplate.query(sql, new LibraryMapper(), libraryName,
                userid).stream().findFirst().orElse(null);
        return library;
    }

    @Override
    public Library add(Library library) {
        final String sql = "insert into library (library_name, user_id) values (?,?);";
        jdbcTemplate.update(sql, library.getLibraryName(), library.getUserId());
        return library;
    }

    @Override
    public boolean update(Library library) {
        final String sql = "update library set library_name = ?, user_id = ? where library_id = ?;";
        return jdbcTemplate.update(sql, library.getLibraryName(),
                library.getUserId(), library.getLibraryId()) > 0;
    }

    @Override
    public boolean delete(Library library) {
        final String sql = "delete from library where user_id = ? and library_name = ?;";
        int rowsAffected = 0;
        rowsAffected += jdbcTemplate.update(sql, library.getUserId(), library.getLibraryName());
        return rowsAffected > 0;
    }
}
