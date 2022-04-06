package com.example.mtg.model;

public class CardCopy {

    private int cardCopyId;
    private Card card;
    private User user;

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
}
