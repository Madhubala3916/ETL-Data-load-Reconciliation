package com.sal.controller;

import com.sal.service.CsvReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvController {
    @Autowired
    private CsvReaderService csvDataService;
    @GetMapping("/import-csv")
    public String importCsv() {
        try {
            csvDataService.readCsvAndInsertData("C:\\Users\\Yamsani Apoorva\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\csv\\src\\bank_data_1.csv");
            return "Data imported successfully!";
        } catch (Exception e) {
            return "Error importing data: " + e.getMessage();
        }
    }
}
