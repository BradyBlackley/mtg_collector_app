package com.example.mtg.model;

import java.util.Objects;

public class Color {

    private int colorId;
    private String colorName;

    public Color() {

    }

    public Color(int colorId) {
        this.colorId = colorId;
    }

    public Color(String colorName) {
        this.colorName = colorName;
    }

    public Color(int colorId, String colorName) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return colorId == color.colorId && colorName.equals(color.colorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, colorName);
    }

    @Override
    public String toString() {
        return "{" +
                "\"colorId\":" + colorId +
                ", \"colorName\":\"" + colorName + '\"' +
                '}';
    }
}
