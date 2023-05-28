package com.example.mtg.model;

import java.util.Objects;

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
    private Card backCard;

    public Card() {

    }

    public Card(String cardId) {
        this.cardId = cardId;
    }

    public Card(String cardId, String cardName) {
        this.cardId = cardId;
        this.cardName = cardName;
    }

    public Card(String cardId, String cardName, String imagePath) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
    }

    public Card(String cardId, String cardName, String imagePath, Rarity rarity) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
    }

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.artistName = artistName;
    }

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName,
                String convertedManaCost) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.artistName = artistName;
        this.convertedManaCost = convertedManaCost;
    }

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName,
                String convertedManaCost, String power) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.artistName = artistName;
        this.convertedManaCost = convertedManaCost;
        this.power = power;
    }

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName,
                String convertedManaCost, String power, String toughness) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.artistName = artistName;
        this.convertedManaCost = convertedManaCost;
        this.power = power;
        this.toughness = toughness;
    }

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName,
                String convertedManaCost, String power, String toughness, Expansion expansion) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.artistName = artistName;
        this.convertedManaCost = convertedManaCost;
        this.power = power;
        this.toughness = toughness;
        this.expansion = expansion;
    }

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

    public Card(String cardId, String cardName, String imagePath, Rarity rarity, String artistName,
                String convertedManaCost, String power, String toughness, Expansion expansion, String textBox, String backCardId) {
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
        this.backCard = backCard;
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

    public Card getBackCard() {
        return backCard;
    }

    public void setBackCard(Card backCard) {
        this.backCard = backCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardId.equals(card.cardId) && cardName.equals(card.cardName) && imagePath.equals(card.imagePath)
                && rarity == card.rarity && artistName.equals(card.artistName)
                && convertedManaCost.equals(card.convertedManaCost) && power.equals(card.power)
                && toughness.equals(card.toughness) && expansion.equals(card.expansion) && textBox.equals(card.textBox)
                && backCard.equals(card.backCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardName, imagePath, rarity, artistName, convertedManaCost, power, toughness,
                expansion, textBox, backCard);
    }

    @Override
    public String toString() {
        return "{" +
                "\"cardId\":\"" + cardId + '\"' +
                ", \"cardName\":\"" + cardName + '\"' +
                ", \"imagePath\":\"" + imagePath + '\"' +
                ", \"rarity\":\"" + rarity.label + '\"' +
                ", \"artistName\":\"" + artistName + '\"' +
                ", \"convertedManaCost\":\"" + convertedManaCost + '\"' +
                ", \"power\":\"" + power + '\"' +
                ", \"toughness\":\"" + toughness + '\"' +
                ", \"expansion\":" + expansion +
                ", \"textBox\":\"" + textBox + '\"' +
                ", \"backCard\":\"" + backCard + '\"' +
                '}';
    }
}
