package com.etl.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accId;

	private String accType;
	private double balance;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "bid")
	private Branch branch;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Loan> loan;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long accId, String accType, double balance) {
		super();
		this.accId = accId;
		this.accType = accType;
		this.balance = balance;
	}

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double d) {
		this.balance = d;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accType=" + accType + ", balance=" + balance + ", customer=" + customer
				+ ", branch=" + branch + ", transactions=" + transactions + ", loan=" + loan + "]";
	}

}
