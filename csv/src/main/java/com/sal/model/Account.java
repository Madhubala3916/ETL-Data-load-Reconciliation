package com.sal.model;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Account {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountID;
    private String accountType;
    private Double balance;
//    private Long customerID;
//    private Long branchID;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerID")
    private Customer customer;
    
   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "branchID")
   private BranchEntity branch;
//
	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public Account(Long accountID, String accountType, Double balance, Customer customer, BranchEntity branch) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
		this.customer = customer;
		this.branch = branch;
	}

	public Account() {
		
	}
    
    
    

}
