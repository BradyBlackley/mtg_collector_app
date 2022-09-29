package com.example.mtg.service;

import com.example.mtg.repository.jdbcRepositories.CardCopyJdbcRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CardCopyServiceTest {

    @InjectMocks
    CardCopyService service;
    @Mock
    CardCopyJdbcRepository repository;
    @Mock
    CardService cardService;
    @Mock
    UserService userService;

    @Test
    void findAllByUser() {

    }

    @Test
    void findAllByUserNoneFound() {

    }

    @Test
    void findAllByCardId() {

    }

    @Test
    void findAllByCardIdNoneFound() {

    }

    @Test
    void findByCardCopyId() {

    }

    @Test
    void findByCardCopyIdNoneFound() {

    }

    @Test
    void add() {

    }

    @Test
    void addCardCopyIdAlreadyExists() {

    }

    @Test
    void addCardCopyIdInvalid() {

    }

    @Test
    void addCardCopyCardNotFound() {

    }

    @Test
    void addCardCopyUserNotFound() {

    }

    @Test
    void addCardCopyCardIsInvalid() {

    }

    @Test
    void addCardCopyUserIsInvalid() {

    }

    @Test
    void addFailed() {

    }

    @Test
    void update() {

    }

    @Test
    void updateCardCopyIdDoesNotExist() {

    }

    @Test
    void updateCardCopyIdInvalid() {

    }

    @Test
    void updateCardCopyCardNotFound() {

    }

    @Test
    void updateCardCopyUserNotFound() {

    }

    @Test
    void updateCardCopyCardIsInvalid() {

    }

    @Test
    void updateCardCopyUserIsInvalid() {

    }

    @Test
    void updateFailed() {

    }

    @Test
    void delete() {

    }

    @Test
    void deleteCardCopyIdDoesNotExist() {

    }

    @Test
    void deleteCardCopyIdInvalid() {

    }

    @Test
    void deleteCardCopyCardNotFound() {

    }

    @Test
    void deleteCardCopyUserNotFound() {

    }

    @Test
    void deleteCardCopyCardIsInvalid() {

    }

    @Test
    void deleteCardCopyUserIsInvalid() {

    }

    @Test
    void deleteFailed() {

    }
}