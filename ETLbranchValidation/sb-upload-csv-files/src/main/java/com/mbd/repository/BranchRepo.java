package com.mbd.repository;

import com.mbd.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {
}
