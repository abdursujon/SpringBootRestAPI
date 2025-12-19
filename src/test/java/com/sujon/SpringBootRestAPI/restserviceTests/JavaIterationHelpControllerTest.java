package com.sujon.SpringBootRestAPI.restserviceTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class JavaIterationHelpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whileIterationHelpWorks() throws Exception {
        mockMvc.perform(get("/api/help/java/iteration/while"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.topic").value("while"))
                .andExpect(jsonPath("$.description").value("while(condition) statement;"))
                .andExpect(jsonPath("$.example").exists());
    }

    @Test
    void invalidTopicReturnsInvalid() throws Exception {
        mockMvc.perform(get("/api/help/java/iteration/xyz"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.topic").value("invalid"))
                .andExpect(jsonPath("$.description").value("Invalid topic"));
    }
}