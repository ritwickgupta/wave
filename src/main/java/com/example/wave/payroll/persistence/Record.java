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
    private Double hoursWorked;
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

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
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

    public Record(Date jobDate, Double hoursWorked, Integer employeeId, String jobGroup) {
        this.jobDate = jobDate;
        this.hoursWorked = hoursWorked;
        this.employeeId = employeeId;
        this.jobGroup = jobGroup;
    }

    public Record() {
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", jobDate=" + jobDate +
                ", hoursWorked=" + hoursWorked +
                ", employeeId=" + employeeId +
                ", jobGroup='" + jobGroup + '\'' +
                '}';
    }
}
