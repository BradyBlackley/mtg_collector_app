package com.example.mtg.model;

import java.util.Objects;

public class Type {

    private int typeId;
    private String typeName;

    public Type() {

    }

    public Type(int typeId) {
        this.typeId = typeId;
    }

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public Type(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return typeId == type.typeId && Objects.equals(typeName, type.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName);
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
