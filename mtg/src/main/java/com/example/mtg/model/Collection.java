package com.example.mtg.model;

public class Collection {

    private int collectionId;
    private User user;

    public Collection() {}

    public Collection(int collectionId, User user) {
        this.collectionId = collectionId;
        this.user = user;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
