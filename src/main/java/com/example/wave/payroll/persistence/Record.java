package com.example.wave.payroll.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue
    private Integer id;
    private Date jobDate;
    private Integer hoursWorked;
    private Integer employeeId;
    private String jobGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Record(Date jobDate, Integer hoursWorked, Integer employeeId, String jobGroup) {
        this.jobDate = jobDate;
        this.hoursWorked = hoursWorked;
        this.employeeId = employeeId;
        this.jobGroup = jobGroup;
    }

    public Record() {
    }
}
