package com.etl.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;

	private String branchLocation;
	private String branchCode;
	private String branchAddress;
	private String branchContact;

	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
	private List<Account> accounts;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(int bid, String branchLocation, String branchCode, String branchAddress, String branchContact) {
		super();
		this.bid = bid;
		this.branchLocation = branchLocation;
		this.branchCode = branchCode;
		this.branchAddress = branchAddress;
		this.branchContact = branchContact;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBranchContact() {
		return branchContact;
	}

	public void setBranchContact(String branchContact) {
		this.branchContact = branchContact;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", branchLocation=" + branchLocation + ", branchCode=" + branchCode
				+ ", branchAddress=" + branchAddress + ", branchContact=" + branchContact + ", accounts=" + accounts
				+ "]";
	}

}
