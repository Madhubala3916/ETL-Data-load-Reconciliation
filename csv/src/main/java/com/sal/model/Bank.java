package com.sal.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BankID")
    private Long bankID;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "BranchLocation")
    private String branchLocation;

    @Column(name = "ContactNo")
    private String contactNo;

    @Column(name = "EmailID")
    private String emailID;

    public Bank() {
    }

    public Bank(Long bankID, String bankName, String branchLocation, String contactNo, String emailID) {
        this.bankID = bankID;
        this.bankName = bankName;
        this.branchLocation = branchLocation;
        this.contactNo = contactNo;
        this.emailID = emailID;
    }

    public Long getBankID() {
        return bankID;
    }

    public void setBankID(Long bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
