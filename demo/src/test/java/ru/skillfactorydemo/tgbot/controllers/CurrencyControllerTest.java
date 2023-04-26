package ru.skillfactorydemo.tgbot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.skillfactorydemo.tgbot.DemoApplication;
import ru.skillfactorydemo.tgbot.TgbotApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= DemoApplication.class)
class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getValuteCursOnDate() throws Exception {
        mockMvc.perform(post("/api/postCurrencies"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}