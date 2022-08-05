package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class CardCopyToLibrary {
    private List<CardCopy> cardCopies;
    private Library library;
    public CardCopyToLibrary() {

    }

    public CardCopyToLibrary(List<CardCopy> cardCopies) {
        this.cardCopies = cardCopies;
    }

    public CardCopyToLibrary(List<CardCopy> cardCopies, Library library) {
        this.cardCopies = cardCopies;
        this.library = library;
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
        CardCopyToLibrary that = (CardCopyToLibrary) o;
        return cardCopies.equals(that.cardCopies) && library.equals(that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardCopies, library);
    }

    @Override
    public String toString() {
        return "CardCopyToLibrary{" +
                "cardCopies=" + cardCopies + '\'' +
                ", library=" + library + '\'' +
                '}';
    }
}
