package com.mbd.service;

import com.mbd.helper.CSVHelper;
import com.mbd.model.*;
import com.mbd.repository.*;
import com.mbd.validation.BranchValidationResult;
import com.mbd.validation.DataValidator;
import com.mbd.validation.ValidationResult;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CSVService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BranchRepo branchRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    LoanRepo loanRepo;

    @Autowired
    DataValidator dataValidator;

    public void save(MultipartFile file) {
        try {

            List<Customer> customer1 = CSVHelper.customer_func(file.getInputStream());
            //List<Branch> branch1 = CSVHelper.branch_func(file.getInputStream());
            //List<Account> account1 = CSVHelper.account_func(file.getInputStream());
            //List<Transaction> transaction1 = CSVHelper.transaction_func(file.getInputStream());
            //List<Loan> loan1= CSVHelper.loan_func(file.getInputStream());


            ValidationResult validationResult = dataValidator.checkCustomerValidation(customer1);

            customerRepo.saveAll(validationResult.getValidCustomers());

            Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers = validationResult.getErroneousCustomers();
            for (Map.Entry<Customer, Set<ConstraintViolation<Customer>>> entry : erroneousCustomers.entrySet()) {
                Customer erroneousCustomer = entry.getKey();
                Set<ConstraintViolation<Customer>> violations = entry.getValue();

                System.out.println("Handling erroneous customer: " + erroneousCustomer.toString());
                System.out.println("Violations: " + violations);
                // Handle the erroneous customer and violations as needed
            }

            List<Branch> branches = CSVHelper.branch_func(file.getInputStream());

            BranchValidationResult validationResult1 = dataValidator.checkBranchValidation(branches); // Use BranchValidationResult

            branchRepo.saveAll(validationResult1.getValidBranches()); // Use validationResult1

            Map<Branch, Set<ConstraintViolation<Branch>>> erroneousBranches = validationResult1.getErroneousBranches(); // Use validationResult1
            for (Map.Entry<Branch, Set<ConstraintViolation<Branch>>> entry : erroneousBranches.entrySet()) {
                Branch erroneousBranch = entry.getKey();
                Set<ConstraintViolation<Branch>> violations = entry.getValue();

                System.out.println("Handling erroneous branch: " + erroneousBranch.toString());
                System.out.println("Violations: " + violations);
                // Handle the erroneous branch and violations as needed
            }

            //branchRepo.saveAll(branch1);
           // accountRepo.saveAll(account1);
            //transactionRepo.saveAll(transaction1);
            //loanRepo.saveAll(loan1);

        } catch (IOException e) {
            throw new RuntimeException("failed to store csv data: " + e.getMessage());
        }
    }

    public List<Customer> getAllCsvFiles() {
        return customerRepo.findAll();
    }
    public List<Branch> getAllBranchFiles() {
        return branchRepo.findAll();
    }
    public List<Account> getAllAccountFiles() {
        return accountRepo.findAll();
    }
    public List<Transaction> getAllTransactionFiles() {
        return transactionRepo.findAll();
    }
    public List<Loan> getAllLoanFiles() {
        return loanRepo.findAll();
    }
}
