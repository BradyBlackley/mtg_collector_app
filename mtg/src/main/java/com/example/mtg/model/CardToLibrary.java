package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class CardToLibrary {

    private int cardToLibrary;
    private List<CardCopy> cardCopies;
    private Library library;

    public CardToLibrary() {

    }

    public CardToLibrary(int cardToLibrary) {
        this.cardToLibrary = cardToLibrary;
    }

    public CardToLibrary(int cardToLibrary, List<CardCopy> cardCopies) {
        this.cardToLibrary = cardToLibrary;
        this.cardCopies = cardCopies;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardToLibrary that = (CardToLibrary) o;
        return cardToLibrary == that.cardToLibrary && cardCopies.equals(that.cardCopies) && library.equals(that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardToLibrary, cardCopies, library);
    }

    @Override
    public String toString() {
        return "CardToLibrary{" +
                "cardToLibrary=" + cardToLibrary +
                ", cardCopies=" + cardCopies +
                ", library=" + library +
                '}';
    }
}
