package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.ColorIdentity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ColorIdentityRepository {

    ColorIdentity findByCardId(String cardId);

    ColorIdentity add(ColorIdentity colorIdentity);

    boolean update(ColorIdentity colorIdentity);

    @Transactional
    boolean delete(ColorIdentity colorIdentity);
}
