package com.mbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbd.model.errorEntity;

public interface errorRepo extends JpaRepository<errorEntity, Long> {

}