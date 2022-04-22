package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.ColorIdentity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ColorIdentityRepository {

    List<ColorIdentity> findAll();

    ColorIdentity findByColorIdentityId(int colorIdentityId);

    ColorIdentity add(ColorIdentity colorIdentity);

    boolean update(ColorIdentity colorIdentity);

    @Transactional
    boolean delete(int colorIdentityId);
}
