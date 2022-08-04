package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.CardCopy;
import com.example.mtg.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardCopyRepository {

    List<CardCopy> findAllByUser(String userId);

    List<CardCopy> findAllByCardId(String cardId, String userId);

    CardCopy findByCardCopyId(int cardCopyId);

    CardCopy add (CardCopy cardCopy);

    boolean update(CardCopy cardCopy);

    @Transactional
    boolean delete(int cardCopyId);
}
