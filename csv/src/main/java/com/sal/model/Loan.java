package com.sal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Loan {
	
		@Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long loanID;
	    private Double loanAmount;
	    private String loanType;
	    private String interestRate;
	    private String term;
	    private String status;  
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "customerID")
	    private Customer customer;

		public Long getLoanID() {
			return loanID;
		}

		public void setLoanID(Long loanID) {
			this.loanID = loanID;
		}

		public Double getLoanAmount() {
			return loanAmount;
		}

		public void setLoanAmount(Double loanAmount) {
			this.loanAmount = loanAmount;
		}

		public String getLoanType() {
			return loanType;
		}

		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}

		public String getInterestRate() {
			return interestRate;
		}

		public void setInterestRate(String interestRate) {
			this.interestRate = interestRate;
		}

		public String getTerm() {
			return term;
		}

		public void setTerm(String term) {
			this.term = term;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Loan(Long loanID, Double loanAmount, String loanType, String interestRate, String term, String status,
				Customer customer) {
			super();
			this.loanID = loanID;
			this.loanAmount = loanAmount;
			this.loanType = loanType;
			this.interestRate = interestRate;
			this.term = term;
			this.status = status;
			this.customer = customer;
		}

		public Loan() {
			
		}
	    
//	    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "branchID")
//    private BranchEntity branch;
	    

}
