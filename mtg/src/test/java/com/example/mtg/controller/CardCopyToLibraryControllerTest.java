package com.example.mtg.controller;

import com.example.mtg.model.*;
import com.example.mtg.service.CardCopyToLibraryService;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardCopyToLibraryController.class)
class CardCopyToLibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CardCopyToLibraryService service;

    @Test
    void getAllCardsInLibrary() throws Exception {

        Library library = new Library();
        library.setLibraryId(1);
        library.setLibraryName("Dragons");
        library.setUserId("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454");

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
        card.setTextBox("Each creature you control gets +1/+0 for each time it has attacked this turn. " +
                "Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, " +
                "there''s an additional combat phase after this phase. At the beginning of that combat, untap all " +
                "creatures you control.");

        CardCopy cardCopy = new CardCopy();
        cardCopy.setCard(card);

        CardCopyToLibrary cardCopyToLibrary = new CardCopyToLibrary();
        cardCopyToLibrary.setLibrary(library);
        cardCopyToLibrary.setCardCopies(List.of(cardCopy));

        Result<CardCopyToLibrary> result = new Result<>();
        result.setPayload(cardCopyToLibrary);
        result.addMessage("success", ResultType.SUCCESS);

        when(service.findByLibraryId(library.getLibraryId())).thenReturn(result);

        mockMvc.perform(
                    get("http://localhost:3000/api/cardCopies/allCardsByLibrary")
                        .header("Content-Type", "application/json")
                        .param("libraryId", "1")
                )
                .andExpect(status().is(200))
                .andExpect(content().json(
                        """
                                {"messages":["success"],"type":"SUCCESS","payload":{cardCopies:[{"cardCopyId":0, "card":{"cardId":"ZNR150", "cardName":"Moraug, Fury of Akoum", "imagePath":"card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg", "rarity":"MYTHIC", "artistName":"Rudy Siswanto", "convertedManaCost":"6", "power":"6", "toughness":"6", "expansion":{"expansionId":242, "expansionName":"Zendikar Rising", "expansionCode":"ZNR", "releasedDate":"2020-09-01T06:00:00.000Z"}, "textBox":"Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.", "backCard":null}, "userId":null}], library:{"libraryId":1, "libraryName":"Dragons", "userId":"f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"}},"success":true}
                                """));
    }
}
