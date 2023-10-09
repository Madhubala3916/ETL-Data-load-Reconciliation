package com.etl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.etl.cleaner.DataCleaner;
import com.etl.helper.CSVHelper;
import com.etl.model.Account;
import com.etl.model.Branch;
import com.etl.model.Customer;
import com.etl.model.ErrorEntity;
import com.etl.model.Loan;
import com.etl.model.Transaction;
import com.etl.repository.AccountRepository;
import com.etl.repository.BranchRepository;
import com.etl.repository.CustomerRepository;
import com.etl.repository.ErrorRepository;
import com.etl.repository.LoanRepository;
import com.etl.repository.TransactionRepository;
import com.etl.validation.DataValidator;
import com.etl.validation.ValidationResultAccount;
import com.etl.validation.ValidationResultBranch;
import com.etl.validation.ValidationResultCustomer;
import com.etl.validation.ValidationResultLoan;
import com.etl.validation.ValidationResultTransaction;

@Service
public class CSVService {
	
	@Autowired
	CustomerRepository customerRepo;
	
//	@Autowired
//	BranchRepository branchRepo;
//	
//	@Autowired
//	AccountRepository accountRepo;
//	
//	@Autowired
//	LoanRepository loanRepo;
//	
//	@Autowired
//	TransactionRepository transactionRepo;
//	
//	@Autowired
//    private ErrorRepository errorEntityRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
    DataValidator dataValidator;
	
	@Autowired
    private DataCleaner dataCleaner;
	
	List<Customer> customer1 = new ArrayList<>();
	
	public void saveInDB(MultipartFile file) {
        try {

        	//customer1 = CSVHelper.customer_func(file.getInputStream());
        	
        	customer1 = dataCleaner.cleanData(CSVHelper.customer_func(file.getInputStream()));
        	customerService.saveCustomer(customer1);

            //----------------branch-----------
            List<Branch> branches = CSVHelper.branch_func(file.getInputStream());
            branchService.saveBranch(branches);
            
            //-----------------account-----------------
            List<Account> account1 = CSVHelper.account_func(file.getInputStream());
            accountService.saveAccount(account1);
            
            //---------------transactions----
            List<Transaction> transaction1 = CSVHelper.transaction_func(file.getInputStream());
            transactionService.saveTransaction(transaction1);
            
            //-------------------LOAN-----
            List<Loan> loanList= CSVHelper.loan_func(file.getInputStream());
            loanService.saveLoan(loanList);

        } catch (IOException e) {
            throw new RuntimeException("failed to store csv data: " + e.getMessage());
        }
    }
	
	
	public void justDisplay() {
		System.out.println("Just displaying customers");
		for(Customer customer : customer1) {
			System.out.println(customer.toString());
		}
	}
	
	public long getCustomerCount(){
        return customerRepo.count();
    }
	
	public void getReport() {
		long dbCustomerCount = getCustomerCount();
		long customerCount = customer1.size();
		if(dbCustomerCount==customerCount) {
			//generate error report
		}
	}
}
