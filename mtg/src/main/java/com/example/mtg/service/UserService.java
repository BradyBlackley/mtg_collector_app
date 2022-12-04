package com.example.mtg.service;

import com.example.mtg.model.User;
import com.example.mtg.repository.repositoryInterfaces.UserRepository;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Result<List<User>> findAll(){
        Result<List<User>> result = new Result<>();
        List<User> users = repository.findAll();

        result.setPayload(users);

        if (users.size() <= 0) {
            result.addMessage("Error: users " + ResultType.NOT_FOUND.label, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<User> findById(String id){
        Result<User> result = new Result<>();
        User user = repository.findById(id);

        result.setPayload(user);

        if (!validateUserId(id)) {
            result.addMessage("The provided user id " + id + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if(user == null){
            result.addMessage("User id " + id + " " + ResultType.NOT_FOUND.label, ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<User> findByUsername(String username){
        Result<User> result = new Result<>();
        User user = repository.findByUsername(username);

        result.setPayload(user);

        if (!validateUsername(username)) {
            result.addMessage("The provided username " + username + " is " + ResultType.INVALID.label +
                    ". Username must be greater than 3 characters and less than 16 characters", ResultType.INVALID);
        } else if(user == null) {
            result.addMessage("User with username " + username + " " + ResultType.NOT_FOUND.label,
                    ResultType.NOT_FOUND);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<User> add(User user){
        Result<User> result = new Result<>();
        result.setPayload(user);

          if (!validateUsername(user.getUsername())) {
            result.addMessage("The provided username " + user.getUsername() + " is " + ResultType.INVALID.label +
                    ". Username must be greater than 3 characters and less than 16 characters", ResultType.INVALID);
        } else if (!validatePassword(user.getPassword())) {
            result.addMessage("The provided user password is " + ResultType.INVALID.label +
                    ". Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), and a " +
                    "minimum of 8 characters", ResultType.INVALID);
        } else if (repository.findByUsername(user.getUsername()) != null) {
            result.addMessage("Username " + user.getUsername() + " is already taken", ResultType.INVALID);
        } else if (repository.findById(user.getUserId()) != null) {
            result.addMessage("User with id " + user.getUserId() + " already exists", ResultType.INVALID);
        } else {
            result.setPayload(repository.add(user));
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<User> update(User user){
        Result<User> result = new Result<>();
        result.setPayload(user);

        if (!validateUserId(user.getUserId())) {
            result.addMessage("The provided user id " + user.getUserId() + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (!validateUsername(user.getUsername())) {
            result.addMessage("The provided username " + user.getUsername() + " is " + ResultType.INVALID.label +
                    ". Username must be greater than 3 characters and less than 16 characters", ResultType.INVALID);
        } else if (!validatePassword(user.getPassword())) {
            result.addMessage("The provided user password is " + ResultType.INVALID.label +
                    ". Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), and a " +
                    "minimum of 8 characters", ResultType.INVALID);
        } else if (!repository.update(user)) {
            result.addMessage("Failed to update provided user " + user.getUserId() + " " + user.getUsername(),
                    ResultType.ERROR);
        } else {
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public Result<Boolean> delete(String id){
        Result<Boolean> result = new Result<>();
        result.setPayload(false);

        if (!validateUserId(id)) {
            result.addMessage("The provided user id " + id + " is " + ResultType.INVALID.label,
                    ResultType.INVALID);
        } else if (repository.findById(id) == null) {
            result.addMessage("User with provided user id " + id + " does not exist", ResultType.NOT_FOUND);
        } else if (!repository.deleteById(id)) {
            result.addMessage("Failed to delete provided user " + id, ResultType.ERROR);
        } else {
            result.setPayload(true);
            result.addMessage(ResultType.SUCCESS.label, ResultType.SUCCESS);
        }

        return result;
    }

    public boolean validateUser(User user) {
        System.out.println(validateUserId(user.getUserId()) +
                " + " + validateUsername(user.getUsername()) +
                " + " + validatePassword(user.getPassword()));
        return validateUserId(user.getUserId())
            && validateUsername(user.getUsername())
            && validatePassword(user.getPassword());
    }

    private boolean validateUserId(String id) {
        Pattern pattern = Pattern.compile(
                "^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    private boolean validateUsername(String username) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,15}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
