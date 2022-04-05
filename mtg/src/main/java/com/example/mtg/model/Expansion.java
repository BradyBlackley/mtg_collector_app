package com.example.mtg.model;

import java.util.Date;

public class Expansion {

    private int expansionId;
    private String expansionName;
    private String expansionCode;
    private Date releasedDate;

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
}
