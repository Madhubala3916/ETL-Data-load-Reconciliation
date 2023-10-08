package com.etl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etl.model.Customer;
import com.etl.model.ErrorEntity;
import com.etl.repository.CustomerRepository;
import com.etl.repository.ErrorRepository;
import com.etl.validation.DataValidator;
import com.etl.validation.ValidationResultCustomer;

import jakarta.validation.ConstraintViolation;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	private ErrorRepository errorEntityRepo;

	@Autowired
	DataValidator dataValidator;

	public void saveCustomer(List<Customer> customer1) {
		// customer1 = CSVHelper.customer_func(file.getInputStream());

		ValidationResultCustomer validationResult = dataValidator.checkCustomerValidation(customer1);

		customerRepo.saveAll(validationResult.getValidCustomers());

		Map<Customer, Set<ConstraintViolation<Customer>>> erroneousCustomers = validationResult.getErroneousCustomers();
		for (Map.Entry<Customer, Set<ConstraintViolation<Customer>>> entry : erroneousCustomers.entrySet()) {
			Customer erroneousCustomer = entry.getKey();
			Set<ConstraintViolation<Customer>> violations = entry.getValue();

			System.out.println("Handling erroneous customer: " + erroneousCustomer.toString());
			System.out.println("Violations: " + violations);
			// Handle the erroneous customer and violations as needed
			if (!violations.isEmpty()) {
				for (ConstraintViolation<Customer> violation : violations) {
					ErrorEntity errorEntity = new ErrorEntity();
					errorEntity.setEntityName("Customer");
					errorEntity.setErrorMessage("Validation Exception for customerID: " + entry.getKey().getCustomerID()
							+ ": " + violation.getMessage());
//                errorEntity.setTimestamp(LocalDateTime.now());
					errorEntityRepo.save(errorEntity);
				}
			}
		}
	}
	
	public List<Customer> getAllCustomerRecords(){
		return customerRepo.findAll();
	}
}
