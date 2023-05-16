package ru.skillfactorydemo.tgbot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.skillfactorydemo.tgbot.TgbotApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= TgbotApplication.class)
class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getValuteCursOnDateThroughPost() throws Exception {
        mockMvc.perform(post("/api/postCurrencies"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getValuteCursOnDateThroughGet() throws Exception {
        mockMvc.perform(get("/api/getCurrencies"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}