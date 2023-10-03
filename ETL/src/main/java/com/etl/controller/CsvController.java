package com.etl.controller;

import com.etl.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvController {
	@Autowired
	private MainService mainService;

	@GetMapping("/import-data")
	public String importData() {
		try {
			mainService.readCsvAndInsertData(
					"C:\\Users\\KSHITEJA\\Documents\\workspace-spring-tool-suite-4\\ETL\\bank_data_1.csv");
			return "Data imported successfully!";
		} catch (Exception e) {
			return "Error importing data: " + e.getMessage();
		}
	}
}