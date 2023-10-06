package com.mbd.validation;

import com.mbd.model.Branch;
import com.mbd.model.Customer;
import com.mbd.model.Loan;
import com.mbd.model.Transaction;
import com.mbd.model.errorEntity;
import com.mbd.repository.errorRepo;
import com.mbd.service.CSVService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataValidator {

    private final Validator validator;

    //@Autowired
    public DataValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Autowired
    private errorRepo errorEntityRepo; // You need to create this repository.

    public ValidationResult checkCustomerValidation(List<Customer> customer1) {
        List<Customer> validCustomers = new ArrayList<>();
        Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers = new HashMap<>();

        for (Customer cust : customer1) {
            Set<ConstraintViolation<Customer>> violations = validator.validate(cust);

            if (!violations.isEmpty()) {
                // Handle validation errors
                erroneousCustomers.put(cust, violations);

                // Create and save an error entity for each violation
                for (ConstraintViolation<Customer> violation : violations) {
                    errorEntity errorEntity = new errorEntity();
                    errorEntity.setEntityName("Customer");
                    errorEntity.setErrorMessage("Validation Exception for customerID: " + cust.getCustomerID()  + ": " + violation.getMessage());
//                    errorEntity.setTimestamp(LocalDateTime.now());
                    errorEntityRepo.save(errorEntity);
                }
            } else {
                // Your logic if validation passes
                validCustomers.add(cust);
                System.out.println("All good for " + cust.getFirstName() + " " + cust.getEmailID());
            }
        }

        return new ValidationResult(validCustomers, erroneousCustomers);
    }

    //------------LOAN--------
    public ValidationResultLoan checkLoanValidation(List<Loan> loanList) {
        List<Loan> validLoans = new ArrayList<>();
        Map<Loan, Set<ConstraintViolation<Loan>>> erroneousLoans = new HashMap<>();

        for (Loan loan : loanList) {
            Set<ConstraintViolation<Loan>> violations = validator.validate(loan);

            if (!violations.isEmpty()) {
                erroneousLoans.put(loan, violations);
                for (ConstraintViolation<Loan> violation : violations) {
                    errorEntity errorEntity = new errorEntity();
                    errorEntity.setEntityName("Loan");
                    errorEntity.setErrorMessage("Validation Exception for Loan entity with loan ID " + loan.getLoanID() + "And with CustomerID " + loan.getCustomerID() + ": " + violation.getMessage());
//                    errorEntity.setTimestamp(LocalDateTime.now());
                    errorEntityRepo.save(errorEntity);
                }
            } else {
                validLoans.add(loan);
            }
        }

        return new ValidationResultLoan(validLoans, erroneousLoans);
    }
    //-----------------branch------------
    public BranchValidationResult checkBranchValidation(List<Branch> branches) {
        List<Branch> validBranches = new ArrayList<>();
        Map<Branch, Set<ConstraintViolation<Branch>>> erroneousBranches = new HashMap<>();

        for (Branch branch : branches) {
            Set<ConstraintViolation<Branch>> violations = validator.validate(branch);

            if (!violations.isEmpty()) {
                // Handle validation errors
                erroneousBranches.put(branch, violations);
                for (ConstraintViolation<Branch> violation : violations) {
                    errorEntity errorEntity = new errorEntity();
                    errorEntity.setEntityName("Branch");
                    errorEntity.setErrorMessage("Validation Exception for Branch entity with BranchID " + branch.getBranchID() + ": " + violation.getMessage());
                    
                    errorEntityRepo.save(errorEntity);
                }
            } else {
                // Your logic if validation passes
                validBranches.add(branch);
                System.out.println("All good for branch: " + branch.getBranchLocation());
            }
        }

        return new BranchValidationResult(validBranches, erroneousBranches);
    }
    //-----------------------Transactions-------------
    public ValidationResultTransaction checkTransactionValidation(List<Transaction> transaction1){
        List<Transaction> validTransactions = new ArrayList<>();
        Map<Transaction, Set<ConstraintViolation<Transaction>>> erroneousTransactions = new HashMap<>();

        for (Transaction trs:transaction1){
            Set<ConstraintViolation<Transaction>> violations = validator.validate(trs);

            if(!violations.isEmpty()){
                // Handle validation errors
                erroneousTransactions.put(trs,violations);
                for (ConstraintViolation<Transaction> violation : violations) {
                    errorEntity errorEntity = new errorEntity();
                    errorEntity.setEntityName("trs");
                    errorEntity.setErrorMessage("Validation Exception for transaction entity with transactionID " + trs.getTransactionID() +"with accountID"+ trs.getAccountID()+ ": " + violation.getMessage());
                    
                    errorEntityRepo.save(errorEntity);
                }
            }
            else {
                // Your logic if validation passes
                validTransactions.add(trs);
//                System.out.println("All good for " + trs.getFirstName() + " " + trs.getEmailID());
            }
        }
        return new ValidationResultTransaction(validTransactions, erroneousTransactions);
    }
}
