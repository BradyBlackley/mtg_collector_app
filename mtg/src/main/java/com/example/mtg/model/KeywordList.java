package com.example.mtg.model;

import java.util.List;

public class KeywordList {

    private int keywordListId;
    private List<Keyword> keywords;
    private Card card;


    public KeywordList(int keywordListId, List<Keyword> keywords, Card card) {
        this.keywordListId = keywordListId;
        this.keywords = keywords;
        this.card = card;
    }

    public int getKeywordListId() {
        return keywordListId;
    }

    public void setKeywordListId(int keywordListId) {
        this.keywordListId = keywordListId;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
