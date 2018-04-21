package com.example.wave.payroll.repository;

import com.example.wave.payroll.persistence.ReportNumber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportNumberRepository extends CrudRepository<ReportNumber, Integer> {

    @Query("Select id from ReportNumber r where r.reportNumber = :reportNumber")
    Integer findByRecordNumber(@Param("reportNumber") Integer reportNumber);
}
