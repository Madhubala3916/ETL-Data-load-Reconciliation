//package com.sal.service;
//
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvException;
//import com.sal.model.Account;
//import com.sal.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Arrays;
//
//@Service
//public class AccountCsvReaderService {
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public void readCsvAndInsertData(String csvFilePath) throws IOException, CsvException {
//        try (FileReader reader = new FileReader(csvFilePath);
//             CSVReader csvReader = new CSVReader(reader)) {
//
//            String[] nextRecord;
//            while ((nextRecord = csvReader.readNext()) != null) {
//                System.out.println("Reading data: " + Arrays.toString(nextRecord));
//
//                Account account = new Account();
//                try {
//                    account.setAccountID(Long.parseLong(nextRecord[0]));
//                    account.setCustomerID(Long.parseLong(nextRecord[1]));
//                    account.setBankID(Long.parseLong(nextRecord[2]));
//                    account.setType(nextRecord[3]);
//                    account.setBalance(Double.parseDouble(nextRecord[4]));
//                    // Set other fields specific to the Account entity
//                    // ...
//
//                    accountRepository.save(account);
//                } catch (NumberFormatException e) {
//                    System.err.println("Error parsing data: " + e.getMessage());
//                }
//            }
//        }
//    }
//}
//
