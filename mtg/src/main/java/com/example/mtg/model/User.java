package com.example.mtg.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private final UUID userId;
    private final String userName;
    private final String password;
    private final UUID cardCollectionId;

    public User(@JsonProperty("userId") UUID i,
                @JsonProperty("userName") String n,
                @JsonProperty("password") String p,
                @JsonProperty("cardCollectionId") UUID c){
        this.userId = i;
        this.userName = n;
        this.password = p;
        this.cardCollectionId = c;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return userName;
    }

    public String getPassword() { return password; }

    public UUID getCardCollectionId() { return cardCollectionId; }
}
