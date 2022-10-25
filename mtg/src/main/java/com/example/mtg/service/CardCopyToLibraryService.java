package com.example.mtg.service;

import com.example.mtg.repository.repositoryInterfaces.CardCopyToLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardCopyToLibraryService {
    @Autowired
    CardCopyToLibraryRepository repository;
    @Autowired
    CardService cardService;
    @Autowired
    LibraryService libraryService;

}
