package com.example.mtg.controller;

import com.example.mtg.model.Expansion;
import com.example.mtg.service.ExpansionService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addExpansion")
    public Result<Expansion> addExpansion(@RequestBody Expansion expansion) {
        return service.add(expansion);
    }

}
