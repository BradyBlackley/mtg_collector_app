package com.example.mtg.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void constructorTests() {
        User user = new User();
        User user1 = new User("5d209ac0-9102-11ec-b909-0242ac120002");
        User user2 = new User("5d209ac0-9102-11ec-b909-0242ac120002", "TimTheMagicMan");
        User user3 = new User("5d209ac0-9102-11ec-b909-0242ac120002", "TimTheMagicMan",
                "d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
        User user4 = new User("5d209ac0-9102-11ec-b909-0242ac120002", "TimTheMagicMan",
                "d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca", true);
        User user5 = new User(user4);

        assertNull(user.getUsername());

        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002", user1.getUserId());

        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002", user2.getUserId());
        assertEquals("TimTheMagicMan", user2.getUsername());

        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002", user3.getUserId());
        assertEquals("TimTheMagicMan", user3.getUsername());
        assertEquals("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca", user3.getPassword());

        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002", user4.getUserId());
        assertEquals("TimTheMagicMan", user4.getUsername());
        assertEquals("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca", user4.getPassword());
        assertTrue(user4.isAdmin());

        assertEquals(user4, user5);
        assertEquals(user4.getUserId(), user5.getUserId());
        assertEquals(user4.getUsername(), user5.getUsername());
        assertEquals(user4.getPassword(), user5.getPassword());
        assertEquals(user4.isAdmin(), user5.isAdmin());
    }

    @Test
    void setGetUserId() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");

        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002", user.getUserId());
    }

    @Test
    void setGetUsername() {
        User user = new User();
        user.setUsername("TimTheMagicMan");

        assertEquals("TimTheMagicMan", user.getUsername());
    }

    @Test
    void setGetPassword() {
        User user = new User();
        user.setPassword("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");

        assertEquals("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca", user.getPassword());
    }

    @Test
    void setIsAdmin() {
        User user = new User();
        user.setAdmin(true);

        assertTrue(user.isAdmin());
    }

    @Test
    void testEquals() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
        user.setAdmin(true);

        User user1 = new User();
        user1.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user1.setUsername("TimTheMagicMan");
        user1.setPassword("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
        user.setAdmin(true);

        User different = new User();
        different.setUserId("9a219974-9102-11ec-b909-0242ac120002");
        different.setUsername("H4rry_P0tter");
        different.setPassword("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
        user.setAdmin(false);

        assertNotEquals(user, different);
        assertEquals(user, user1);
    }

    @Test
    void testHashCode() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
        user.setAdmin(false);

        assertNotNull(user.hashCode());

    }

    @Test
    void testToString() {
        User user = new User();
        user.setUserId("5d209ac0-9102-11ec-b909-0242ac120002");
        user.setUsername("TimTheMagicMan");
        user.setPassword("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
        user.setAdmin(true);

        assertEquals("{\"userId\":\"5d209ac0-9102-11ec-b909-0242ac120002\", \"username\":\"TimTheMagicMan\"," +
                " \"isAdmin\":\"true\"}", user.toString());
    }
}