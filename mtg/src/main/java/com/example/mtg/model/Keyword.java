package com.example.mtg.model;

public class Keyword {

    private int keywordId;
    private String keywordName;


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
}
