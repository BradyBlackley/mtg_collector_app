package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.User;
import com.example.mtg.repository.CommonRepoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:schema-h2.sql", "classpath:data/User.sql"})
class UserJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    UserJdbcRepository repository;

    @Test
    void findAll() {
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void findByUsername() {
        assertNotNull(repository.findByUsername("TimTheMagicMan"));
        assertEquals("TimTheMagicMan",
                repository.findByUsername("TimTheMagicMan").getUsername());
        assertEquals("5d209ac0-9102-11ec-b909-0242ac120002",
                repository.findByUsername("TimTheMagicMan").getUserId());
        assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                repository.findByUsername("TimTheMagicMan").getPassword());
    }

    @Test
    void findById() {
        assertNull(repository.findById("notarealid123"));
        assertNotNull(repository.findById("9a219974-9102-11ec-b909-0242ac120002"));
        assertEquals("Bobby_LovesPI532", repository.findById("9a219974-9102-11ec-b909-0242ac120002").getUsername());
        assertEquals("d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca",
                repository.findById("9a219974-9102-11ec-b909-0242ac120002").getPassword());
    }

    @Test
    void add() {
        assertNotNull(repository.add(makeUser()));
        assertEquals(3, repository.findAll().size());
        assertNotNull(repository.findByUsername("H4rry_P0tter"));
        assertEquals("-758576035",
                repository.findByUsername("H4rry_P0tter").getPassword());
    }

    @Test
    void update() {
        User user = repository.findById("9a219974-9102-11ec-b909-0242ac120002");
        user.setUsername("Bobby_LovesPIZZA532");
        assertTrue(repository.update(user));
        assertNotNull(repository.findByUsername("Bobby_LovesPIZZA532"));
        assertEquals("Bobby_LovesPIZZA532", repository.findById("9a219974-9102-11ec-b909-0242ac120002").getUsername());
    }

    @Test
    void deleteById() {
        assertFalse(repository.deleteById("notarealid123"));
        assertTrue(repository.deleteById("5d209ac0-9102-11ec-b909-0242ac120002"));
        assertNull(repository.findById("5d209ac0-9102-11ec-b909-0242ac120002"));
        assertEquals(repository.findAll().size(), 1);
    }

    private User makeUser() {
        return new User("",
                "H4rry_P0tter",
                "5f8912b2d920b8e6a4b758de25684ea63ac93c6bf576b41e977298d1c98320bc");
    }
}