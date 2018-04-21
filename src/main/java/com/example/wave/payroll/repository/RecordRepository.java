package com.example.wave.payroll.repository;

import com.example.wave.payroll.persistence.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
}
