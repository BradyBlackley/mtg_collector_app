package com.example.mtg.model;

import java.util.Objects;

public class Keyword {

    private int keywordId;
    private String keywordName;

    public Keyword() {

    }

    public Keyword(int keywordId) {
        this.keywordId = keywordId;
    }

    public Keyword(String keywordName) {
        this.keywordName = keywordName;
    }

    public Keyword(int keywordId, String keywordName) {
        this.keywordId = keywordId;
        this.keywordName = keywordName;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return keywordId == keyword.keywordId && keywordName.equals(keyword.keywordName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordId, keywordName);
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "keywordId=" + keywordId +
                ", keywordName='" + keywordName + '\'' +
                '}';
    }
}
