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
        //return service.add(user);
        return null;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        //return service.findAll();
        return null;
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable String id){
        //return service.findById(id);
        return null;
    }

    @GetMapping("/user/{name}")
    public User findByName(@PathVariable String name){
        //return service.findByUsername(name);
        return null;
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        //return service.update(user);
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        //return service.delete(id);
        return null;
    }
}
