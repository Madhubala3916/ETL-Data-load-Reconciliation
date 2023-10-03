package com.etl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etl.entity.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}
