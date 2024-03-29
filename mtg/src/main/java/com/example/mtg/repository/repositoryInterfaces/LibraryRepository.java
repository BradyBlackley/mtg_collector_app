package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Library;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LibraryRepository {
    List<Library> findAllLibrariesByUser(String userId);

    Library findLibraryByName(String libraryName, String userId);

    Library add(Library library);

    boolean update(Library library);

    @Transactional
    boolean delete(Library library);
}
