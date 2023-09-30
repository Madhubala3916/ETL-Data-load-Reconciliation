package com.sal.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.sal.model.Customer;
import com.sal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class CsvReaderService {
    @Autowired
    private CustomerRepository customerRepository;

    public void readCsvAndInsertData(String csvFilePath) throws IOException, CsvException {
        try (FileReader reader = new FileReader(csvFilePath);
             CSVReader csvReader = new CSVReader(reader)) {

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Reading data: " + Arrays.toString(nextRecord)); // Debugging statement

                Customer customer = new Customer();
                try {
                    customer.setCustomerID(Long.parseLong(nextRecord[0]));
                    customer.setFirstName(nextRecord[1]);
                    customer.setLastName(nextRecord[2]);
                    customer.setAddress(nextRecord[3]);
                    customer.setContactNo(nextRecord[4]);
                    customer.setEmailID(nextRecord[5]);
                    customer.setBranchID(Long.parseLong(nextRecord[6]));
                    customer.setBranchLocation(nextRecord[7]);
                    customer.setBranchCode(nextRecord[8]);
                    customer.setBranchAddress(nextRecord[9]);
                    customer.setBranchContactNo(nextRecord[10]);
                    customer.setAccountID(Long.parseLong(nextRecord[11]));
                    customer.setAccountType(nextRecord[12]);
                    customer.setBalance(Double.parseDouble(nextRecord[13]));
                    customer.setTransactionID(Long.parseLong(nextRecord[14]));
                    customer.setTransactionType(nextRecord[15]);
                    customer.setTransactionAmount(Double.parseDouble(nextRecord[16]));
                    customer.setTransactionDate(nextRecord[17]);
                    customer.setLoanID(Long.parseLong(nextRecord[18]));
                    customer.setLoanAmount(Double.parseDouble(nextRecord[19]));
                    customer.setLoanType(nextRecord[20]);
                    customer.setInterestRate(nextRecord[21]);
                    customer.setTerm(nextRecord[22]);
                    customer.setStatus(nextRecord[23]);
                    customerRepository.save(customer);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
            }
        }
    }
}

