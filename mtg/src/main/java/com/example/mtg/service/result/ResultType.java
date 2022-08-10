package com.example.mtg.service.result;

public enum ResultType {
    SUCCESS("success"),
    INVALID("invalid"),
    NOT_FOUND("not found"),
    ERROR("error");

    public final String label;

    private ResultType(String label) {
        this.label = label;
    }
}
