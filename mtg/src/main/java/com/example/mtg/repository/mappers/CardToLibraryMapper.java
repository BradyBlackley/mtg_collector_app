package com.example.mtg.repository.mappers;

import com.example.mtg.model.CardToLibrary;
import com.example.mtg.model.Library;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardToLibraryMapper implements RowMapper<CardToLibrary> {
    @Override
    public CardToLibrary mapRow(ResultSet rs, int i) throws SQLException {
        CardToLibrary cardToLibrary = new CardToLibrary();
        cardToLibrary.setCardToLibraryId(rs.getInt("card_to_library_id"));
        Library library = new Library();
        library.setLibraryId(rs.getInt("library_id"));
        cardToLibrary.setLibrary(library);
        return cardToLibrary;
    }
}
