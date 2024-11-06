package com.example.mtg.controller;

import com.example.mtg.model.Library;
import com.example.mtg.service.LibraryService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
@CrossOrigin(origins = "http://localhost:3000")
public class LibraryController {

    @Autowired
    private LibraryService service;

    @GetMapping("/allLibrariesByUser/{userId}")
    private Result<List<Library>> findAllLibrariesByUser(@PathVariable String userId) {
        return service.findAllLibrariesByUser(userId);
    }

    @GetMapping("/libraryByName")
    private Result<Library> findLibraryByName(@PathVariable String libraryName, @PathVariable String userId) {
        return service.findLibraryByName(libraryName, userId);
    }

    @PostMapping("/addLibrary")
    private Result<Library> add(@RequestBody Library library) {
        return service.add(library);
    }

    @PutMapping("/updateLibrary")
    private Result<Boolean> update(@RequestBody Library library) {
        return service.update(library);
    }

    @DeleteMapping("/deleteLibrary")
    private Result<Boolean> delete(@RequestBody Library library) {
        return service.delete(library);
    }
}
