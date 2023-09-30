//package com.sal.service;
//
//import com.sal.model.Customer;
//import com.sal.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.FileReader;
//import java.io.IOException;
//
//@Service
//public class CsvDataService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    public void parseCsvAndInsertData(String csvFilePath) throws IOException, CsvException {
//        try (FileReader reader = new FileReader(csvFilePath);
//             CSVReader csvReader = new CSVReader(reader)) {
//
//            String[] nextRecord;
//            while ((nextRecord = csvReader.readNext()) != null) {
//                Customer customer = new Customer();
//                // Populate the customer object with data from the CSV record
//                // e.g., customer.setCustomerID(Long.parseLong(nextRecord[0]));
//                // ...
//
//                // Save the customer object to the database
//                customerRepository.save(customer);
//            }
//        }
//    }
//}
