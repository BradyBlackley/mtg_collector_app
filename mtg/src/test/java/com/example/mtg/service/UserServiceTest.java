package com.example.mtg.service;

import com.example.mtg.model.User;
import com.example.mtg.repository.jdbcRepositories.UserJdbcRepository;
import com.example.mtg.service.result.ResultType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserJdbcRepository repository;

    public User nullUser = null;

    public User validUser1 = new User("bfb757c4-18ec-11ed-861d-0242ac120002", "TimTheMagicMan",
            "IlovetoP00p!");

    public User validUser2 = new User("965db958-18ed-11ed-861d-0242ac120002", "Bob",
            "Money$M4n");

    public User invalidUserIdUser = new User("96958-18d-11easdfd-861d-0242ac", "BradyCrusader",
            "P@ssword123");

    public User invalidUsernameUser = new User("0baab61a-18ef-11ed-861d-0242ac120002", "Ty",
            "V4lidP@ssword^");

    public User invalidPasswordUser = new User("370993bc-18ef-11ed-861d-0242ac120002", "Johnny",
            "NoSpecialCharacters1");

    @Test
    void findAll() {
        List<User> users = new ArrayList<>();
        users.add(validUser1);
        users.add(validUser2);

        Mockito.when(repository.findAll()).thenReturn(users);

        assertTrue(service.findAll().isSuccess());
        assertEquals("success", service.findAll().getMessages().get(0));
    }

    @Test
    void findAllEmptyResults() {
        List<User> users = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(users);

        assertFalse(service.findAll().isSuccess());
        assertEquals("Error: users not found", service.findAll().getMessages().get(0));
    }

    @Test
    void findById() {
        Mockito.when(repository.findById("bfb757c4-18ec-11ed-861d-0242ac120002")).thenReturn(validUser1);

        assertTrue(service.findById("bfb757c4-18ec-11ed-861d-0242ac120002").isSuccess());
        assertEquals("success", service.findById("bfb757c4-18ec-11ed-861d-0242ac120002").getMessages().get(0));
    }

    @Test
    void findByIdInvalidUserId() {
        Mockito.when(repository.findById("96958-18d-11easdfd-861d-0242ac")).thenReturn(invalidUserIdUser);

        assertFalse(service.findById("96958-18d-11easdfd-861d-0242ac").isSuccess());
        assertEquals("The provided user id " + invalidUserIdUser.getUserId() + " is " + ResultType.INVALID.label,
                service.findById("96958-18d-11easdfd-861d-0242ac").getMessages().get(0));
    }

    @Test
    void findByIdNullUser() {
        String mockId = "b009b44c-18f7-11ed-861d-0242ac120002";
        Mockito.when(repository.findById(mockId)).thenReturn(nullUser);

        assertFalse(service.findById("b009b44c-18f7-11ed-861d-0242ac120002").isSuccess());
        assertEquals("User id " + mockId + " " + ResultType.NOT_FOUND.label,
                service.findById(mockId).getMessages().get(0));
    }

    @Test
    void findByUsername() {
        Mockito.when(repository.findByUsername("TimTheMagicMan")).thenReturn(validUser1);

        assertTrue(service.findByUsername("TimTheMagicMan").isSuccess());
        assertEquals("success", service.findByUsername("TimTheMagicMan").getMessages().get(0));
    }

    @Test
    void findByUsernameInvalidUsernameUser() {
        Mockito.when(repository.findByUsername("Ty")).thenReturn(invalidUsernameUser);

        assertFalse(service.findByUsername("Ty").isSuccess());
        assertEquals("The provided username " + invalidUsernameUser.getUsername() + " is "
                + ResultType.INVALID.label + ". Username must be greater than 3 characters and less than 16 characters",
                service.findByUsername("Ty").getMessages().get(0));
    }

    @Test
    void findByUsernameNullUser() {
        Mockito.when(repository.findByUsername("Johnson")).thenReturn(nullUser);

        assertFalse(service.findByUsername("Johnson").isSuccess());
        assertEquals("User with username " + "Johnson" + " " + ResultType.NOT_FOUND.label,
                service.findByUsername("Johnson").getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.add(validUser2)).thenReturn(validUser2);

        assertTrue(service.add(validUser2).isSuccess());
        assertEquals("success", service.add(validUser2).getMessages().get(0));
    }


    @Test
    void addInvalidUsernameUser() {
        assertFalse(service.add(invalidUsernameUser).isSuccess());
        assertEquals("The provided username " + invalidUsernameUser.getUsername() + " is " +
                ResultType.INVALID.label + ". Username must be greater than 3 characters and less than 16 characters",
                service.add(invalidUsernameUser).getMessages().get(0));
    }

    @Test
    void addInvalidPasswordUser() {
        assertFalse(service.add(invalidPasswordUser).isSuccess());
        assertEquals("The provided user password is " + ResultType.INVALID.label +
                        ". Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), and a " +
                        "minimum of 8 characters",
                service.add(invalidPasswordUser).getMessages().get(0));
    }

    @Test
    void addUserUsernameAlreadyExists() {
        Mockito.when(repository.findByUsername(validUser2.getUsername())).thenReturn(validUser2);

        assertFalse(service.add(validUser2).isSuccess());
        assertEquals("Username " + validUser2.getUsername() + " is already taken",
                service.add(validUser2).getMessages().get(0));
    }

    @Test
    void addUserUserIdAlreadyExists() {
        Mockito.when(repository.findByUsername(validUser2.getUsername())).thenReturn(null);
        Mockito.when(repository.findById(validUser2.getUserId())).thenReturn(validUser2);

        assertFalse(service.add(validUser2).isSuccess());
        assertEquals("User with id " + validUser2.getUserId() + " already exists",
                service.add(validUser2).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.findByUsername(validUser1.getUsername())).thenReturn(validUser1);
        Mockito.when(repository.update(validUser1)).thenReturn(true);

        assertTrue(service.update(validUser1).isSuccess());
        assertEquals("success", service.update(validUser1).getMessages().get(0));
    }

    @Test
    void updateUserInvalidUserId() {
        assertFalse(service.update(invalidUserIdUser).isSuccess());
        assertEquals("The provided user id " + invalidUserIdUser.getUserId() + " is " + ResultType.INVALID.label,
                service.update(invalidUserIdUser).getMessages().get(0));
    }

    @Test
    void updateUserInvalidUsername() {
        assertFalse(service.update(invalidUsernameUser).isSuccess());
        assertEquals("The provided username " + invalidUsernameUser.getUsername() + " is "
                        + ResultType.INVALID.label +
                        ". Username must be greater than 3 characters and less than 16 characters",
                service.update(invalidUsernameUser).getMessages().get(0));
    }

    @Test
    void updateUserInvalidUserPassword() {
        assertFalse(service.update(invalidPasswordUser).isSuccess());
        assertEquals("The provided user password is " + ResultType.INVALID.label +
                        ". Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), and a " +
                        "minimum of 8 characters",
                service.update(invalidPasswordUser).getMessages().get(0));
    }

    @Test
    void updateUserDoesNotExist() {
        assertFalse(service.update(validUser2).isSuccess());
        assertEquals("Provided user does not exist ",
                service.update(validUser2).getMessages().get(0));
    }

    @Test
    void updateUserFailedToUpdate() {
        Mockito.when(repository.findByUsername(validUser2.getUsername())).thenReturn(validUser2);
        Mockito.when(repository.update(validUser2)).thenReturn(false);

        assertFalse(service.update(validUser2).isSuccess());
        assertEquals("Failed to update provided user " + validUser2.getUserId() + " " + validUser2.getUsername(),
                service.update(validUser2).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(repository.findById(validUser1.getUserId())).thenReturn(validUser1);
        Mockito.when(repository.deleteById(validUser1.getUserId())).thenReturn(true);

        assertTrue(service.delete(validUser1.getUserId()).isSuccess());
        assertEquals("success", service.delete(validUser1.getUserId()).getMessages().get(0));
    }

    @Test
    void deleteInvalidUserId() {
        assertFalse(service.delete(invalidUserIdUser.getUserId()).isSuccess());
        assertEquals("The provided user id " + invalidUserIdUser.getUserId() + " is " + ResultType.INVALID.label,
                service.delete(invalidUserIdUser.getUserId()).getMessages().get(0));
    }

    @Test
    void deleteUserNotFound() {
        Mockito.when(repository.findById(validUser2.getUserId())).thenReturn(null);

        assertFalse(service.delete(validUser2.getUserId()).isSuccess());
        assertEquals("User with provided user id " + validUser2.getUserId() + " does not exist",
                service.delete(validUser2.getUserId()).getMessages().get(0));
    }

    @Test
    void deleteUserFailed() {
        Mockito.when(repository.findById(validUser2.getUserId())).thenReturn(validUser2);
        Mockito.when(repository.deleteById(validUser2.getUserId())).thenReturn(false);

        assertFalse(service.delete(validUser2.getUserId()).isSuccess());
        assertEquals("Failed to delete provided user " + validUser2.getUserId(),
                service.delete(validUser2.getUserId()).getMessages().get(0));
    }

    @Test
    void validateUser() {
        assertTrue(service.validateUser(validUser1));
        assertFalse(service.validateUser(invalidPasswordUser));
        assertFalse(service.validateUser(invalidUserIdUser));
        assertFalse(service.validateUser(invalidUsernameUser));
    }
}