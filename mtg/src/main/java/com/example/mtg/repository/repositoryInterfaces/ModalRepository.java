package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Modal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModalRepository {

    List<Modal> findAll();

    Modal findByFrontCardId(String cardId);

    Modal findByBackCardId(String cardId);

    Modal findByFrontOrBackCardName(String cardName);

    Modal findById(String modalId);

    Modal add(Modal modal);

    boolean update(Modal modal);

    @Transactional
    boolean delete(Modal modal);
}
