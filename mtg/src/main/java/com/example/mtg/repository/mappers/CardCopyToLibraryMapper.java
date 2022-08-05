package com.example.mtg.repository.mappers;

import com.example.mtg.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardCopyToLibraryMapper implements ResultSetExtractor<CardCopyToLibrary> {

    @Override
    public CardCopyToLibrary extractData(ResultSet rs) throws SQLException, DataAccessException {
        if(!rs.next()){
            return null;
        }
        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        Library library = new Library();
        library.setLibraryId(rs.getInt("library_id"));
        List<CardCopy> cardCopies = new ArrayList<>();
        do {
            CardCopy cardCopy = new CardCopy();
            cardCopy.setCardCopyId(rs.getInt("card_copy_id"));
            Card card = new Card();
            card.setCardId(rs.getString("card_id"));
            cardCopy.setCard(card);
            User user = new User();
            user.setUserId(rs.getString("user_id"));
            cardCopy.setUser(user);
            cardCopies.add(cardCopy);
        }while(rs.next());

        cardCopyToLibrary.setCardCopies(cardCopies);
        cardCopyToLibrary.setLibrary(library);
        return cardCopyToLibrary;
    }
}
