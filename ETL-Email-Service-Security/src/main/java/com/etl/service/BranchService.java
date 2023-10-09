package com.etl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etl.model.Branch;
import com.etl.model.ErrorEntity;
import com.etl.repository.BranchRepository;
import com.etl.repository.ErrorRepository;
import com.etl.validation.DataValidator;
import com.etl.validation.ValidationResultBranch;

import jakarta.validation.ConstraintViolation;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepo;
	
	@Autowired
	private ErrorRepository errorEntityRepo;
	
	@Autowired
    DataValidator dataValidator;
	
	public void saveBranch(List<Branch> branches) {
		
		ValidationResultBranch validationResult1 = dataValidator.checkBranchValidation(branches); // Use BranchValidationResult

        branchRepo.saveAll(validationResult1.getValidBranches()); // Use validationResult1

        Map<Branch, Set<ConstraintViolation<Branch>>> erroneousBranches = validationResult1.getErroneousBranches(); // Use validationResult1
        for (Map.Entry<Branch, Set<ConstraintViolation<Branch>>> entry : erroneousBranches.entrySet()) {
            Branch erroneousBranch = entry.getKey();
            Set<ConstraintViolation<Branch>> violations = entry.getValue();

            System.out.println("Handling erroneous branch: " + erroneousBranch.toString());
            System.out.println("Violations: " + violations);
            // Handle the erroneous branch and violations as needed
            if (!violations.isEmpty()) {
                // Handle validation errors
                for (ConstraintViolation<Branch> violation : violations) {
                	ErrorEntity errorEntity = new ErrorEntity();
                    errorEntity.setEntityName("Branch");
                    errorEntity.setErrorMessage("Validation Exception for Branch entity with BranchID " + entry.getKey().getBranchID() + ": " + violation.getMessage());
                    
                    errorEntityRepo.save(errorEntity);
                }
            }
        }
	}
	
	public List<Branch> getAllBranchRecords() {
        return branchRepo.findAll();
    }
}
