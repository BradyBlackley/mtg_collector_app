package com.example.mtg.model;

import java.util.List;

public class CardToLibrary {

    private int cardToLibrary;
    private List<CardCopy> cardCopies;
    private Library library;


    public CardToLibrary(int cardToLibrary, List<CardCopy> cardCopies, Library library) {
        this.cardToLibrary = cardToLibrary;
        this.cardCopies = cardCopies;
        this.library = library;
    }

    public int getCardToLibrary() {
        return cardToLibrary;
    }

    public void setCardToLibrary(int cardToLibrary) {
        this.cardToLibrary = cardToLibrary;
    }

    public List<CardCopy> getCardCopies() {
        return cardCopies;
    }

    public void setCardCopies(List<CardCopy> cardCopies) {
        this.cardCopies = cardCopies;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
