package com.example.mtg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue
    private final int userId;
    private String userName;
    private String password;
    private int cardCollectionId;

    public User(int i,
                String n,
                String p,
                int c){
        this.userId = i;
        this.userName = n;
        this.password = p;
        this.cardCollectionId = c;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() { return userName; }

    public String getPassword() { return password; }

    public int getCardCollectionId() { return cardCollectionId; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCardCollectionId(int cardCollectionId) {
        this.cardCollectionId = cardCollectionId;
    }
}
