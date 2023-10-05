package com.mbd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID", nullable = false, unique = true)
    private Long accountID;

    @NotNull(message = "Customer ID cannot be null")
    @Column(name = "CustomerID", nullable = false)
    private Long customerID;

    @NotNull(message = "Branch ID cannot be null")
    @Column(name = "BranchID", nullable = false)
    private Long branchID;

    @Pattern(regexp = "^(savings|credit|checking)$", message = "Invalid account type. Allowed values are savings, credit, checking.")
    @NotEmpty(message = "Account type cannot be empty")
    @Size(max = 255, message = "Account type must not exceed 255 characters")
    @Column(name = "AccountType", nullable = false)
    private String accountType;

    @NotNull(message = "Balance cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than 0")
    @Column(name = "Balance", nullable = false)
    private Double balance;
    public Account() {
    }
    public Account(Long customerID, Long branchID, String accountType, Double balance) {
        this.customerID = customerID;
        this.branchID = branchID;
        this.accountType = accountType;
        this.balance = balance;
    }
    public Account(Long accountID, Long customerID, Long branchID, String accountType, Double balance) {
    }
    public Long getAccountID() {
        return accountID;
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

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
