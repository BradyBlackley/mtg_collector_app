package com.example.mtg.model;

public enum Rarity {
    COMMON("common"),
    UNCOMMON("uncommon"),
    RARE("rare"),
    MYTHIC("mythic");

    public final String label;

    Rarity(String label) {
        this.label = label;
    }
}
