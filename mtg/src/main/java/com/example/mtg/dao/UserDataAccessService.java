package com.example.mtg.dao;

import com.example.mtg.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("UserDataAccessDao")
public class UserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getName(), user.getPassword(), user.getCardCollectionId()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }


}
