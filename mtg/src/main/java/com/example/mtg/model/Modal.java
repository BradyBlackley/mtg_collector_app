package com.example.mtg.model;

import java.util.Objects;

public class Modal extends Card {

    private String modalId;
    private Card frontCard;
    private Card backCard;

    public Modal() {

    }

    public Modal(String modalId) {
        this.modalId = modalId;
    }

    public Modal(String modalId, Card frontCard) {
        this.modalId = modalId;
        this.frontCard = frontCard;
    }

    public Modal(String modalId, Card frontCard, Card backCard) {
        this.modalId = modalId;
        this.frontCard = frontCard;
        this.backCard = backCard;
    }

    public String getModalId() {
        return modalId;
    }

    public void setModalId(String modalId) {
        this.modalId = modalId;
    }

    public Card getfrontCard() {
        return frontCard;
    }

    public void setfrontCard(Card frontCard) {
        this.frontCard = frontCard;
    }

    public Card getbackCard() {
        return backCard;
    }

    public void setbackCard(Card backCard) {
        this.backCard = backCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modal modal = (Modal) o;
        return Objects.equals(modalId, modal.modalId) && frontCard.equals(modal.frontCard) && backCard.equals(modal.backCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modalId, frontCard, backCard);
    }

    @Override
    public String toString() {
        return "{" +
                "\"modalId\":\"" + modalId + "\"" +
                ", \"frontCard\":" + frontCard +
                ", \"backCard\":" + backCard +
                '}';
    }
}
