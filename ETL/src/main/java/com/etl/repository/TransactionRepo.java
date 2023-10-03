package com.etl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etl.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
