//package com.sal.service;
//
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvException;
//import com.sal.model.Customer;
//import com.sal.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Arrays;
//
//@Service
//public class CustomerCsvReaderService {
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    public void readCsvAndInsertData(String csvFilePath) throws IOException, CsvException {
//        try (FileReader reader = new FileReader(csvFilePath);
//             CSVReader csvReader = new CSVReader(reader)) {
//
//            String[] nextRecord;
//            while ((nextRecord = csvReader.readNext()) != null) {
//                System.out.println("Reading data: " + Arrays.toString(nextRecord));
//
//                Customer customer = new Customer();
//                try {
//                    customer.setCustomerID(Long.parseLong(nextRecord[0]));
//                    customer.setFirstName(nextRecord[1]);
//                    customer.setLastName(nextRecord[2]);
//                    customer.setAddress(nextRecord[3]);
//                    customer.setContactNo(nextRecord[4]);
//                    customer.setEmailID(nextRecord[5]);
//                    customerRepository.save(customer);
//                } catch (NumberFormatException e) {
//                    System.err.println("Error parsing data: " + e.getMessage());
//                }
//            }
//        }
//    }
//}
//
