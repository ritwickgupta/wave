package com.example.wave.payroll.repository;

import com.example.wave.payroll.persistence.PayrollReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PayrollReportRepository extends CrudRepository<PayrollReport, Integer> {

    @Query("from PayrollReport p where p.employeeId = :employeeId and p.startDate < :date and p.endDate > :date")
    PayrollReport getReport(@Param("employeeId") Integer employeeId, @Param("date") Date date);
}
