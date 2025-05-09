package com.example.mtg.service;

import com.example.mtg.model.Library;
import com.example.mtg.model.User;
import com.example.mtg.repository.repositoryInterfaces.LibraryRepository;
import com.example.mtg.service.result.Result;
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
class LibraryServiceTest {

    @InjectMocks
    private LibraryService service;

    @Mock
    private LibraryRepository repository;
    @Mock
    private UserService userService;

    public User validUser = new User("bfb757c4-18ec-11ed-861d-0242ac120002", "TimTheMagicMan",
            "IlovetoP00p!");

    public Library validLibrary = new Library(1, "Dragons", validUser.getUserId());

    public Library anotherValidLibrary = new Library(2, "Zombies", validUser.getUserId());

    public Library invalidLibraryName = new Library(3, "Money$", validUser.getUserId());

    public Library invalidLibraryTooLong = new Library(4, "ThisIsTooLongOfALibraryName12345", validUser.getUserId());

    public Library invalidLibraryTooShort = new Library(5, "A", validUser.getUserId());

    public Result<User> getValidUserResult() {
        Result<User> userResult = new Result<>();
        userResult.setPayload(validUser);
        userResult.addMessage("success", ResultType.SUCCESS);
        return userResult;
    }

    @Test
    void findAllLibrariesByUser() {
        Library library = new Library(1, "Zombies", validUser.getUserId());
        Library library1 = new Library(2, "Overgrowth", validUser.getUserId());
        List<Library> libraries = new ArrayList<>();
        libraries.add(library);
        libraries.add(library1);

        Mockito.when(repository.findAllLibrariesByUser(validUser.getUserId())).thenReturn(libraries);

        assertTrue(service.findAllLibrariesByUser(validUser.getUserId()).isSuccess());
        assertEquals("success", service.findAllLibrariesByUser(validUser.getUserId()).getMessages().get(0));
    }

    @Test
    void findAllLibrariesByUserNoLibrariesFound() {
        List<Library> libraries = new ArrayList<>();

        Mockito.when(repository.findAllLibrariesByUser(validUser.getUserId())).thenReturn(libraries);

        assertFalse(service.findAllLibrariesByUser(validUser.getUserId()).isSuccess());
        assertEquals("No libraries found by given user " + validUser.getUserId(),
                service.findAllLibrariesByUser(validUser.getUserId()).getMessages().get(0));
    }

    @Test
    void findLibraryByName() {
        Library library = new Library(1, "Zombies", validUser.getUserId());

        Mockito.when(repository.findLibraryByName("Zombies", validUser.getUserId())).thenReturn(library);

        assertTrue(service.findLibraryByName("Zombies", validUser.getUserId()).isSuccess());
        assertEquals("success", service.findLibraryByName("Zombies",
                validUser.getUserId()).getMessages().get(0));
    }

