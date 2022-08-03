package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Modal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModalRepository {

    Modal findByFrontCardId(String cardId);

    Modal findByBackCardId(String cardId);

    Modal findByModalId(String modalId);

    Modal add(Modal modal);

    boolean update(Modal modal);

    @Transactional
    boolean delete(String modalId);
}
