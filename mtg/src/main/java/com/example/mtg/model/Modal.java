package com.example.mtg.model;

public class Modal {

    private int modalId;
    private Card frontCardId;
    private Card backCardId;


    public Modal(int modalId, Card frontCardId, Card backCardId) {
        this.modalId = modalId;
        this.frontCardId = frontCardId;
        this.backCardId = backCardId;
    }

    public int getModalId() {
        return modalId;
    }

    public void setModalId(int modalId) {
        this.modalId = modalId;
    }

    public Card getFrontCardId() {
        return frontCardId;
    }

    public void setFrontCardId(Card frontCardId) {
        this.frontCardId = frontCardId;
    }

    public Card getBackCardId() {
        return backCardId;
    }

    public void setBackCardId(Card backCardId) {
        this.backCardId = backCardId;
    }
}
