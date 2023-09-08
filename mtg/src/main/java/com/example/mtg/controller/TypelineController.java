package com.example.mtg.controller;

import com.example.mtg.model.Typeline;
import com.example.mtg.service.TypelineService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typelines")
@CrossOrigin(origins = "http://localhost:3000")
public class TypelineController {

    @Autowired
    private TypelineService service;

    @GetMapping("/{cardId}")
    public Result<Typeline> findByCardId(String cardId) {
        return service.findByCardId(cardId);
    }

    @PostMapping("/addTypeline")
    public Result<Typeline> add(Typeline typeline) {
        return service.add(typeline);
    }

    @PutMapping("/updateTypeline")
    public Result<Boolean> update(Typeline typeline) {
        return service.update(typeline);
    }

}
