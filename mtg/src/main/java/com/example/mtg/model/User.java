package com.example.mtg.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String userId;
    private String username;
    private String password;
    private boolean isAdmin;

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

    public User(String userId, String username, String password, boolean isAdmin){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(User other){
        if(other != null) {
            this.userId = other.userId == null ? null : other.userId;
            this.username = other.username == null ? null : other.username;
            this.password = other.password == null ? null : other.password;
            this.isAdmin = other.isAdmin;
        }
    }

    public String getUserId() { return userId; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public boolean isAdmin() { return isAdmin; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) && username.equals(user.username) && password.equals(user.password) && isAdmin == user.isAdmin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, isAdmin);
    }

    @Override
    public String toString() {
        return  "{" +
                "\"userId\":\"" + userId + '\"' +
                ", \"username\":\"" + username + '\"' +
                ", \"isAdmin\":\"" + isAdmin + '\"' +
                '}';
    }
}
