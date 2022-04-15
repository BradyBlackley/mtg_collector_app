package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Expansion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ExpansionRepository {
    List<Expansion> findAllExpansions();

    Expansion findExpansionByName(String expansionName);

    Expansion add(Expansion expansion);

    boolean update(Expansion expansion);

    @Transactional
    boolean delete(Expansion expansion);
}