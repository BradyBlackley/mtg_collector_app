package com.example.mtg.model;

import java.util.Objects;

public class CardCopy {

    private int cardCopyId;
    private Card card;
    private User user;

    public CardCopy() {

    }

    public CardCopy(int cardCopyId) {
        this.cardCopyId = cardCopyId;
    }

    public CardCopy(int cardCopyId, Card card) {
        this.cardCopyId = cardCopyId;
        this.card = card;
    }

    public CardCopy(int cardCopyId, Card card, User user) {
        this.cardCopyId = cardCopyId;
        this.card = card;
        this.user = user;
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
        CardCopy cardCopy = (CardCopy) o;
        return cardCopyId == cardCopy.cardCopyId && card.equals(cardCopy.card) && user.equals(cardCopy.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardCopyId, card, user);
    }

    @Override
    public String toString() {
        return "CardCopy{" +
                "cardCopyId=" + cardCopyId +
                ", card=" + card +
                ", user=" + user +
                '}';
    }
}
