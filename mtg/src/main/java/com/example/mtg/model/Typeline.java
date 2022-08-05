package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class Typeline {

    private List<Type> types;
    private Card card;

    public Typeline() {

    }

    public Typeline(List<Type> types) {
        this.types = types;
    }

    public Typeline(List<Type> types, Card card) {
        this.types = types;
        this.card = card;
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
        return Objects.equals(types, typeline.types) && Objects.equals(card, typeline.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(types, card);
    }

    @Override
    public String toString() {
        return "{" +
                "\"types\":" + types +
                ", \"card\":" + card +
                '}';
    }
}
