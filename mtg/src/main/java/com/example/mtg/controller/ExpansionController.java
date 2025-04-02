package com.example.mtg.controller;

import com.example.mtg.model.Expansion;
import com.example.mtg.service.ExpansionService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expansions")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpansionController {

    @Autowired
    private ExpansionService service;

    @GetMapping("/allExpansions")
    public Result<List<Expansion>> findAll(){
        return service.findAllExpansions();
    }

}
