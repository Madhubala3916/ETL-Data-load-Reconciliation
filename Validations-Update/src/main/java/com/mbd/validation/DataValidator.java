package com.mbd.validation;

import com.mbd.model.Customer;
import com.mbd.model.Transaction;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataValidator {
    private final Validator validator;

    public DataValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public ValidationResultCustomer checkCustomerValidation(List<Customer> customer1){
        List<Customer> validCustomers = new ArrayList<>();
        Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers = new HashMap<>();

        for (Customer cust:customer1){
            Set<ConstraintViolation<Customer>> violations = validator.validate(cust);

            if(!violations.isEmpty()){
                // Handle validation errors
                erroneousCustomers.put(cust,violations);
//                for (ConstraintViolation<Customer> violation : violations) {
//                    System.out.println("Validation Exception for cutomer EmailId: " + cust.getFirstName() + " "
//                            + cust.getEmailID() + ": " + violation.getMessage());
//                }
            }
            else {
                // Your logic if validation passes
                validCustomers.add(cust);
                System.out.println("All good for " + cust.getFirstName() + " " + cust.getEmailID());
            }
        }
        return new ValidationResultCustomer(validCustomers, erroneousCustomers);
    }

    public ValidationResultTransaction checkTransactionValidation(List<Transaction> transaction1){
        List<Transaction> validTransactions = new ArrayList<>();
        Map<Transaction, Set<ConstraintViolation<Transaction>>> erroneousTransactions = new HashMap<>();

        for (Transaction trs:transaction1){
            Set<ConstraintViolation<Transaction>> violations = validator.validate(trs);

            if(!violations.isEmpty()){
                // Handle validation errors
                erroneousTransactions.put(trs,violations);
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
