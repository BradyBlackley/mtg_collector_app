package com.example.mtg.model;

import java.util.Objects;

public class User {

    private String userId;
    private String username;
    private String password;

    public User(){

    }

    public User(String userId) {
        this.userId = userId;
    }


    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public User(String userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() { return userId; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password);
    }

    @Override
    public String toString() {
        return  "{" +
                "\"userId\":\"" + userId + '\"' +
                ", \"username\":\"" + username + '\"' +
                ", \"password\":\"" + password.hashCode() + '\"' +
                '}';
    }
}
