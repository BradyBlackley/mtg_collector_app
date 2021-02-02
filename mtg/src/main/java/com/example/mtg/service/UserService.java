package com.example.mtg.service;


import com.example.mtg.model.User;
import com.example.mtg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String userName){
        return repository.findByUserName(userName);
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "user " + id + " removed";
    }

    public User updateUser(User user){
        User existingUser=repository.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setCardCollectionId(user.getCardCollectionId());
        return repository.save(existingUser);
    }

}
