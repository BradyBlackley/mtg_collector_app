package com.example.mtg.service.result;

public enum ResultType {
    SUCCESS("success"),
    INVALID("invalid"),
    NOT_FOUND("not_found");

    public final String label;

    private ResultType(String label) {
        this.label = label;
    }
}
