package com.sal.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.sal.model.Account;
import com.sal.model.BranchEntity;
import com.sal.model.Customer;
import com.sal.model.Loan;
import com.sal.model.Transaction;
import com.sal.repository.AccountRepository;
import com.sal.repository.BranchRepository;
import com.sal.repository.CustomerRepository;
import com.sal.repository.LoanRepository;
import com.sal.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


@Service
public class CsvReaderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LoanRepository loanRepository;

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
                    customerRepository.save(customer);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
                BranchEntity branch = new BranchEntity();
                try {
                branch.setBranchID(Long.parseLong(nextRecord[6]));
              branch.setBranchLocation(nextRecord[7]);
              branch.setBranchCode(nextRecord[8]);
              branch.setBranchAddress(nextRecord[9]);
              branch.setBranchContactNo(nextRecord[10]);
              branchRepository.save(branch);
              }
                catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
                Account acc = new Account();
                try {
                	acc.setAccountID(Long.parseLong(nextRecord[11]));
                   acc.setAccountType(nextRecord[12]);
                    acc.setBalance(Double.parseDouble(nextRecord[13]));
                   acc.setBranch(branch);
                    acc.setCustomer(customer);
                    accountRepository.save(acc);
                    
                }catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
                
                Transaction trans = new Transaction();
                try {
                	trans.setTransactionID(Long.parseLong(nextRecord[14]));
                    trans.setTransactionType(nextRecord[15]);
                    trans.setTransactionAmount(Double.parseDouble(nextRecord[16]));
                    trans.setTransactionDate(nextRecord[17]);
                    trans.setAcc(acc);
                    transactionRepository.save(trans);
                    
                    
                }catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
                Loan loan = new Loan();
                try {
                	loan.setLoanID(Long.parseLong(nextRecord[18]));
                	loan.setLoanType(nextRecord[20]);
                	loan.setLoanAmount(Double.parseDouble(nextRecord[19]));
                    loan.setInterestRate(nextRecord[21]);
                    
                 loan.setTerm(nextRecord[22]);
                   loan.setStatus(nextRecord[23]);
                   loan.setCustomer(customer);
                   loanRepository.save(loan);
                }catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + e.getMessage());
                }
//                accountRepository.save(account);
//                transactionRepository.save(transaction);
//                loanRepository.save(loan);
            }
        }
    }
}

