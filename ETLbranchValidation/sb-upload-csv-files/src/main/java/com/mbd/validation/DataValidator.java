package com.mbd.validation;

import com.mbd.model.Branch;
import com.mbd.model.Customer;
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

    public ValidationResult checkCustomerValidation(List<Customer> customer1){
        List<Customer> validCustomers = new ArrayList<>();
        Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers = new HashMap<>();

        for(Customer cust:customer1){
            Set<ConstraintViolation<Customer>> violations = validator.validate(cust);

            if (!violations.isEmpty()) {
                // Handle validation errors
                erroneousCustomers.put(cust, violations);
//                for (ConstraintViolation<Customer> violation : violations) {
//                    System.out.println("Validation Exception for cutomer EmailId: "+cust.getFirstName()+" "
//                            +cust.getEmailID()+": "+violation.getMessage());
//                }
            } else {
                // Your logic if validation passes
                validCustomers.add(cust);
                System.out.println("All good for "+cust.getFirstName()+" "+cust.getEmailID());
            }
        }

        return new ValidationResult(validCustomers, erroneousCustomers);
    }
    public BranchValidationResult checkBranchValidation(List<Branch> branches) {
        List<Branch> validBranches = new ArrayList<>();
        Map<Branch, Set<ConstraintViolation<Branch>>> erroneousBranches = new HashMap<>();

        for (Branch branch : branches) {
            Set<ConstraintViolation<Branch>> violations = validator.validate(branch);

            if (!violations.isEmpty()) {
                // Handle validation errors
                erroneousBranches.put(branch, violations);
                // Log or handle violations as needed
            } else {
                // Your logic if validation passes
                validBranches.add(branch);
                System.out.println("All good for branch: " + branch.getBranchLocation());
            }
        }

        return new BranchValidationResult(validBranches, erroneousBranches);
    }
}
