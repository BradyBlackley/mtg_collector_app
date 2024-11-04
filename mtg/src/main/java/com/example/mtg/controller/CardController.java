package com.example.mtg.controller;

import com.example.mtg.model.Card;
import com.example.mtg.service.CardService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping("/allCards")
    public Result<List<Card>> findAll(){
        return service.findAllCards();
    }
}
