package com.example.mtg.controller;

import com.example.mtg.model.Library;
import com.example.mtg.service.LibraryService;
import com.example.mtg.service.result.Result;
import com.example.mtg.service.result.ResultType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryController.class)
class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryService mockLibraryService;

    @Test
    void addLibrary() throws Exception {

        Library library = new Library();
        library.setLibraryName("Dragons");
        library.setUserId("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454");

        Result<Library> result = new Result<>();
        result.setPayload(library);
        result.addMessage("success", ResultType.SUCCESS);

        when(mockLibraryService.add(argThat(library1 -> library1.getLibraryName().startsWith("Dragons")))).thenReturn(result);

        mockMvc.perform(post("http://localhost:3000/api/libraries/addLibrary")
                        .content(
                                """
                                         {"libraryName": "Dragons","userId": "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"}
                                        """
                        ).header("Content-Type", "application/json"))
                .andExpect(status().is(200))
                .andExpect(content().json(
                        """
                                {"messages":["success"],"type":"SUCCESS","payload":{"libraryId":0,"libraryName":"Dragons","userId":"f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"},"success":true}
                                """));
    }

}