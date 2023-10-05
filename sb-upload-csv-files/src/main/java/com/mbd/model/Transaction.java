package com.mbd.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "TransactionID", nullable = false)
    private Long transactionID;
    @Column(name = "AccountID", nullable = false)
    private Long accountID;
    @Column(name = "TransactionType", nullable = false)
    private String transactionType;
    @Column(name = "TransactionAmount", nullable = false)
    private Double transactionAmount;
    @Column(name = "TransactionDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    public Transaction() {
    }
    public Transaction(Long transactionID, Long accountID, String transactionType, Double transactionAmount, Date transactionDate) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }
    public Long getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }
    public Long getAccountID() {
        return accountID;
    }
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
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
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}

