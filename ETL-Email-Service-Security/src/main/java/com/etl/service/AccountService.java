package com.etl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etl.model.Account;
import com.etl.model.ErrorEntity;
import com.etl.repository.AccountRepository;
import com.etl.repository.ErrorRepository;
import com.etl.validation.DataValidator;
import com.etl.validation.ValidationResultAccount;

import jakarta.validation.ConstraintViolation;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	private ErrorRepository errorEntityRepo;
	
	@Autowired
    DataValidator dataValidator;
	
	public void saveAccount(List<Account> accounts) {
		
		ValidationResultAccount validationResult2 = dataValidator.checkaccountValidation(accounts); // Use BranchValidationResult

        accountRepo.saveAll(validationResult2.getvalidAccounts()); // Use validationResult1

        Map<Account, Set<ConstraintViolation<Account>>> erroneousAccounts = validationResult2.geterroneousAccounts(); // Use validationResult1
        for (Map.Entry<Account, Set<ConstraintViolation<Account>>> entry : erroneousAccounts.entrySet()) {
            Account erroneousAccount = entry.getKey();
            Set<ConstraintViolation<Account>> violations = entry.getValue();

            System.out.println("Handling erroneous account: " + erroneousAccount.toString());
            System.out.println("Violations: " + violations);
            // Handle the erroneous branch and violations as needed
            if (!violations.isEmpty()) {
                
                for (ConstraintViolation<Account> violation : violations) {
                	ErrorEntity errorEntity = new ErrorEntity();
                    errorEntity.setEntityName("Account");
                    errorEntity.setErrorMessage("Validation Exception for account entity with account ID " + entry.getKey().getAccountID()  + ": " + violation.getMessage());
//                    errorEntity.setTimestamp(LocalDateTime.now());
                    errorEntityRepo.save(errorEntity);
                }
            }
        }
	}

	public List<Account> getAllAccountRecords() {
        return accountRepo.findAll();
    }
}
