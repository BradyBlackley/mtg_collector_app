package com.example.mtg.model;

import java.util.List;
import java.util.Objects;

public class CardToLibrary {

    private int cardToLibraryId;
    private List<CardCopy> cardCopies;
    private Library library;

    public CardToLibrary() {

    }

    public CardToLibrary(int cardToLibraryId) {
        this.cardToLibraryId = cardToLibraryId;
    }

    public CardToLibrary(int cardToLibraryId, List<CardCopy> cardCopies) {
        this.cardToLibraryId = cardToLibraryId;
        this.cardCopies = cardCopies;
    }

    public CardToLibrary(int cardToLibraryId, List<CardCopy> cardCopies, Library library) {
        this.cardToLibraryId = cardToLibraryId;
        this.cardCopies = cardCopies;
        this.library = library;
    }

    public int getCardToLibraryId() {
        return cardToLibraryId;
    }

    public void setCardToLibraryId(int cardToLibraryId) {
        this.cardToLibraryId = cardToLibraryId;
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
        return cardToLibraryId == that.cardToLibraryId && cardCopies.equals(that.cardCopies) && library.equals(that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardToLibraryId, cardCopies, library);
    }

    @Override
    public String toString() {
        return "CardToLibrary{" +
                "cardToLibrary=" + cardToLibraryId +
                ", cardCopies=" + cardCopies +
                ", library=" + library +
                '}';
    }
}
