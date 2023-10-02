package com.sal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sal.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
