package com.example.mtg.service.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTypeTest {

    @Test
    void resultTypeLabel() {
        assertEquals("success", ResultType.SUCCESS.label);
        assertEquals("invalid", ResultType.INVALID.label);
        assertEquals("not found", ResultType.NOT_FOUND.label);
        assertEquals("error", ResultType.ERROR.label);
    }

}