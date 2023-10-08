package com.mbd.validation;

import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mbd.model.Account;
import com.mbd.model.Loan;

public class ValidationResultAccount {
    private final List<Account> validAccounts;
    private final Map<Account, Set<ConstraintViolation<Account>>> erroneousAccounts;

    public ValidationResultAccount(List<Account> validAccounts, Map<Account, Set<ConstraintViolation<Account>>> erroneousAccounts) {
        this.validAccounts = validAccounts;
        this.erroneousAccounts = erroneousAccounts;
    }

    public List<Account> getvalidAccounts() {
        return validAccounts;
    }

    public Map<Account, Set<ConstraintViolation<Account>>> geterroneousAccounts() {
        return erroneousAccounts;
    }
}
