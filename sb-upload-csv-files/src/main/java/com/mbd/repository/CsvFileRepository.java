package com.mbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mbd.model.Csvfile;

public interface CsvFileRepository extends JpaRepository<Csvfile, Long> {
}

