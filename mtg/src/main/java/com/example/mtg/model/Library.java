package com.example.mtg.model;

import java.util.Objects;

public class Library {

    private int libraryId;
    private String libraryName;
    private User user;

    public Library() {

    }

    public Library(int libraryId) {
        this.libraryId = libraryId;
    }

    public Library(String libraryName, User user) {
        this.libraryName = libraryName;
        this.user = user;
    }

    public Library(int libraryId, String libraryName, User user) {
        this.libraryId = libraryId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return libraryId == library.libraryId && libraryName.equals(library.libraryName) && user.equals(library.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, libraryName, user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId=" + libraryId + '\'' +
                ", libraryName='" + libraryName + '\'' +
                ", user=" + user + '\'' +
                '}';
    }
}
