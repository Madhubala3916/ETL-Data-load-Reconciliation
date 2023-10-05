package com.mbd.repository;

import com.mbd.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan, Long> {
}
