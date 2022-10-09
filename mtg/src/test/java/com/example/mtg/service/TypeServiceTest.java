package com.example.mtg.service;

import com.example.mtg.model.Type;
import com.example.mtg.repository.jdbcRepositories.TypeJdbcRepository;
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
public class TypeServiceTest {

    @InjectMocks
    private TypeService service;

    @Mock
    private TypeJdbcRepository repository;

    public Type validType = new Type(1, "Creature");

    public Type validType1 = new Type(2, "Land");

    public Type validType2 = new Type(3, "Legendary");

    public Type invalidTypeName = new Type(4, "NotV@lid!");

    @Test
    void findAllTypes() {
        List<Type> types = new ArrayList<>();
        types.add(validType);
        types.add(validType1);
        types.add(validType2);

        Mockito.when(repository.findAllTypes()).thenReturn(types);

        assertTrue(service.findAllTypes().isSuccess());
        assertEquals("success", service.findAllTypes().getMessages().get(0));
    }

    @Test
    void findAllTypesNoneFound() {
        List<Type> types = new ArrayList<>();

        Mockito.when(repository.findAllTypes()).thenReturn(types);

        assertFalse(service.findAllTypes().isSuccess());
        assertEquals("No types found", service.findAllTypes().getMessages().get(0));
    }

    @Test
    void findTypeByName() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(validType);

        assertTrue(service.findTypeByName(validType.getTypeName()).isSuccess());
        assertEquals("success", service.findTypeByName(validType.getTypeName()).getMessages().get(0));
    }

    @Test
    void findTypeByNameNotFound() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(null);

        assertFalse(service.findTypeByName(validType.getTypeName()).isSuccess());
        assertEquals("No type found by given name " + validType.getTypeName(),
                service.findTypeByName(validType.getTypeName()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(null);
        Mockito.when(repository.add(validType)).thenReturn(validType);

        assertTrue(service.add(validType).isSuccess());
        assertEquals("success", service.add(validType).getMessages().get(0));
    }

    @Test
    void addInvalidTypeName() {
        Mockito.when(repository.add(invalidTypeName)).thenReturn(invalidTypeName);

        assertFalse(service.add(invalidTypeName).isSuccess());
        assertEquals("The provided type name " + invalidTypeName.getTypeName() + " is " +
                ResultType.INVALID.label, service.add(invalidTypeName).getMessages().get(0));
    }

    @Test
    void addTypeNameAlreadyInUse() {
        Mockito.when(repository.add(validType)).thenReturn(validType);
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(validType);

        assertFalse(service.add(validType).isSuccess());
        assertEquals("The provided type name " + validType.getTypeName() + " is already in use",
                service.add(validType).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(validType);

        Result<Boolean> result = service.update(validType);

        assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void updateInvalidTypeName() {
        assertFalse(service.update(invalidTypeName).isSuccess());
        assertEquals("The provided type name " + invalidTypeName.getTypeName() + " is " + ResultType.INVALID.label,
                service.update(invalidTypeName).getMessages().get(0));
    }

    @Test
    void updateTypeNameNotFound() {
        assertFalse(service.update(validType).isSuccess());
        assertEquals("The provided type " + validType.getTypeName() + " is not found",
                service.update(validType).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(validType);
        Mockito.when(repository.delete(validType)).thenReturn(true);
        Result<Boolean> result = service.delete(validType);

        assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void deleteInvalidTypeName() {
        Result<Boolean> result = service.delete(invalidTypeName);

        assertFalse(result.isSuccess());
        assertEquals("The provided type name " + invalidTypeName.getTypeName() + " is "
                + ResultType.INVALID.label, result.getMessages().get(0));
    }

    @Test
    void deleteTypeNameNotFound() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(null);
        Result<Boolean> result = service.delete(validType);

        assertFalse(result.isSuccess());
        assertEquals("The provided type " + validType.getTypeName() + " is not found",
                result.getMessages().get(0));
    }

    @Test
    void deleteTypeFailed() {
        Mockito.when(repository.findTypeByName(validType.getTypeName())).thenReturn(validType);
        Mockito.when(repository.delete(validType)).thenReturn(false);
        Result<Boolean> result = service.delete(validType);

        assertFalse(result.isSuccess());
        assertEquals("Failed to delete given type " + validType.getTypeName(),
                result.getMessages().get(0));
    }

    @Test
    void validateType() {
        assertTrue(service.validateType(validType));
        assertFalse(service.validateType(invalidTypeName));
    }
}
