package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class KeywordList {

    private List<Keyword> keywords;
    private Card card;

    public KeywordList() {

    }

    public KeywordList(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public KeywordList(List<Keyword> keywords, Card card) {
        this.keywords = keywords;
        this.card = card;
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
        return keywords.equals(that.keywords) && card.equals(that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywords, card);
    }

    @Override
    public String toString() {
        return "{" +
                "\"keywords\":" + keywords +
                ", \"card\":" + card +
                '}';
    }
}
