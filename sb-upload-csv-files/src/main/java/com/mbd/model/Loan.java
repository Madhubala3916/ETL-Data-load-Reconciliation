package com.mbd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @Column(name = "LoanID", nullable = false)
    private Long loanID;
    @Column(name = "CustomerID", nullable = false)
    private Long customerID;
    @Column(name = "BranchID", nullable = false)
    private Long branchID;
    @Column(name = "LoanAmount", nullable = false)
    private Double loanAmount;
    @Column(name = "LoanType", nullable = false)
    private String loanType;
    @Column(name = "InterestRate", nullable = false)
    private Double interestRate;
    @Column(name = "Term", nullable = false)
    private String term;
    @Column(name = "Status", nullable = false)
    private String status;
    public Loan() {
    }
    public Loan(Long loanID, Long customerID, Long branchID, Double loanAmount, String loanType, Double interestRate, String term, String status) {
        this.loanID = loanID;
        this.customerID = customerID;
        this.branchID = branchID;
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
