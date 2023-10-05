package com.mbd.validation;
import com.mbd.model.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
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
//    public ValidationResult checkAccountValidation(List<Account> accounts) {
//        List<Account> validAccounts = new ArrayList<>();
//        Map<Account, Set<ConstraintViolation<Account>>> erroneousAccounts = new HashMap<>();
//
//        for (Account account : accounts) {
//            Set<ConstraintViolation<Account>> violations = validator.validate(account);
//            if (!violations.isEmpty()) {
//                // Handle validation errors
//                erroneousAccounts.put(account, violations);
//                for (ConstraintViolation<Account> violation : violations) {
//                    System.out.println("Validation Exception for Account ID: " + account.getAccountID() + ": " + violation.getMessage());
//                }
//            } else {
//                // Your logic if validation passes
//                validAccounts.add(account);
//                System.out.println("All good for Account ID: " + account.getAccountID());
//            }
//        }
//        return new ValidationResult(validAccounts, erroneousAccounts);
//    }
}
