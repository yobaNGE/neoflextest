package org.chiches.neoflextest.service;

import de.focus_shift.jollyday.core.Holiday;
import de.focus_shift.jollyday.core.HolidayCalendar;
import de.focus_shift.jollyday.core.HolidayManager;
import de.focus_shift.jollyday.core.ManagerParameters;
import org.chiches.neoflextest.model.CalculateVacationPayResponse;
import org.chiches.neoflextest.model.VacationPayRequest;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;


@Service
public class VacationPayService {
    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;

    public CalculateVacationPayResponse calculateVacationPay(VacationPayRequest vacationPayRequest) {
        if (vacationPayRequest.getAvarageSalary() < 0
                || vacationPayRequest.getStartDate() == null
                || vacationPayRequest.getEndDate() == null
                || vacationPayRequest.getStartDate().isAfter(vacationPayRequest.getEndDate())
                || vacationPayRequest.getStartDate().isEqual(vacationPayRequest.getEndDate())
        ) {
            throw new IllegalArgumentException("One or more arguments are incorrect");
        }

        HolidayManager holidayManager = HolidayManager.getInstance(ManagerParameters.create(HolidayCalendar.RUSSIA));
        Set<Holiday> holidays = holidayManager.getHolidays(vacationPayRequest.getStartDate(), vacationPayRequest.getEndDate());

        LocalDate currentDate = vacationPayRequest.getStartDate();
        int vacationDays = 0;

        while (currentDate.isBefore(vacationPayRequest.getEndDate())) {
            LocalDate finalCurrentDate = currentDate;
            if (
                    currentDate.getDayOfWeek() != DayOfWeek.SATURDAY
                            && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY
                            && holidays.stream().noneMatch(holiday -> holiday.getDate().equals(finalCurrentDate))
            )
                vacationDays++;
            currentDate = currentDate.plusDays(1);
        }

        double vacationPay = (vacationPayRequest.getAvarageSalary() / AVERAGE_DAYS_IN_MONTH) * vacationDays;

        return new CalculateVacationPayResponse(vacationPay);
    }
}
