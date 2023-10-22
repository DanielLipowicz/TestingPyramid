package com.checkit.TestingPyramid.application.isItAfterNoon;

import com.checkit.TestingPyramid.isItAfterNoon.IsItAfterNoonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(IsItAfterNoonController.class)
class IsItAfterNoonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void isItAfterNoon() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/isItAfterNoon"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}