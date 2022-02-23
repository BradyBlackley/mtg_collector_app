package com.example.mtg.model;

public class Library {

    private int libraryId;
    private String libraryName;
    private User user;

    public Library() {

    }

    public Library(int libraryId, String libraryName, User user) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.user = user;
    }

    public Library(String libraryName, User user) {
        this.libraryName = libraryName;
        this.user = user;
    }


    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
