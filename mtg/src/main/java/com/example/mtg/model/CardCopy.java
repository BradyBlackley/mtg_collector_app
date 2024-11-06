package com.example.mtg.model;

import java.util.Objects;

public class CardCopy {

    private int cardCopyId;
    private Card card;
    private String userId;

    public CardCopy() {

    }

    public CardCopy(int cardCopyId) {
        this.cardCopyId = cardCopyId;
    }

    public CardCopy(int cardCopyId, Card card) {
        this.cardCopyId = cardCopyId;
        this.card = card;
    }

    public CardCopy(int cardCopyId, Card card, String userId) {
        this.cardCopyId = cardCopyId;
        this.card = card;
        this.userId = userId;
    }

    public int getCardCopyId() {
        return cardCopyId;
    }

    public void setCardCopyId(int cardCopyId) {
        this.cardCopyId = cardCopyId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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
        CardCopy cardCopy = (CardCopy) o;
        return cardCopyId == cardCopy.cardCopyId && card.equals(cardCopy.card) && userId.equals(cardCopy.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardCopyId, card, userId);
    }

    @Override
    public String toString() {
        return "{" +
                "\"cardCopyId\":" + cardCopyId +
                ", \"card\":" + card +
                ", \"userId\":\"" + userId + "\"" +
                '}';
    }
}
