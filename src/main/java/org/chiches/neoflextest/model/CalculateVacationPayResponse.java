package org.chiches.neoflextest.model;

public class CalculateVacationPayResponse {
    private double vacationPay;

    public CalculateVacationPayResponse(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    public double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay) {
        this.vacationPay = vacationPay;
    }
}
