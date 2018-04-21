package com.example.wave.payroll.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PayrollReport {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer employeeId;
    private Date startDate;
    private Date endDate;
    private Double amountPaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PayrollReport(Integer employeeId, Date startDate, Date endDate, Double amountPaid) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountPaid = amountPaid;
    }

    public PayrollReport() {
    }
}
