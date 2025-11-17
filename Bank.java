package com.bank.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @Column(name = "Bank_Code", length = 10)
    private String bankCode;

    @Column(name = "Bank_Name", nullable = false, length = 100)
    private String bankName;

    @Column(name = "Address", nullable = false, length = 255)
    private String address;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Branch> branches = new HashSet<>();

    public Bank() {}

    // Getters and Setters
    public String getBankCode() { return bankCode; }
    public void setBankCode(String bankCode) { this.bankCode = bankCode; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Set<Branch> getBranches() { return branches; }
    public void setBranches(Set<Branch> branches) { this.branches = branches; }
}
