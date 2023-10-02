package com.sal.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private Long customerID;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNo;
    private String emailID;
//    private Long branchID;
//    private String branchLocation;
//    private String branchCode;
//    private String branchAddress;
//    private String branchContactNo;
//    private Long accountID;
//    private String accountType;
//    private Double balance;
//    private Long transactionID;
//    private String transactionType;
//    private Double transactionAmount;
//    private String transactionDate;
////    private Long loanID;
//    private Double loanAmount;
//    private String loanType;
//    private String interestRate;
//    private String term;
//    private String status;

    public Customer() {

    }

   

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Customer(Long customerID, String firstName, String lastName, String address, String contactNo, String emailID) {
        
        this.customerID = customerID;
        this.firstName = firstName; 
        this.lastName = lastName;
        this.address = address;
        this.contactNo = contactNo;
        this.emailID = emailID;
     
    }
}
