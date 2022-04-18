package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.CardToLibrary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardToLibraryRepository {

    List<CardToLibrary> findAll();

    CardToLibrary findById(int cardToLibraryId);

    CardToLibrary add(CardToLibrary cardToLibrary);

    boolean update(CardToLibrary cardToLibrary);

    @Transactional
    boolean delete(int cardToLibraryId);
}
