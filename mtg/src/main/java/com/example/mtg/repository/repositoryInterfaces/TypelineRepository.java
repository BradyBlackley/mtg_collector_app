package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Typeline;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TypelineRepository {

    Typeline findByCardId(String cardId);

    Typeline add(Typeline typeline);

    boolean update(Typeline typeline);

    @Transactional
    boolean delete(int typeId, String cardId);
}
