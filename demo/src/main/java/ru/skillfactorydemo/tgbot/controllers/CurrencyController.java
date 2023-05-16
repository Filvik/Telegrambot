package ru.skillfactorydemo.tgbot.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skillfactorydemo.tgbot.dto.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot.service.CentralRussianBankService;
import ru.skillfactorydemo.tgbot.service.StatsService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService service;

    @PostMapping("/postCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate1() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getStatus")
    @ApiOperation(value = "Получение количества пополнений,которое превышает определенную сумму.")
    public int getStatusAboutIncomesThatOperator(@RequestParam(value = "amount")BigDecimal amount){
        return service.getCountOfIncomesThatGreater(amount);
    }
}