package org.chiches.neoflextest.controller;

import org.chiches.neoflextest.model.CalculateVacationPayResponse;
import org.chiches.neoflextest.model.VacationPayRequest;
import org.chiches.neoflextest.service.VacationPayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationPayController {

    private final VacationPayService vacationPayService;

    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    //http://localhost:8080/calculate?averageSalary=100000&startDate=01.09.2024&endDate=11.09.2024
    @GetMapping("/calculate")
    public CalculateVacationPayResponse calculateVacationPay(
            @RequestParam double averageSalary,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        VacationPayRequest vacationPayRequest = new VacationPayRequest(
                averageSalary,
                startDate,
                endDate);
        return vacationPayService.calculateVacationPay(vacationPayRequest);
    }
}
