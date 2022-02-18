package com.example.mtg.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue
    private String userId;
    private String userName;
    private String password;

    public User(String i, String n, String p){
        this.userId = i;
        this.userName = n;
        this.password = p;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() { return userName; }

    public String getPassword() { return password; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
