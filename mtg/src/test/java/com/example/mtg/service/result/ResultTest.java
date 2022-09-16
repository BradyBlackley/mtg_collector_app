package com.example.mtg.service.result;

import com.example.mtg.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class ResultTest {

    @Test
    void setAndGetResultMessages() {

        Result result = new Result();
        result.addMessage("success", ResultType.SUCCESS);
        result.addMessage("Username must be greater than 3 characters and less than 16 characters",
                ResultType.INVALID);
        result.addMessage("User with username Johnson not found", ResultType.NOT_FOUND);
        result.addMessage("Error: failed to insert record", ResultType.ERROR);

        assertEquals("success", result.getMessages().get(0));
        assertEquals("Username must be greater than 3 characters and less than 16 characters",
                result.getMessages().get(1));
        assertEquals("User with username Johnson not found",
                result.getMessages().get(2));
        assertEquals("Error: failed to insert record",
                result.getMessages().get(3));
    }

    @Test
    void setAndGetResultResultType() {
        Result result = new Result();
        result.addMessage("success", ResultType.SUCCESS);

        assertEquals(ResultType.SUCCESS, result.getType());

        Result result1 = new Result();
        result1.addMessage("Username must be greater than 3 characters and less than 16 characters",
                ResultType.INVALID);

        assertEquals(ResultType.INVALID, result1.getType());

        Result result2 = new Result();
        result2.addMessage("User with username Johnson not found", ResultType.NOT_FOUND);

        assertEquals(ResultType.NOT_FOUND, result2.getType());

        Result result3 = new Result();
        result3.addMessage("Error: failed to insert record", ResultType.ERROR);

        assertEquals(ResultType.ERROR, result3.getType());
    }

    @Test
    void setAndGetResultPayload() {
        User user = new User();
        user.setUserId("bfb757c4-18ec-11ed-861d-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("IlovetoP00p!");

        Result<User> result = new Result<>();
        result.setPayload(user);

        assertEquals(user, result.getPayload());
    }

}