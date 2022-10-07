package com.example.mtg.service;

import com.example.mtg.model.*;
import com.example.mtg.repository.repositoryInterfaces.TypelineRepository;
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
public class TypelineServiceTest {

    @InjectMocks
    private TypelineService service;
    @Mock
    TypelineRepository repository;
    @Mock
    TypeService typeService;
    @Mock
    CardService cardService;

    public Type validType = new Type(1, "Creature");

    public Type validType1 = new Type(2, "Land");

    public Type validType2 = new Type(3, "Legendary");

    public Card validCard = new Card("ZNR150", "Moraug, Fury of Akoum",
            "card_images\\zendikar_rising\\znr-150-moraug-fury-of-akoum.jpg", Rarity.MYTHIC,
            "Rudy Siswanto", "6", "6", "6", new Expansion(1,
            "Zendikar Rising", "ZNR", Date.valueOf("2020-09-01")),
            "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall -" +
                    " Whenever a land enters the battlefield under your control, if it's your main phase, there's an" +
                    " additional combat phase after this phase. At the beginning of that combat, untap all creatures" +
                    " you control.");

    public List<Type> getTypeList() {
        List<Type> typeList = new ArrayList<>();
        typeList.add(validType);
        typeList.add(validType1);
        typeList.add(validType2);

        return typeList;
    }

    public Typeline validTypeline = new Typeline(getTypeList(), validCard);


    @Test
    void findByCardId() {
        Mockito.when(repository.findByCardId(validCard.getCardId())).thenReturn(validTypeline);
        assertTrue(service.findByCardId(validCard.getCardId()).isSuccess());
        assertEquals("success", service.findByCardId(validCard.getCardId()).getMessages().get(0));
    }

    @Test
    void findByCardIdNoneFound() {
        Mockito.when(repository.findByCardId(validCard.getCardId())).thenReturn(null);
        assertFalse(service.findByCardId(validCard.getCardId()).isSuccess());
        assertEquals("No typeline found associated with given card id " + validCard.getCardId(),
                service.findByCardId(validCard.getCardId()).getMessages().get(0));
    }

    @Test
    void add() {

    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }
}
