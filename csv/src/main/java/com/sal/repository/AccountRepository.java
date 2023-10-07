package com.sal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sal.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
