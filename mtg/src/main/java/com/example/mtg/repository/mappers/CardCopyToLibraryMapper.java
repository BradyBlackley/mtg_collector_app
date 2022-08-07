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
        library.setLibraryName(rs.getString("library_name"));
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        library.setUser(user);
        List<CardCopy> cardCopies = new ArrayList<>();
        do {
            Expansion expansion = new Expansion();
            expansion.setExpansionId(rs.getInt("expansion_id"));
            expansion.setExpansionName(rs.getString("expansion_name"));
            expansion.setExpansionCode(rs.getString("expansion_code"));
            expansion.setReleasedDate(rs.getDate("released_date"));
            CardCopy cardCopy = new CardCopy();
            cardCopy.setCardCopyId(rs.getInt("card_copy_id"));
            Card card = new Card();
            card.setCardId(rs.getString("card_id"));
            card.setCardName(rs.getString("card_name"));
            card.setImagePath(rs.getString("image_path"));
            card.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            card.setArtistName(rs.getString("artist_name"));
            card.setConvertedManaCost(rs.getString("converted_mana_cost"));
            card.setPower(rs.getString("power"));
            card.setToughness(rs.getString("toughness"));
            card.setExpansion(expansion);
            card.setTextBox(rs.getString("text_box"));
            cardCopy.setCard(card);
            User user1 = new User();
            user1.setUserId(rs.getString("user_id"));
            user1.setUsername(rs.getString("username"));
            user1.setPassword(rs.getString("password"));
            cardCopy.setUser(user1);
            cardCopies.add(cardCopy);
        }while(rs.next());

        cardCopyToLibrary.setCardCopies(cardCopies);
        cardCopyToLibrary.setLibrary(library);
        return cardCopyToLibrary;
    }
}
