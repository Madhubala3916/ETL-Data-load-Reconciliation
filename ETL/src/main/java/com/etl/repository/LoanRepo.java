package com.etl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etl.entity.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long>{

}
