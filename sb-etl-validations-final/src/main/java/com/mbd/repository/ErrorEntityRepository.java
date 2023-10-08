package com.mbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbd.model.ErrorEntity;

public interface ErrorEntityRepository extends JpaRepository<ErrorEntity, Long> {

}
