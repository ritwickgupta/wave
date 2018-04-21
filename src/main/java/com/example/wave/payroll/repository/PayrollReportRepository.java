package com.example.wave.payroll.repository;

import com.example.wave.payroll.persistence.PayrollReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollReportRepository extends CrudRepository<PayrollReport, Integer> {
}
