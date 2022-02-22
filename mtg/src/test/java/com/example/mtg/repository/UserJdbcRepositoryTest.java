package com.example.mtg.repository;

import com.example.mtg.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"classpath:data/User.sql"})
@ContextConfiguration(
        classes = {UserJdbcRepository.class}
)
class UserJdbcRepositoryTest extends CommonRepoTest {

    @Autowired
    UserJdbcRepository repository;

    @Test
    void findAll() {
        assertEquals(repository.findAll().size(), 2);
    }

    @Test
    void findByUsername() {
        assertNotNull(repository.findByUsername("TimTheMagicMan"));
        assertEquals(repository.findByUsername("TimTheMagicMan").getUsername(),
                "TimTheMagicMan");
        assertEquals(repository.findByUsername("TimTheMagicMan").getUserId(),
                "5d209ac0-9102-11ec-b909-0242ac120002");
        assertEquals(repository.findByUsername("TimTheMagicMan").getPassword(),
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
    }

    @Test
    void findById() {
        assertNull(repository.findById("notarealid123"));
        assertNotNull(repository.findById("9a219974-9102-11ec-b909-0242ac120002"));
        assertEquals(repository.findById("9a219974-9102-11ec-b909-0242ac120002").getUsername(),
                "Bobby_LovesPI532");
        assertEquals(repository.findById("9a219974-9102-11ec-b909-0242ac120002").getPassword(),
                "d55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca");
    }

    @Test
    void add() {
        assertNotNull(repository.add(makeUser()));
        assertEquals(repository.findAll().size(), 3);
        assertNotNull(repository.findByUsername("H4rry_P0tter"));
        assertEquals(repository.findByUsername("H4rry_P0tter").getPassword(),
                "5f8912b2d920b8e6a4b758de25684ea63ac93c6bf576b41e977298d1c98320bc");
    }

    @Test
    void update() {
        User user = repository.findById("9a219974-9102-11ec-b909-0242ac120002");
        user.setUsername("Bobby_LovesPIZZA532");
        assertTrue(repository.update(user));
        assertNotNull(repository.findByUsername("Bobby_LovesPIZZA532"));
        assertEquals(repository.findById("9a219974-9102-11ec-b909-0242ac120002").getUsername(),
                "Bobby_LovesPIZZA532");
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