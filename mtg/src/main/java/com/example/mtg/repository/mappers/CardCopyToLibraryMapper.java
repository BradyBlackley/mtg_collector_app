package com.example.mtg.repository.mappers;

import com.example.mtg.model.CardCopyToLibrary;
import com.example.mtg.model.Library;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardCopyToLibraryMapper implements RowMapper<CardCopyToLibrary> {
    @Override
    public CardCopyToLibrary mapRow(ResultSet rs, int i) throws SQLException {
        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setCardToLibraryId(rs.getInt("card_to_library_id"));
        Library library = new Library();
        library.setLibraryId(rs.getInt("library_id"));
        cardCopyToLibrary.setLibrary(library);
        return cardCopyToLibrary;
    }
}
