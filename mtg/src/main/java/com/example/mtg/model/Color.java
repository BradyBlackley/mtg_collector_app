package com.example.mtg.model;

public enum Color {
    COLORLESS(1,"colorless"),
    WHITE(2,"white"),
    BLUE(3,"blue"),
    BLACK(4,"black"),
    RED(5,"red"),
    GREEN(6,"green");

    public final String label;
    public final int id;

    Color(int id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public String toString() {

        return "{" +
                "\"colorId\":" + id + "" +
                ", \"colorName\":\"" + label + "\"" +
                '}';
    }
}