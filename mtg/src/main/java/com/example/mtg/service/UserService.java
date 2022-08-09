package com.example.mtg.service;

import com.example.mtg.model.User;
import com.example.mtg.repository.repositoryInterfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id);
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    public User add(User user){
        return repository.add(user);
    }

    public User update(User user){
        User existingUser=repository.findByUsername(user.getUsername());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return repository.add(existingUser);
    }

    public String delete(String id){
        repository.deleteById(id);
        return "user " + id + " removed";
    }

}
