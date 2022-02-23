package com.example.mtg.repository;

import com.example.mtg.model.Library;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LibraryRepository {
    List<Library> findAllLibrariesByUser(String userId);

    Library findLibraryById(int libraryId);

    Library findLibraryByName(String libraryName);

    Library add(Library library);

    boolean update(Library library);

    @Transactional
    boolean deleteById(int libraryId);
}
