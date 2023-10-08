package com.mbd.validation;

import com.mbd.model.Account;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountValidationResult {
    private final List<Account> validAccounts;
    private final Map<Account, Set<ConstraintViolation<Account>>> erroneousAccounts;

    public AccountValidationResult(List<Account> validAccounts, Map<Account, Set<ConstraintViolation<Account>>> erroneousAccounts) {
        this.validAccounts = validAccounts;
        this.erroneousAccounts = erroneousAccounts;
    }

    public List<Account> getValidAccounts() {
        return validAccounts;
    }

    public Map<Account, Set<ConstraintViolation<Account>>> getErroneousAccounts() {
        return erroneousAccounts;
    }
}
