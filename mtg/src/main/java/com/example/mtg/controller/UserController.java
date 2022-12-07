package com.example.mtg.controller;

import com.example.mtg.model.User;
import com.example.mtg.service.UserService;
import com.example.mtg.service.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public Result<List<User>> findAll(){
        return service.findAll();
    }

    @GetMapping("/userId/{id}")
    public Result<User> findById(@PathVariable String id){
        return service.findById(id);
    }

    @GetMapping("/userName/{name}")
    public Result<User> findByName(@PathVariable String name){
        return service.findByUsername(name);
    }

    @PostMapping("/addUser")
    public Result<User> addUser(@RequestBody User user){
        return service.add(user);
    }

    @PutMapping("/updateUser")
    public Result<User> update(@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Result<Boolean> deleteById(@PathVariable String id){
        return service.delete(id);
    }
}
