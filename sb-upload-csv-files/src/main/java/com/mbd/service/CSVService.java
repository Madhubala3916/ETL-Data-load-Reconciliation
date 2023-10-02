package com.mbd.service;

import com.mbd.helper.CSVHelper;
import com.mbd.model.Csvfile;
import com.mbd.repository.CsvFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    CsvFileRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Csvfile> csvfiles = CSVHelper.csvToCsvfiles(file.getInputStream());
            repository.saveAll(csvfiles);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Csvfile> getAllCsvFiles() {
        return repository.findAll();
    }
}
