package com.sal.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long transactionID;
    @ManyToOne
    @JoinColumn(name = "AccountID")
    private Account account;
    @Column(name = "TransactionType")
    private String transactionType;
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "TransactionDate")
    private LocalDateTime transactionDate;

    public Transaction() {
    }

    public Transaction(Long transactionID, Account account, String transactionType, Double amount, LocalDateTime transactionDate) {
        this.transactionID = transactionID;
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}