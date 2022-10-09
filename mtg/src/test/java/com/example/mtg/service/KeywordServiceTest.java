package com.example.mtg.service;

import com.example.mtg.model.Keyword;
import com.example.mtg.repository.jdbcRepositories.KeywordJdbcRepository;
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
public class KeywordServiceTest {

    @InjectMocks
    private KeywordService service;

    @Mock
    private KeywordJdbcRepository repository;

    public Keyword validKeyword = new Keyword(1, "Double Strike");

    public Keyword validKeyword1 = new Keyword(2, "Flash");

    public Keyword validKeyword2 = new Keyword(3, "Defender");

    public Keyword invalidKeywordName = new Keyword(4, "NotV@lid!");

    @Test
    void findAllKeywords() {
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(validKeyword);
        keywords.add(validKeyword1);
        keywords.add(validKeyword2);

        Mockito.when(repository.findAllKeywords()).thenReturn(keywords);

        assertTrue(service.findAllKeywords().isSuccess());
        assertEquals("success", service.findAllKeywords().getMessages().get(0));
    }

    @Test
    void findAllKeywordsNoneFound() {
        List<Keyword> keywords = new ArrayList<>();

        Mockito.when(repository.findAllKeywords()).thenReturn(keywords);

        assertFalse(service.findAllKeywords().isSuccess());
        assertEquals("No keywords found", service.findAllKeywords().getMessages().get(0));
    }

    @Test
    void findKeywordByName() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(validKeyword);

        assertTrue(service.findKeywordByName(validKeyword.getKeywordName()).isSuccess());
        assertEquals("success", service.findKeywordByName(validKeyword.getKeywordName()).getMessages().get(0));
    }

    @Test
    void findKeywordByNameNotFound() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(null);

        assertFalse(service.findKeywordByName(validKeyword.getKeywordName()).isSuccess());
        assertEquals("No keyword found by given name " + validKeyword.getKeywordName(),
                service.findKeywordByName(validKeyword.getKeywordName()).getMessages().get(0));
    }

    @Test
    void findKeywordById() {
        Mockito.when(repository.findKeywordById(validKeyword.getKeywordId())).thenReturn(validKeyword);

        assertTrue(service.findKeywordById(validKeyword.getKeywordId()).isSuccess());
        assertEquals("success", service.findKeywordById(validKeyword.getKeywordId()).getMessages().get(0));
    }

    @Test
    void findKeywordByIdNotFound() {
        Mockito.when(repository.findKeywordById(validKeyword.getKeywordId())).thenReturn(null);

        assertFalse(service.findKeywordById(validKeyword.getKeywordId()).isSuccess());
        assertEquals("No keyword found by given id " + validKeyword.getKeywordId(),
                service.findKeywordById(validKeyword.getKeywordId()).getMessages().get(0));
    }

    @Test
    void add() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(null);
        Mockito.when(repository.add(validKeyword)).thenReturn(validKeyword);

        //assertTrue(service.add(validKeyword).isSuccess());
        assertEquals("success", service.add(validKeyword).getMessages().get(0));
    }

    @Test
    void addInvalidKeywordName() {
        Mockito.when(repository.add(invalidKeywordName)).thenReturn(invalidKeywordName);

        assertFalse(service.add(invalidKeywordName).isSuccess());
        assertEquals("The provided keyword name " + invalidKeywordName.getKeywordName() + " is " +
                ResultType.INVALID.label, service.add(invalidKeywordName).getMessages().get(0));
    }

    @Test
    void addKeywordNameAlreadyInUse() {
        Mockito.when(repository.add(validKeyword)).thenReturn(validKeyword);
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(validKeyword);

        assertFalse(service.add(validKeyword).isSuccess());
        assertEquals("The provided keyword name " + validKeyword.getKeywordName() + " is already in use",
                service.add(validKeyword).getMessages().get(0));
    }

    @Test
    void update() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(validKeyword);

        Result<Boolean> result = service.update(validKeyword);

        assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void updateInvalidKeywordName() {
        assertFalse(service.update(invalidKeywordName).isSuccess());
        assertEquals("The provided keyword name " + invalidKeywordName.getKeywordName() + " is " + ResultType.INVALID.label,
                service.update(invalidKeywordName).getMessages().get(0));
    }

    @Test
    void updateKeywordNameNotFound() {
        assertFalse(service.update(validKeyword).isSuccess());
        assertEquals("The provided keyword " + validKeyword.getKeywordName() + " is not found",
                service.update(validKeyword).getMessages().get(0));
    }

    @Test
    void delete() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(validKeyword);
        Mockito.when(repository.delete(validKeyword)).thenReturn(true);
        Result<Boolean> result = service.delete(validKeyword);

        assertTrue(result.isSuccess());
        assertEquals("success", result.getMessages().get(0));
    }

    @Test
    void deleteInvalidKeywordName() {
        Result<Boolean> result = service.delete(invalidKeywordName);

        assertFalse(result.isSuccess());
        assertEquals("The provided keyword name " + invalidKeywordName.getKeywordName() + " is "
                + ResultType.INVALID.label, result.getMessages().get(0));
    }

    @Test
    void deleteKeywordNameNotFound() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(null);
        Result<Boolean> result = service.delete(validKeyword);

        assertFalse(result.isSuccess());
        assertEquals("The provided keyword " + validKeyword.getKeywordName() + " is not found",
                result.getMessages().get(0));
    }

    @Test
    void deleteKeywordFailed() {
        Mockito.when(repository.findKeywordByName(validKeyword.getKeywordName())).thenReturn(validKeyword);
        Mockito.when(repository.delete(validKeyword)).thenReturn(false);
        Result<Boolean> result = service.delete(validKeyword);

        assertFalse(result.isSuccess());
        assertEquals("Failed to delete given keyword " + validKeyword.getKeywordName(),
                result.getMessages().get(0));
    }

    @Test
    void validateKeyword() {
        assertTrue(service.validateKeyword(validKeyword));
        assertFalse(service.validateKeyword(invalidKeywordName));
    }
}
