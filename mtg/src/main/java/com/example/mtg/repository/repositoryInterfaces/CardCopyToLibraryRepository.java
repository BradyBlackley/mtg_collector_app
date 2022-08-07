package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.CardCopyToLibrary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardCopyToLibraryRepository {

    CardCopyToLibrary findByLibraryId(int cardToLibraryId);

    CardCopyToLibrary add(CardCopyToLibrary cardCopyToLibrary);

    boolean update(CardCopyToLibrary cardCopyToLibrary);
}
