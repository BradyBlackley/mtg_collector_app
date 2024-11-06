package com.example.mtg.model;

import java.util.Objects;

public class Library {

    private int libraryId;
    private String libraryName;
    private String userId;

    public Library() {

    }

    public Library(int libraryId) {
        this.libraryId = libraryId;
    }

    public Library(String libraryName, String userId) {
        this.libraryName = libraryName;
        this.userId = userId;
    }

    public Library(int libraryId, String libraryName, String userId) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return libraryId == library.libraryId && libraryName.equals(library.libraryName) && userId.equals(library.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, libraryName, userId);
    }

    @Override
    public String toString() {
        return "{" +
                "\"libraryId\":" + libraryId +
                ", \"libraryName\":\"" + libraryName + '\"' +
                ", \"userId\":\"" + userId + "\"" +
                '}';
    }
}
