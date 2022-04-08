package com.example.mtg.model;

import java.util.Objects;

public class Modal {

    private int modalId;
    private Card frontCardId;
    private Card backCardId;

    public Modal() {

    }

    public Modal(int modalId) {
        this.modalId = modalId;
    }

    public Modal(int modalId, Card frontCardId) {
        this.modalId = modalId;
        this.frontCardId = frontCardId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modal modal = (Modal) o;
        return modalId == modal.modalId && frontCardId.equals(modal.frontCardId) && backCardId.equals(modal.backCardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modalId, frontCardId, backCardId);
    }

    @Override
    public String toString() {
        return "Modal{" +
                "modalId=" + modalId +
                ", frontCardId=" + frontCardId +
                ", backCardId=" + backCardId +
                '}';
    }
}
