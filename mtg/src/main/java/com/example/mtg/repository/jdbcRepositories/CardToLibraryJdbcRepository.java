package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.Card;
import com.example.mtg.model.CardCopy;
import com.example.mtg.model.CardToLibrary;
import com.example.mtg.model.Library;
import com.example.mtg.repository.mappers.CardCopyMapper;
import com.example.mtg.repository.mappers.CardToLibraryMapper;
import com.example.mtg.repository.repositoryInterfaces.CardToLibraryRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CardToLibraryJdbcRepository implements CardToLibraryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CardToLibraryJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CardToLibrary> findAll() {
        final String sql = "select * from card_to_library;";
        List<CardToLibrary> cardToLibraryList = jdbcTemplate.query(sql, new CardToLibraryMapper());
        for (CardToLibrary cardToLibrary : cardToLibraryList) {
            if(cardToLibrary != null) {
                addCardCopies(cardToLibrary);
            }
        }
        return cardToLibraryList;
    }

    @Override
    public CardToLibrary findById(int cardToLibraryId) {
        final String sql = "select * from card_to_library where card_to_library_id = ?;";
        CardToLibrary cardToLibrary = jdbcTemplate.query(sql,new CardToLibraryMapper(),
                cardToLibraryId).stream().findFirst().orElse(null);
        if(cardToLibrary != null) {
            addCardCopies(cardToLibrary);
        }
        return cardToLibrary;
    }

    @Override
    public CardToLibrary add(CardToLibrary cardToLibrary) {
        final String sql = "insert into card_to_library (card_copy_id, library_id) values (?,?)";
        int rowsAffected = 0;
        for (CardCopy cardCopy : cardToLibrary.getCardCopies()){
            rowsAffected += jdbcTemplate.update(sql, cardCopy.getCardCopyId(),
                    cardToLibrary.getLibrary().getLibraryId());
        }
        if (rowsAffected <= 0){
            return null;
        }
        return cardToLibrary;
    }

    @Override
    public boolean update(CardToLibrary cardToLibrary) {
        return false;
    }

    @Override
    public boolean delete(int cardToLibraryId) {
        return false;
    }

    private void addCardCopies(CardToLibrary cardToLibrary) {
        final String sql = "select * from card_copy cc inner join card_to_library ctl on cc.card_copy_id = " +
                "ctl.card_copy_id where ctl.card_to_library_id = ?;";
        cardToLibrary.setCardCopies(jdbcTemplate.query(sql, new CardCopyMapper(), cardToLibrary.getCardToLibraryId()));
    }
}
