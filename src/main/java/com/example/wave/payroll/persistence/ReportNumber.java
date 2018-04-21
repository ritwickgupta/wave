package com.example.wave.payroll.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReportNumber {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer reportNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }

    public ReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }

    public ReportNumber() {
    }
}
