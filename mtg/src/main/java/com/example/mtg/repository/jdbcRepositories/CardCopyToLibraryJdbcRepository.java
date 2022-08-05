package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.CardCopy;
import com.example.mtg.model.CardCopyToLibrary;
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
    public CardCopyToLibrary findByLibraryId(int libraryId) {
        final String sql =
                "select cctl.card_copy_to_library_id, cctl.card_copy_id, cctl.library_id, cc.card_id, cc.user_id, l.library_name, l.user_id " +
                "from card_copy_to_library cctl " +
                "inner join card_copy cc " +
                "on cctl.card_copy_id = cc.card_copy_id " +
                "inner join library l  " +
                "on l.library_id = cctl.library_id " +
                "where cctl.library_id = ?;";
        return jdbcTemplate.query(sql,new CardCopyToLibraryMapper(),
                libraryId);
    }

    @Override
    public CardCopyToLibrary add(CardCopyToLibrary cardCopyToLibrary) {
        final String sql =
                "insert into card_copy_to_library (card_copy_id, library_id) " +
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
                    cardCopyToLibrary.getLibrary().getLibraryId());
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
}
