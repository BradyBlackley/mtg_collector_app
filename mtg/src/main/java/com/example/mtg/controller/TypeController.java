package com.example.mtg.controller;

import com.example.mtg.model.Type;
import com.example.mtg.service.TypeService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping("/types")
    public Result<List<Type>> findAllTypes() {
        return service.findAllTypes();
    }

    @GetMapping("/type/{name}")
    public Result<Type> findTypeByName(@PathVariable String name) {
        return service.findTypeByName(name);
    }

    @PostMapping("/addType")
    public Result<Type> add(@RequestBody Type type) {
        return service.add(type);
    }

    @PutMapping("/updateType")
    public Result<Boolean> update(@RequestBody Type type) {
        return service.update(type);
    }

    @DeleteMapping("/deleteType")
    public Result<Boolean> delete(@RequestBody Type type) {
        return service.delete(type);
    }
}
