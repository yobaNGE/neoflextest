package org.chiches.neoflextest.service;

import org.chiches.neoflextest.model.CalculateVacationPayResponse;
import org.chiches.neoflextest.model.VacationPayRequest;
import org.springframework.stereotype.Service;


@Service
public class VacationPayService {
    public CalculateVacationPayResponse calculateVacationPay(VacationPayRequest vacationPayRequest){
        if (vacationPayRequest.getAvarageSalary() < 0
                || vacationPayRequest.getDaysVacation() < 0
                || vacationPayRequest.getStartDate() == null
                || vacationPayRequest.getEndDate() == null
        )
            throw new IllegalArgumentException("One or more arguments are incorrect");

        
        System.out.println(vacationPayRequest);
        return null;
    }
}
