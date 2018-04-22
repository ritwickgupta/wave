package com.example.wave.payroll.model;

public class PayrollReportModel {

    String employeeId;
    String payPeriod;
    String amountPaid;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PayrollReportModel(String employeeId, String payPeriod, String amountPaid) {
        this.employeeId = employeeId;
        this.payPeriod = payPeriod;
        this.amountPaid = amountPaid;
    }

    public PayrollReportModel() {
    }

    @Override
    public String toString() {
        return "PayrollReportModel{" +
                "employeeId='" + employeeId + '\'' +
                ", payPeriod='" + payPeriod + '\'' +
                ", amountPaid='" + amountPaid + '\'' +
                '}';
    }
}
