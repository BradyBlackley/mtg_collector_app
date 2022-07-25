package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class ColorIdentity {
    private Card card;
    private List<Color> colors;

    public ColorIdentity() {

    }

    public ColorIdentity(Card card) {
        this.card = card;
    }

    public ColorIdentity(Card card, List<Color> colors) {
        this.card = card;
        this.colors = colors;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorIdentity that = (ColorIdentity) o;
        return card.equals(that.card) && colors.equals(that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, colors);
    }

    @Override
    public String toString() {
        return "ColorIdentity{" +
                "card=" + card +
                ", colors=" + colors +
                '}';
    }
}
