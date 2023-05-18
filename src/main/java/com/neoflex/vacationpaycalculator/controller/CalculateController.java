package com.neoflex.vacationpaycalculator.controller;

import com.neoflex.vacationpaycalculator.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class CalculateController {
    private final CalculateService calculateService;
    @GetMapping
    public double calculate(@RequestParam double salary,
                            @RequestParam int days,
                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return calculateService.calculateVacationPay(salary, days, startDate, endDate);
    }
}
