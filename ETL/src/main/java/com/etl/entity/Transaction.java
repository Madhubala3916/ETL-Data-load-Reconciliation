package com.etl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tId;

	private String transType;
	private double amount;
	private String transDate;

	@ManyToOne
	@JoinColumn(name = "accId")
	private Account account;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long tId, String transType, double amount, String transDate) {
		super();
		this.tId = tId;
		this.transType = transType;
		this.amount = amount;
		this.transDate = transDate;
	}

	public Long gettId() {
		return tId;
	}

	public void settId(Long tId) {
		this.tId = tId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String nextRecord) {
		this.transDate = nextRecord;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", transType=" + transType + ", amount=" + amount + ", transDate="
				+ transDate + ", account=" + account + "]";
	}

}
