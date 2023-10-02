package com.sal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Long accountID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "BankID")
    private Bank bank;

    @Column(name = "Type")
    private String type;

    @Column(name = "Balance")
    private Double balance;
    
    

    public Account() {
    }

    public Account(Long accountID, Customer customer, Bank bank, String type, Double balance) {
        this.accountID = accountID;
        this.customer = customer;
        this.bank = bank;
        this.type = type;
        this.balance = balance;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setCustomerID(long parseLong) {
    }

    public void setBankID(long parseLong) {
    }
}
