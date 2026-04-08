package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class ColorIdentity {
    private String cardId;
    private List<Color> colors;

    public ColorIdentity(){

    }

    public ColorIdentity(String cardId) {
        this.cardId = cardId;
    }

    public ColorIdentity(List<Color> colors) {
        this.colors = colors;
    }

    public ColorIdentity(String cardId, List<Color> colors) {
        this.cardId = cardId;
        this.colors = colors;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ColorIdentity that = (ColorIdentity) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, colors);
    }

    @Override
    public String toString() {
        return "{" +
                "\"cardId\":" + "\"" + cardId + "\"" +
                ", \"colors\":" + colors +
                '}';
    }
}
