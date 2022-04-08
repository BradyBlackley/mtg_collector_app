package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class ColorIdentity {

    private int colorIdentityId;
    private Card card;
    private List<Color> colors;

    public ColorIdentity() {

    }

    public ColorIdentity(int colorIdentityId) {
        this.colorIdentityId = colorIdentityId;
    }

    public ColorIdentity(int colorIdentityId, Card card) {
        this.colorIdentityId = colorIdentityId;
        this.card = card;
    }

    public ColorIdentity(int colorIdentityId, Card card, List<Color> colors) {
        this.colorIdentityId = colorIdentityId;
        this.card = card;
        this.colors = colors;
    }

    public int getColorIdentityId() {
        return colorIdentityId;
    }

    public void setColorIdentityId(int colorIdentityId) {
        this.colorIdentityId = colorIdentityId;
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
        return colorIdentityId == that.colorIdentityId && card.equals(that.card) && colors.equals(that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorIdentityId, card, colors);
    }

    @Override
    public String toString() {
        return "ColorIdentity{" +
                "colorIdentityId=" + colorIdentityId +
                ", card=" + card +
                ", colors=" + colors +
                '}';
    }
}
