package com.example.mtg.model;

public class Card {
    private String cardId;
    private String cardName;
    private String imagePath;
    private Rarity rarity;
    private String artistName;
    private String convertedManaCost;
    private String power;
    private String toughness;
    private Expansion expansion;
    private String textBox;

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName,
                String convertedManaCost, String power, String toughness, Expansion expansion, String textBox) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.artistName = artistName;
        this.convertedManaCost = convertedManaCost;
        this.power = power;
        this.toughness = toughness;
        this.expansion = expansion;
        this.textBox = textBox;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getConvertedManaCost() {
        return convertedManaCost;
    }

    public void setConvertedManaCost(String convertedManaCost) {
        this.convertedManaCost = convertedManaCost;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public String getTextBox() {
        return textBox;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }
}
