package com.example.mtg.controller;

import com.example.mtg.model.User;
import com.example.mtg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.add(user);
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable String id){
        return service.findById(id);
    }

    @GetMapping("/user/{name}")
    public User findByName(@PathVariable String name){
        return service.findByUsername(name);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        return service.delete(id);
    }
}
