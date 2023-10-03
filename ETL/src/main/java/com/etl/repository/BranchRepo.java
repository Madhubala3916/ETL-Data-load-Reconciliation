package com.etl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etl.entity.Branch;
@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer>{

}
