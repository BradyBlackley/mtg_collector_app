package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.CardCopy;
import com.example.mtg.model.CardCopyToLibrary;
import com.example.mtg.repository.mappers.CardCopyMapper;
import com.example.mtg.repository.mappers.CardCopyToLibraryMapper;
import com.example.mtg.repository.repositoryInterfaces.CardCopyToLibraryRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CardCopyToLibraryJdbcRepository implements CardCopyToLibraryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CardCopyToLibraryJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CardCopyToLibrary> findAll() {
        final String sql =
                "select * " +
                "from card_to_library;";
        List<CardCopyToLibrary> cardCopyToLibraryList = jdbcTemplate.query(sql, new CardCopyToLibraryMapper());
        for (CardCopyToLibrary cardCopyToLibrary : cardCopyToLibraryList) {
            if(cardCopyToLibrary != null) {
                addCardCopies(cardCopyToLibrary);
            }
        }
        return cardCopyToLibraryList;
    }

    @Override
    public CardCopyToLibrary findById(int cardToLibraryId) {
        final String sql =
                "select * " +
                "from card_to_library " +
                "where card_to_library_id = ?;";
        CardCopyToLibrary cardCopyToLibrary = jdbcTemplate.query(sql,new CardCopyToLibraryMapper(),
                cardToLibraryId).stream().findFirst().orElse(null);
        if(cardCopyToLibrary != null) {
            addCardCopies(cardCopyToLibrary);
        }
        return cardCopyToLibrary;
    }

    @Override
    public CardCopyToLibrary add(CardCopyToLibrary cardCopyToLibrary) {
        final String sql =
                "insert into card_to_library (card_copy_id, library_id) " +
                "values (?,?)";
        for (CardCopy cardCopy : cardCopyToLibrary.getCardCopies()){
            jdbcTemplate.update(sql, cardCopy.getCardCopyId(),
                    cardCopyToLibrary.getLibrary().getLibraryId());
        }
        return cardCopyToLibrary;
    }

    @Override
    public boolean update(CardCopyToLibrary cardCopyToLibrary) {
        final String sql =
                "update card_to_library " +
                "set card_copy_id = ?, library_id = ? " +
                "where card_to_library = ?;";
        int rowsAffected = 0;
        for (CardCopy cardCopy : cardCopyToLibrary.getCardCopies()){
            rowsAffected += jdbcTemplate.update(sql, cardCopy.getCardCopyId(),
                    cardCopyToLibrary.getLibrary().getLibraryId(), cardCopyToLibrary.getCardToLibraryId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(int cardToLibraryId) {
        final String sql =
                "delete from card_to_library " +
                "where card_to_library_id = ?;";
        return jdbcTemplate.update(sql, cardToLibraryId) > 0;
    }

    private void addCardCopies(CardCopyToLibrary cardCopyToLibrary) {
        final String sql =
                "select * " +
                "from card_copy cc " +
                "inner join card_to_library ctl " +
                "on cc.card_copy_id = ctl.card_copy_id " +
                "where ctl.card_to_library_id = ?;";
        cardCopyToLibrary.setCardCopies(jdbcTemplate.query(sql, new CardCopyMapper(), cardCopyToLibrary.getCardToLibraryId()));
    }
}
