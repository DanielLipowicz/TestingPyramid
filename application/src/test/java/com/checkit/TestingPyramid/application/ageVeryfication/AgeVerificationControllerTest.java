package com.checkit.TestingPyramid.application.ageVeryfication;

import com.checkit.TestingPyramid.ageVeryfication.AgeVerificationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AgeVerificationController.class)
class AgeVerificationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void verifyAge() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/verify-age")
                        .param("age", "30"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
