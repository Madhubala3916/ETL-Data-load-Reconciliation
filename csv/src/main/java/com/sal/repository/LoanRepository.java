package com.sal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sal.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
