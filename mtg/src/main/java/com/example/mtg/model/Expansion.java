package com.example.mtg.model;

import java.sql.Date;
import java.util.Objects;

public class Expansion {

    private int expansionId;
    private String expansionName;
    private String expansionCode;
    private Date releasedDate;

    public Expansion() {

    }

    public Expansion(int expansionId) {
        this.expansionId = expansionId;
    }

    public Expansion(int expansionId, String expansionName) {
        this.expansionId = expansionId;
        this.expansionName = expansionName;
    }


    public Expansion(int expansionId, String expansionName, String expansionCode) {
        this.expansionId = expansionId;
        this.expansionName = expansionName;
        this.expansionCode = expansionCode;
    }

    public Expansion(int expansionId, String expansionName, String expansionCode, Date releasedDate) {
        this.expansionId = expansionId;
        this.expansionName = expansionName;
        this.expansionCode = expansionCode;
        this.releasedDate = releasedDate;
    }

    public int getExpansionId() {
        return expansionId;
    }

    public void setExpansionId(int expansionId) {
        this.expansionId = expansionId;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public String getExpansionCode() {
        return expansionCode;
    }

    public void setExpansionCode(String expansionCode) {
        this.expansionCode = expansionCode;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expansion expansion = (Expansion) o;
        return expansionId == expansion.expansionId && expansionName.equals(expansion.expansionName) && expansionCode.equals(expansion.expansionCode) && releasedDate.equals(expansion.releasedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expansionId, expansionName, expansionCode, releasedDate);
    }

    @Override
    public String toString() {
        return "{" +
                "\"expansionId\":" + expansionId +
                ", \"expansionName\":\"" + expansionName + '\"' +
                ", \"expansionCode\":\"" + expansionCode + '\"' +
                ", \"releasedDate\":\"" + releasedDate + '\"' +
                '}';
    }
}
