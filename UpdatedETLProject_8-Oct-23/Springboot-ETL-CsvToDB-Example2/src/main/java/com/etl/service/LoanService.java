package com.etl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etl.model.ErrorEntity;
import com.etl.model.Loan;
import com.etl.repository.ErrorRepository;
import com.etl.repository.LoanRepository;
import com.etl.validation.DataValidator;
import com.etl.validation.ValidationResultLoan;

import jakarta.validation.ConstraintViolation;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepo;
	
	@Autowired
	private ErrorRepository errorEntityRepo;
	
	@Autowired
    DataValidator dataValidator;
	
	public void saveLoan(List<Loan> loans) {
		ValidationResultLoan loanValidationResult = dataValidator.checkLoanValidation(loans);
		
		// Continue with saving valid loans...
        List<Loan> validLoans = loanValidationResult.getValidLoans();
        loanRepo.saveAll(validLoans);

        // Handle erroneous loans and violations as needed
        Map<Loan, Set<ConstraintViolation<Loan>>> erroneousLoans = loanValidationResult.getErroneousLoans();
        for (Map.Entry<Loan, Set<ConstraintViolation<Loan>>> entry : erroneousLoans.entrySet()) {
            Loan erroneousLoan = entry.getKey();
            Set<ConstraintViolation<Loan>> violations = entry.getValue();

            System.out.println("Handling erroneous loan: " + erroneousLoan.toString());
            System.out.println("Violations: " + violations);
            // Handle the erroneous loan and violations as needed
            if (!violations.isEmpty()) {
                for (ConstraintViolation<Loan> violation : violations) {
                	ErrorEntity errorEntity = new ErrorEntity();
                    errorEntity.setEntityName("Loan");
                    errorEntity.setErrorMessage("Validation Exception for Loan entity with loan ID " + entry.getKey().getLoanID() + "And with CustomerID " + entry.getKey().getCustomerID() + ": " + violation.getMessage());
//                    errorEntity.setTimestamp(LocalDateTime.now());
                    errorEntityRepo.save(errorEntity);
                }
            } 
        }
	}
	
	public List<Loan> getAllLoanRecords() {
        return loanRepo.findAll();
    }
}
