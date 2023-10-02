package com.sal.controller;

import com.sal.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/import-csv")
public class CsvController {
    @Autowired
    private CsvService csvService;

    @GetMapping
    public String importCsvAndCreateTable(@RequestParam String entityName) {
        try {
            csvService.createTableAndImportData("D:\\ManipalClass\\CapstoneProject\\ETL-Data-load-Reconciliation\\your_csv_file.csv", entityName);
            return "Tables created and data imported successfully for entity: " + entityName;
        } catch (Exception e) {
            return "Error creating tables and importing data for entity: " + entityName + ", Error: " + e.getMessage();
        }
    }
}
