package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.CardCopy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardCopyRepository {

    List<CardCopy> findAllByUser(String userId);

    List<CardCopy> findAllByCardId(String cardId);

    CardCopy findByCardCopyId(int cardCopyId);

    CardCopy add (CardCopy cardCopy);

    boolean update(CardCopy cardCopy);

    @Transactional
    boolean delete(int cardCopyId);
}
