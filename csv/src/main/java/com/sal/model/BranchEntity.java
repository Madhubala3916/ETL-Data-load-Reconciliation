package com.sal.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
//@Table(name = "Branch")
public class BranchEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchID;
	  private String branchLocation;
	  private String branchCode;
	  private String branchAddress;
	  private String branchContactNo;
	public Long getBranchID() {
		return branchID;
	}
	public void setBranchID(Long branchID) {
		this.branchID = branchID;
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
	public String getBranchContactNo() {
		return branchContactNo;
	}
	public void setBranchContactNo(String branchContactNo) {
		this.branchContactNo = branchContactNo;
	}
	public BranchEntity(Long branchID, String branchLocation, String branchCode, String branchAddress,
			String branchContactNo) {
		super();
		this.branchID = branchID;
		this.branchLocation = branchLocation;
		this.branchCode = branchCode;
		this.branchAddress = branchAddress;
		this.branchContactNo = branchContactNo;
	}
	public BranchEntity() {
		
	}

    
}
