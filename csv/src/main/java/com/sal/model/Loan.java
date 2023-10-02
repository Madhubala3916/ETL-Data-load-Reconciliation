package com.sal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanID")
    private Long loanID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "BankID")
    private Bank bank;

    @Column(name = "LoanAmount")
    private Double loanAmount;

    @Column(name = "LoanType")
    private String loanType;

    @Column(name = "InterestRate")
    private Double interestRate;

    @Column(name = "Term")
    private String term;

    @Column(name = "Status")
    private String status;

    public Loan() {
    }

    public Loan(Long loanID, Customer customer, Bank bank, Double loanAmount, String loanType, Double interestRate, String term, String status) {
        this.loanID = loanID;
        this.customer = customer;
        this.bank = bank;
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.term = term;
        this.status = status;
    }

    public Long getLoanID() {
        return loanID;
    }

    public void setLoanID(Long loanID) {
        this.loanID = loanID;
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

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
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
}