    @Test
    void findLibraryByNameNoLibraryFound() {
        Mockito.when(repository.findLibraryByName("Zombies", validUser.getUserId())).thenReturn(null);

        assertFalse(service.findLibraryByName("Zombies", validUser.getUserId()).isSuccess());
        assertEquals("No library found by given name " + "Zombies" + " and user " + validUser.getUserId(),
                service.findLibraryByName("Zombies",
                validUser.getUserId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(userService.findById(validUser.getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.add(validLibrary)).thenReturn(validLibrary);

        Result<Library> result = service.add(validLibrary);

        assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void addInvalidCharacterLibraryName() {
        Mockito.when(userService.findById(validUser.getUserId())).thenReturn(getValidUserResult());
        Result<Library> result = service.add(invalidLibraryName);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + invalidLibraryName.getLibraryName() +
                " is invalid. Library names must be between 2 to 25 characters and may only contain alphanumeric" +
                " characters and spaces", result.getMessages().get(0));
    }

    @Test
    void addInvalidLibraryNameTooLong() {
        Mockito.when(userService.findById(validUser.getUserId())).thenReturn(getValidUserResult());
        Result<Library> result = service.add(invalidLibraryTooLong);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + invalidLibraryTooLong.getLibraryName() +
                " is invalid. Library names must be between 2 to 25 characters and may only contain alphanumeric" +
                " characters and spaces", result.getMessages().get(0));
    }

    @Test
    void addInvalidLibraryNameTooShort() {
        Mockito.when(userService.findById(validUser.getUserId())).thenReturn(getValidUserResult());
        Result<Library> result = service.add(invalidLibraryTooShort);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + invalidLibraryTooShort.getLibraryName() +
                " is invalid. Library names must be between 2 to 25 characters and may only contain alphanumeric" +
                " characters and spaces", result.getMessages().get(0));
    }

    @Test
    void addLibraryNameAlreadyInUse() {
        Mockito.when(userService.findById(validUser.getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(validLibrary);

        Result<Library> result = service.add(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + validLibrary.getLibraryName() + " is already in use",
                result.getMessages().get(0));
    }

    @Test
    void addLibraryUserNotFound() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(null);
        Mockito.when(userService.findById(validLibrary.getUserId())).thenReturn(null);

        Result<Library> result = service.add(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("The provided userId " + validLibrary.getUserId() + " associated with the provided library is "
                + ResultType.NOT_FOUND.label, result.getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(null);
        Mockito.when(repository.update(validLibrary)).thenReturn(true);

        Result<Boolean> result = service.update(validLibrary);

        assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void updateInvalidCharacterLibraryName() {
        Result<Boolean> result = service.update(invalidLibraryName);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + invalidLibraryName.getLibraryName() +
                " is invalid. Library names must be between 2 to 25 characters and may only contain alphanumeric" +
                " characters and spaces", result.getMessages().get(0));
    }

    @Test
    void updateLibraryNameAlreadyInUse() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(anotherValidLibrary);

        Result<Boolean> result = service.update(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + validLibrary.getLibraryName() + " is already in use",
                result.getMessages().get(0));
    }

    @Test
    void updateLibraryFailed() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(validLibrary);
        Mockito.when(repository.update(validLibrary)).thenReturn(false);

        Result<Boolean> result = service.update(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("Failed to update library " + validLibrary.getLibraryId() + " associated with user "
                + validLibrary.getUserId(), result.getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(userService.findById(validLibrary.getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.delete(validLibrary)).thenReturn(true);
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(validLibrary);

        Result<Boolean> result = service.delete(validLibrary);

        //assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void deleteInvalidLibraryName() {
        Result<Boolean> result = service.delete(invalidLibraryName);

        assertFalse(result.isSuccess());
        assertEquals("The provided library name " + invalidLibraryName.getLibraryName() +
                " is invalid. Library names must be between 2 to 25 characters and may only contain alphanumeric" +
                " characters and spaces", result.getMessages().get(0));
    }

    @Test
    void deleteLibraryNotFound() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(null);

        Result<Boolean> result = service.delete(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("The provided library " + validLibrary.getLibraryName() + " is " + ResultType.NOT_FOUND.label,
                result.getMessages().get(0));
    }

    @Test
    void deleteLibraryUserNotFound() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(validLibrary);
        Mockito.when(userService.findById(validLibrary.getUserId())).thenReturn(null);

        Result<Boolean> result = service.delete(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("User " + validLibrary.getUserId() + " associated with the provided library is "
                        + ResultType.NOT_FOUND.label,
                result.getMessages().get(0));
    }

    @Test
    void deleteLibraryFailed() {
        Mockito.when(repository.findLibraryByName(validLibrary.getLibraryName(),
                validLibrary.getUserId())).thenReturn(validLibrary);
        Mockito.when(userService.findById(validLibrary.getUserId())).thenReturn(getValidUserResult());
        Mockito.when(repository.delete(validLibrary)).thenReturn(false);

        Result<Boolean> result = service.delete(validLibrary);

        assertFalse(result.isSuccess());
        assertEquals("Failed to delete provided library " + validLibrary.getLibraryId() + " "
                        + validLibrary.getLibraryName(), result.getMessages().get(0));
    }

    @Test
    void validateLibrary() {
        assertTrue(service.validateLibrary(validLibrary));
        assertFalse(service.validateLibrary(invalidLibraryTooLong));
        assertFalse(service.validateLibrary(invalidLibraryName));
        assertFalse(service.validateLibrary(invalidLibraryTooShort));
    }
}