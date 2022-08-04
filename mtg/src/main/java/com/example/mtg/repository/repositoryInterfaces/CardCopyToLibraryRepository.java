package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.CardCopyToLibrary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardCopyToLibraryRepository {

    List<CardCopyToLibrary> findAll();

    CardCopyToLibrary findById(int cardToLibraryId);

    CardCopyToLibrary add(CardCopyToLibrary cardCopyToLibrary);

    boolean update(CardCopyToLibrary cardCopyToLibrary);

    @Transactional
    boolean delete(int cardToLibraryId);
}
