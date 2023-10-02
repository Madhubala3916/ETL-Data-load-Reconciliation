package com.sal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sal.model.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Long> {
}
