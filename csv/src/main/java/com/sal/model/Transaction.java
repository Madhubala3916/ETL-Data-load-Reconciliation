package com.sal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionID;
    private String transactionType;
    private Double transactionAmount;
    private String transactionDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
    private Account acc;

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public Transaction(Long transactionID, String transactionType, Double transactionAmount, String transactionDate,
			Account acc) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.acc = acc;
	}

	public Transaction() {
		
	}
    

}
