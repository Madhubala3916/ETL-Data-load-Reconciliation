package com.etl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etl.model.ErrorEntity;
import com.etl.model.Transaction;
import com.etl.repository.ErrorRepository;
import com.etl.repository.TransactionRepository;
import com.etl.validation.DataValidator;
import com.etl.validation.ValidationResultTransaction;

import jakarta.validation.ConstraintViolation;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	private ErrorRepository errorEntityRepo;
	
	@Autowired
    DataValidator dataValidator;

	public void saveTransaction(List<Transaction> transactions) {
		
		ValidationResultTransaction validationResultTransaction = dataValidator.checkTransactionValidation(transactions);

        transactionRepo.saveAll(validationResultTransaction.getValidTransactions());

        Map<Transaction, Set<ConstraintViolation<Transaction>>> erroneousTransactions = validationResultTransaction.getErroneousTransactions();
        for (Map.Entry<Transaction, Set<ConstraintViolation<Transaction>>> entry : erroneousTransactions.entrySet()) {
            Transaction erroneousTransaction = entry.getKey();
            Set<ConstraintViolation<Transaction>> violations = entry.getValue();

            // showing in terminal
            System.out.println("Handling erroneous transaction: " + erroneousTransaction.toString());
            System.out.println("Violations: " + violations );
            // Handle the erroneous customer and violations as needed
            
            if(!violations.isEmpty()){
                // Handle validation errors
                for (ConstraintViolation<Transaction> violation : violations) {
                	ErrorEntity errorEntity = new ErrorEntity();
                    errorEntity.setEntityName("trs");
                    errorEntity.setErrorMessage("Validation Exception for transaction entity with transactionID " + entry.getKey().getTransactionID() +"with accountID"+ entry.getKey().getAccountID()+ ": " + violation.getMessage());
                    
                    errorEntityRepo.save(errorEntity);
                }
            }
        }
	}
	
	public List<Transaction> getAllTransactionRecords() {
        return transactionRepo.findAll();
    }
}
