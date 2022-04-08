package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class KeywordList {

    private int keywordListId;
    private List<Keyword> keywords;
    private Card card;

    public KeywordList() {

    }

    public KeywordList(int keywordListId) {
        this.keywordListId = keywordListId;
    }

    public KeywordList(int keywordListId, List<Keyword> keywords) {
        this.keywordListId = keywordListId;
        this.keywords = keywords;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeywordList that = (KeywordList) o;
        return keywordListId == that.keywordListId && keywords.equals(that.keywords) && card.equals(that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordListId, keywords, card);
    }

    @Override
    public String toString() {
        return "KeywordList{" +
                "keywordListId=" + keywordListId +
                ", keywords=" + keywords +
                ", card=" + card +
                '}';
    }
}
