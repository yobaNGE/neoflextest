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

    @GetMapping("/calculate")
    public CalculateVacationPayResponse calculateVacationPay(
            @RequestParam double averageSalary,
            @RequestParam int daysVacation,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        VacationPayRequest vacationPayRequest = new VacationPayRequest(
                averageSalary,
                daysVacation,
                startDate,
                endDate);

        return vacationPayService.calculateVacationPay(vacationPayRequest);
    }
}
