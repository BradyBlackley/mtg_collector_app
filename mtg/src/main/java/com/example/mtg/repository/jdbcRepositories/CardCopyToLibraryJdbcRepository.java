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
                "select cctl.card_copy_to_library_id, cctl.card_copy_id, cctl.library_id, cc.card_id, u.user_id, " +
                "u.username, u.password, l.library_name, c.card_id, c.card_name, c.image_path, c.rarity, c.artist_name, " +
                "c.converted_mana_cost, c.power, c.toughness, e.expansion_id, e.expansion_name, e.expansion_code, " +
                "e.released_date, c.text_box " +
                "from card_copy_to_library cctl " +
                "inner join card_copy cc " +
                "on cctl.card_copy_id = cc.card_copy_id " +
                "inner join library l " +
                "on l.library_id = cctl.library_id " +
                "inner join user u " +
                "on l.user_id = u.user_id " +
                "inner join card c " +
                "on c.card_id = cc.card_id " +
                "inner join expansion e " +
                "on c.expansion_id = e.expansion_id " +
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
                "update card_copy_to_library " +
                "set card_copy_id = ?, library_id = ? " +
                "where library_id = ?;";
        int rowsAffected = 0;
        for (CardCopy cardCopy : cardCopyToLibrary.getCardCopies()){
            rowsAffected += jdbcTemplate.update(sql, cardCopy.getCardCopyId(),
                    cardCopyToLibrary.getLibrary().getLibraryId(), cardCopyToLibrary.getLibrary().getLibraryId());
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean delete(CardCopyToLibrary cardCopyToLibrary) {
        final String sql =
                "";
        int rowsAffected = 0;
        for (CardCopy cardCopy : cardCopyToLibrary.getCardCopies()){
            rowsAffected += jdbcTemplate.update(sql);
        }
        return rowsAffected > 0;
    }
}
