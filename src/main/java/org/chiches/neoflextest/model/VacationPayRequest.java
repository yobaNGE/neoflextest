package org.chiches.neoflextest.model;

import java.time.LocalDate;

public class VacationPayRequest {
    private double avarageSalary;
    private int daysVacation;
    private LocalDate startDate;
    private LocalDate endDate;

    public VacationPayRequest(double avarageSalary, int daysVacation, LocalDate startDate, LocalDate endDate) {
        this.avarageSalary = avarageSalary;
        this.daysVacation = daysVacation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public VacationPayRequest() {

    }

    public double getAvarageSalary() {
        return avarageSalary;
    }

    public void setAvarageSalary(double avarageSalary) {
        this.avarageSalary = avarageSalary;
    }

    public int getDaysVacation() {
        return daysVacation;
    }

    public void setDaysVacation(int daysVacation) {
        this.daysVacation = daysVacation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "VacationPayRequest{" +
                "avarageSalary=" + avarageSalary +
                ", daysVacation=" + daysVacation +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
