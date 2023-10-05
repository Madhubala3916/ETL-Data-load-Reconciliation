package com.mbd.model;

import jakarta.persistence.*;
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @Column(name = "BranchID", nullable = false)
    private Long branchID;
    @Column(name = "BranchLocation", nullable = false)
    private String branchLocation;
    @Column(name = "BranchCode", nullable = false, unique = true)
    private String branchCode;
    @Column(name = "BranchAddress", nullable = false)
    private String branchAddress;
    @Column(name = "BranchContactNo", nullable = false)
    private String branchContactNo;
    public Branch() {
    }
    public Branch(long branchID, String branchLocation, String branchCode, String branchAddress, String branchContactNo) {
        this.branchID = branchID;
        this.branchLocation = branchLocation;
        this.branchCode = branchCode;
        this.branchAddress = branchAddress;
        this.branchContactNo = branchContactNo;
    }
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
}
