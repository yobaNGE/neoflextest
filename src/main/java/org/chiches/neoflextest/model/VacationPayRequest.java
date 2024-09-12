package org.chiches.neoflextest.model;

import java.time.LocalDate;

public class VacationPayRequest {
    private double avarageSalary;
    private LocalDate startDate;
    private LocalDate endDate;

    public VacationPayRequest(double avarageSalary, LocalDate startDate, LocalDate endDate) {
        this.avarageSalary = avarageSalary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getAvarageSalary() {
        return avarageSalary;
    }

    public void setAvarageSalary(double avarageSalary) {
        this.avarageSalary = avarageSalary;
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
