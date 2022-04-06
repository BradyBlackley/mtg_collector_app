package com.example.mtg.model;

import java.util.List;

public class Typeline {

    private int typelineId;
    private List<Type> types;
    private Card card;

    public Typeline(int typelineId, List<Type> types, Card card) {
        this.typelineId = typelineId;
        this.types = types;
        this.card = card;
    }

    public int getTypelineId() {
        return typelineId;
    }

    public void setTypelineId(int typelineId) {
        this.typelineId = typelineId;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
