package com.etl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;

	private double loanAmmount;
	private String LoanType;
	private String interestRate;
	private String term;
	private String status;

	@ManyToOne
	@JoinColumn(name = "accId")
	private Account account;

	public Loan(Long loanId, double loanAmmount, String loanType, String interestRate, String term,
			String status) {
		super();
		this.loanId = loanId;
		this.loanAmmount = loanAmmount;
		LoanType = loanType;
		this.interestRate = interestRate;
		this.term = term;
		this.status = status;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public double getLoanAmmount() {
		return loanAmmount;
	}

	public void setLoanAmmount(double d) {
		this.loanAmmount = d;
	}

	public String getLoanType() {
		return LoanType;
	}

	public void setLoanType(String loanType) {
		LoanType = loanType;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String nextRecord) {
		this.interestRate = nextRecord;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String nextRecord) {
		this.term = nextRecord;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmmount=" + loanAmmount + ", LoanType=" + LoanType + ", interestRate="
				+ interestRate + ", term=" + term + ", status=" + status + ", account=" + account + "]";
	}

}
