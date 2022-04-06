package com.example.mtg.model;

import java.util.List;

public class ColorIdentity {

    private int colorIdentityId;
    private Card card;
    private List<Color> colors;


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
}
