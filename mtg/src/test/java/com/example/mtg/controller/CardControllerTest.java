package com.example.mtg.controller;

import com.example.mtg.model.*;
import com.example.mtg.service.CardService;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardController.class)
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CardService service;

    @Test
    void addCard() throws Exception {

        Card card = new Card();
        Expansion expansion = new Expansion();
        expansion.setExpansionId(242);
        expansion.setExpansionName("Zendikar Rising");
        expansion.setExpansionCode("ZNR");
        expansion.setReleasedDate(Date.valueOf("2020-09-01"));

        card.setCardId("ZNR150");
        card.setCardName("Moraug, Fury of Akoum");
        card.setImagePath("card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg");
        card.setRarity(Rarity.MYTHIC);
        card.setArtistName("Rudy Siswanto");
        card.setConvertedManaCost("6");
        card.setPower("6");
        card.setToughness("6");
        card.setExpansion(expansion);
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it's your main phase, there's an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.");

        Result<Card> result = new Result<>();
        result.setPayload(card);
        result.addMessage("", ResultType.SUCCESS);

        when(service.add(any())).thenReturn(result);

        mockMvc.perform(post("/api/cards/addCard")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
             """
             {
               "cardId": "ZNR150",
               "cardName": "Moraug, Fury of Akoum",
               "imagePath": "card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg",
               "rarity": "MYTHIC",
               "artistName": "Rudy Siswanto",
               "convertedManaCost": "6",
               "power": "6",
               "toughness": "6",
               "expansion": {
                 "expansionId": 242,
                 "expansionName": "Zendikar Rising",
                 "expansionCode": "ZNR",
                 "releasedDate": "2020-09-01"
               },
               "textBox": "Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it's your main phase, there's an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.",
               "backCard": null
             }
             """))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("""
            {
              "type": "SUCCESS",
              "payload": {
               "cardId": "ZNR150",
               "cardName": "Moraug, Fury of Akoum",
               "rarity": "MYTHIC",
               "convertedManaCost": "6",
               "power": "6",
               "toughness": "6"
              },
              "success": true
            }
            """, false));
    }
}