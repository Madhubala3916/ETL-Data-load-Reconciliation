package com.etl.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	private String firstname;
	private String lastname;
	private String address;

	@Column(unique = true)
	private String contact;
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> account;

	public Customer() {
		super();
	}

	public Customer(Long cid, String firstname, String lastname, String address, String contact, String email) {
		super();
		this.cid = cid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + ", account=" + account + "]";
	}

}