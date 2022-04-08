package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class Typeline {

    private int typelineId;
    private List<Type> types;
    private Card card;

    public Typeline() {

    }

    public Typeline(int typelineId) {
        this.typelineId = typelineId;
    }

    public Typeline(int typelineId, List<Type> types) {
        this.typelineId = typelineId;
        this.types = types;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Typeline typeline = (Typeline) o;
        return typelineId == typeline.typelineId && Objects.equals(types, typeline.types) && Objects.equals(card, typeline.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typelineId, types, card);
    }

    @Override
    public String toString() {
        return "Typeline{" +
                "typelineId=" + typelineId +
                ", types=" + types +
                ", card=" + card +
                '}';
    }
}
