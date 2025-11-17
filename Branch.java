package com.bank.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Branch")
public class Branch {

    @Id
    @Column(name = "Branch_ID", length = 10)
    private String branchId;

    @Column(name = "Branch_Name", nullable = false, length = 100)
    private String branchName;

    @Column(name = "Address", nullable = false, length = 255)
    private String address;

    @Column(name = "Pincode", length = 15)
    private String pincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Bank_Code", nullable = false)
    private Bank bank;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Loan> loans = new HashSet<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Department> departments = new HashSet<>();

    public Branch() {}

    // Getters and Setters
    public String getBranchId() { return branchId; }
    public void setBranchId(String branchId) { this.branchId = branchId; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public Bank getBank() { return bank; }
    public void setBank(Bank bank) { this.bank = bank; }
}
