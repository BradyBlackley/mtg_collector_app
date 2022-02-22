package com.example.mtg.model;

public class User {

    private String userId;
    private String username;
    private String password;

    public User(){

    }

    public User(String i, String n, String p){
        this.userId = i;
        this.username = n;
        this.password = p;
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

}
