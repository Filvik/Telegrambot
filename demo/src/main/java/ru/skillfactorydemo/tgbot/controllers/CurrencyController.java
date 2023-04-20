package ru.skillfactorydemo.tgbot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactorydemo.tgbot.dto.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot.service.CentralRussianBankService;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;

    @PostMapping("/postCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getCurrencies")
    public String getValuteCursOnDate1() throws Exception {
        return "centralRussianBankService.getCurrenciesFromCbr()";
    }
}