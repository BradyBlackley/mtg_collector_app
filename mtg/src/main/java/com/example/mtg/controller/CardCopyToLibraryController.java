package com.example.mtg.controller;

import com.example.mtg.model.CardCopyToLibrary;
import com.example.mtg.service.CardCopyToLibraryService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "http://localhost:3000")
public class CardCopyToLibraryController {

    @Autowired
    private CardCopyToLibraryService service;

    @GetMapping("/allCardsByLibrary/{libraryId}")
    public Result<CardCopyToLibrary> findAllCardsByLibrary(@PathVariable int libraryId){
        return service.findByLibraryId(libraryId);
    }
}
