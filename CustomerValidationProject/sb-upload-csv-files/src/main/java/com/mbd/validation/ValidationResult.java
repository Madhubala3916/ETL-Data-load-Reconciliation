package com.mbd.validation;

import com.mbd.model.Customer;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidationResult {
    private final List<Customer> validCustomers;
    private final Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers;

    public ValidationResult(List<Customer> validCustomers, Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers) {
        this.validCustomers = validCustomers;
        this.erroneousCustomers = erroneousCustomers;
    }

    public List<Customer> getValidCustomers() {
        return validCustomers;
    }

    public Map<Customer, Set<ConstraintViolation<Customer>>> getErroneousCustomers() {
        return erroneousCustomers;
    }
}
