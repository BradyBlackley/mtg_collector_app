package com.example.mtg.repository;

import com.example.mtg.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findByUsername(String username);

    User findById(String userId);

    User add(User user);

    boolean update(User user);

    @Transactional
    boolean deleteById(String userId);
}
