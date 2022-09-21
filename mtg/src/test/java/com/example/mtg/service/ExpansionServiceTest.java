package com.example.mtg.service;

import com.example.mtg.model.Expansion;
import com.example.mtg.repository.jdbcRepositories.ExpansionJdbcRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExpansionServiceTest {

    @InjectMocks
    ExpansionService service;

    @Mock
    ExpansionJdbcRepository repository;

    public Expansion validExpansion = new Expansion(1, "Streets of New Capenna",
            "SNC", Date.valueOf("2022-04-22"));

    public Expansion invalidNameExpansion = new Expansion(2, "Kamigaw@: Neon Dynasty",
            "NEO", Date.valueOf("2022-02-11"));

    public Expansion invalidCodeExpansion = new Expansion(3, "Kamigawa: Neon Dynasty",
            "NEON", Date.valueOf("2022-02-11"));

    public Expansion invalidReleasedDateExpansion = new Expansion(4, "Kamigawa: Neon Dynasty",
            "NEO", Date.valueOf("1992-01-01"));

    public Expansion validExpansion1 = new Expansion(5, "Innistrad: Crimson Vow",
            "VOW", Date.valueOf("2021-11-11"));

    public List<Expansion> getExpansionList() {

        List<Expansion> expansionList = new ArrayList<>();
        expansionList.add(validExpansion);
        expansionList.add(validExpansion1);

        return expansionList;
    }

    @Test
    void findAllExpansions() {
        Mockito.when(repository.findAllExpansions()).thenReturn(getExpansionList());
        assertTrue(service.findAllExpansions().isSuccess());
        assertEquals("success", service.findAllExpansions().getMessages().get(0));

    }

    @Test
    void findAllNoExpansionsFound() {
        Mockito.when(repository.findAllExpansions()).thenReturn(null);
        assertFalse(service.findAllExpansions().isSuccess());
        assertEquals("No expansions found", service.findAllExpansions().getMessages().get(0));

    }

    @Test
    void findExpansionById() {
        Mockito.when(repository.findExpansionById(validExpansion.getExpansionId())).thenReturn(validExpansion);
        assertTrue(service.findExpansionById(validExpansion.getExpansionId()).isSuccess());
        assertEquals("success",
                service.findExpansionById(validExpansion.getExpansionId()).getMessages().get(0));
    }

    @Test
    void findExpansionByIdNotFound() {
        Mockito.when(repository.findExpansionById(validExpansion.getExpansionId())).thenReturn(null);
        assertFalse(service.findExpansionById(validExpansion.getExpansionId()).isSuccess());
        assertEquals("No expansion found by given id " + validExpansion.getExpansionId(),
                service.findExpansionById(validExpansion.getExpansionId()).getMessages().get(0));
    }

    @Test
    void findExpansionByName() {
        Mockito.when(repository.findExpansionByName(validExpansion.getExpansionName())).thenReturn(validExpansion);
        assertTrue(service.findExpansionByName(validExpansion.getExpansionName()).isSuccess());
        assertEquals("success",
                service.findExpansionByName(validExpansion.getExpansionName()).getMessages().get(0));
    }

    @Test
    void findExpansionByNameNotFound() {
        Mockito.when(repository.findExpansionByName(validExpansion.getExpansionName())).thenReturn(null);
        assertFalse(service.findExpansionByName(validExpansion.getExpansionName()).isSuccess());
        assertEquals("No expansion found by given name " + validExpansion.getExpansionName(),
                service.findExpansionByName(validExpansion.getExpansionName()).getMessages().get(0));
    }

    @Test
    void findExpansionByCode() {
        Mockito.when(repository.findExpansionByCode(validExpansion.getExpansionCode())).thenReturn(validExpansion);
        assertTrue(service.findExpansionByCode(validExpansion.getExpansionCode()).isSuccess());
        assertEquals("success",
                service.findExpansionByCode(validExpansion.getExpansionCode()).getMessages().get(0));
    }

    @Test
    void findExpansionByCodeNotFound() {
        Mockito.when(repository.findExpansionByCode(validExpansion.getExpansionCode())).thenReturn(null);
        assertFalse(service.findExpansionByCode(validExpansion.getExpansionCode()).isSuccess());
        assertEquals("No expansion found by given code " + validExpansion.getExpansionCode(),
                service.findExpansionByCode(validExpansion.getExpansionCode()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.findExpansionByName(validExpansion.getExpansionName())).thenReturn(null);
        Mockito.when(repository.findExpansionByCode(validExpansion.getExpansionCode())).thenReturn(null);
        Mockito.when(repository.add(validExpansion)).thenReturn(validExpansion);

        assertTrue(service.add(validExpansion).isSuccess());
        assertEquals("success", service.add(validExpansion).getMessages().get(0));
    }

    @Test
    void addInvalidExpansionName() {
        assertFalse(service.add(invalidNameExpansion).isSuccess());
        assertEquals("The given expansion name " + invalidNameExpansion.getExpansionName() + " is invalid",
                service.add(invalidNameExpansion).getMessages().get(0));
    }

    @Test
    void addExpansionNameAlreadyInUse() {
        Mockito.when(repository.findExpansionByName(validExpansion.getExpansionName())).thenReturn(validExpansion);

        assertFalse(service.add(validExpansion).isSuccess());
        assertEquals("The given expansion name " + validExpansion.getExpansionName() + " is already in use",
                service.add(validExpansion).getMessages().get(0));
    }

    @Test
    void addInvalidExpansionCode() {
        Mockito.when(repository.findExpansionByName(invalidCodeExpansion.getExpansionName())).thenReturn(null);

        assertFalse(service.add(invalidCodeExpansion).isSuccess());
        assertEquals("The given expansion code " + invalidCodeExpansion.getExpansionCode() + " is invalid",
                service.add(invalidCodeExpansion).getMessages().get(0));
    }

    @Test
    void addExpansionCodeAlreadyInUse() {
        Mockito.when(repository.findExpansionByName(validExpansion.getExpansionName())).thenReturn(null);
        Mockito.when(repository.findExpansionByCode(validExpansion.getExpansionCode())).thenReturn(validExpansion);

        assertFalse(service.add(validExpansion).isSuccess());
        assertEquals("The given expansion code " + validExpansion.getExpansionCode() + " is already in use",
                service.add(validExpansion).getMessages().get(0));
    }

    @Test
    void addInvalidExpansionReleasedDate() {
        Mockito.when(repository.findExpansionByName(invalidReleasedDateExpansion.getExpansionName())).thenReturn(null);
        Mockito.when(repository.findExpansionByCode(invalidReleasedDateExpansion.getExpansionCode())).thenReturn(null);

        assertFalse(service.add(invalidReleasedDateExpansion).isSuccess());
        assertEquals("The given expansion release date " + invalidReleasedDateExpansion.getReleasedDate() +
                        " is invalid", service.add(invalidReleasedDateExpansion).getMessages().get(0));
    }

    @Test
    void addExpansionFailed() {
        Mockito.when(repository.findExpansionByName(validExpansion.getExpansionName())).thenReturn(null);
        Mockito.when(repository.findExpansionByCode(validExpansion.getExpansionCode())).thenReturn(null);

        assertFalse(service.add(validExpansion).isSuccess());
        assertEquals("Failed to add given expansion " + validExpansion,
                service.add(validExpansion).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.update(validExpansion)).thenReturn(true);
        Mockito.when(repository.update(validExpansion)).thenReturn(true);

        assertTrue(service.update(validExpansion).isSuccess());
        assertEquals("success", service.update(validExpansion).getMessages().get(0));
    }

    @Test
    void updateInvalidExpansionName() {
        assertFalse(service.update(invalidNameExpansion).isSuccess());
        assertEquals("The given expansion name " + invalidNameExpansion.getExpansionName() + " is invalid",
                service.update(invalidNameExpansion).getMessages().get(0));
    }

    @Test
    void updateInvalidExpansionCode() {
        assertFalse(service.update(invalidCodeExpansion).isSuccess());
        assertEquals("The given expansion code " + invalidCodeExpansion.getExpansionCode() + " is invalid",
                service.update(invalidCodeExpansion).getMessages().get(0));
    }

    @Test
    void updateInvalidExpansionReleasedDate() {
        assertFalse(service.update(invalidReleasedDateExpansion).isSuccess());
        assertEquals("The given expansion release date " + invalidReleasedDateExpansion.getReleasedDate()
                        + " is invalid", service.update(invalidReleasedDateExpansion).getMessages().get(0));
    }

    @Test
    void updateExpansionFailed() {
        Mockito.when(repository.update(validExpansion)).thenReturn(false);
        assertFalse(service.update(validExpansion).isSuccess());
        assertEquals("Failed to update given expansion " + validExpansion,
                service.update(validExpansion).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(repository.findExpansionById(validExpansion.getExpansionId())).thenReturn(validExpansion);
        Mockito.when(repository.delete(validExpansion)).thenReturn(true);
        assertTrue(service.delete(validExpansion).isSuccess());
        assertEquals("success", service.delete(validExpansion).getMessages().get(0));
    }

    @Test
    void deleteExpansionNotFound() {
        Mockito.when(repository.findExpansionById(validExpansion.getExpansionId())).thenReturn(null);
        assertFalse(service.delete(validExpansion).isSuccess());
        assertEquals("The given expansion " + validExpansion.getReleasedDate() + " is not found",
                service.delete(validExpansion).getMessages().get(0));
    }

    @Test
    void deleteExpansionFailed() {
        Mockito.when(repository.findExpansionById(validExpansion.getExpansionId())).thenReturn(validExpansion);
        Mockito.when(repository.delete(validExpansion)).thenReturn(false);
        assertFalse(service.delete(validExpansion).isSuccess());
        assertEquals("Failed to update given expansion " + validExpansion,
                service.delete(validExpansion).getMessages().get(0));
    }
}
