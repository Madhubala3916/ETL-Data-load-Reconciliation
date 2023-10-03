package com.etl.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etl.entity.Account;
import com.etl.entity.Branch;
import com.etl.entity.Customer;
import com.etl.entity.Loan;
import com.etl.entity.Transaction;
import com.etl.repository.AccountRepo;
import com.etl.repository.BranchRepo;
import com.etl.repository.CustomerRepo;
import com.etl.repository.LoanRepo;
import com.etl.repository.TransactionRepo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


@Service
public class MainService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private LoanRepo loanRepo;

	@Autowired
	private BranchRepo branchRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private TransactionRepo transactionRepo;

	public void readCsvAndInsertData(String path) throws FileNotFoundException, IOException, CsvException {
		try (FileReader reader = new FileReader(path); CSVReader csvReader = new CSVReader(reader)) {

			Customer customer = new Customer();
			Loan loan = new Loan();
			Branch branch = new Branch();
			Transaction transaction = new Transaction();
			Account account = new Account();

			String[] nextRecord;
            boolean isFirstLine = true; 
			while ((nextRecord = csvReader.readNext()) != null) {
				if(isFirstLine){
					isFirstLine=false;
					continue;
				}
				System.out.println("Reading : " + Arrays.toString(nextRecord));

				try {

					// set customer values in customer table
					customer.setCid(Long.parseLong(nextRecord[0]));
					customer.setFirstname(nextRecord[1]);
					customer.setLastname(nextRecord[2]);
					customer.setAddress(nextRecord[3]);
					customer.setContact(nextRecord[4]);
					customer.setEmail(nextRecord[5]);

					// set branch values in branch table
					branch.setBid(Integer.parseInt(nextRecord[6]));
					branch.setBranchLocation(nextRecord[7]);
					branch.setBranchCode(nextRecord[8]);
					branch.setBranchAddress(nextRecord[9]);
					branch.setBranchContact(nextRecord[10]);

					// set account details in table
					account.setAccId(Long.parseLong(nextRecord[11]));
					account.setAccType(nextRecord[12]);
					account.setBalance(Double.parseDouble(nextRecord[13]));
					account.setCustomer(customer);
					account.setBranch(branch);

					// set transaction records
					transaction.settId(Long.parseLong(nextRecord[14]));
					transaction.setTransType(nextRecord[15]);
					transaction.setAmount(Double.parseDouble(nextRecord[16]));
					transaction.setTransDate(nextRecord[17]);
					transaction.setAccount(account);

					// set loan records
					loan.setLoanId(Long.parseLong(nextRecord[18]));
					loan.setLoanAmmount(Double.parseDouble(nextRecord[19]));
					loan.setLoanType(nextRecord[20]);
					loan.setInterestRate(nextRecord[21]);
					loan.setTerm(nextRecord[22]);
					loan.setStatus(nextRecord[23]);
					loan.setAccount(account);
					
					
					customerRepo.save(customer);
					branchRepo.save(branch);
					accountRepo.save(account);
					transactionRepo.save(transaction);
					loanRepo.save(loan);

				} catch (Exception e) {
					System.err.println("Error parsing data: " + e.getMessage());
				}

			}

		}

	}

}
