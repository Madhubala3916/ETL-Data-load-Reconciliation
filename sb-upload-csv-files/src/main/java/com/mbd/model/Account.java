package com.mbd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "AccountID", nullable = false)
    private Long accountID;

    @Column(name = "CustomerID", nullable = false)
    private Long customerID;

    @Column(name = "BranchID", nullable = false)
    private Long branchID;

    @NotBlank(message="accountype cannot be blank")
    @Column(name = "AccountType", nullable = false)
    private String accountType;

    @NotNull(message="balance cannot be null")
    @Column(name = "Balance", nullable = false)
    @Min(value=5000,message="The minimum balance should be greater than 4999")
    private Double balance;

    public Account() {
    }

    public Account(Long accountID, Long customerID, Long branchID, String accountType, Double balance) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.branchID = branchID;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String type) {
        this.accountType = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

