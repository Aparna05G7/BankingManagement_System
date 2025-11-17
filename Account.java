package com.bank.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "Account_No", length = 20)
    private String accountNo;

    @Column(name = "Account_Type", nullable = false, length = 20)
    private String accountType;

    @Column(name = "Balance", precision = 15, scale = 2)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_ID", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards = new HashSet<>();

    public Account() {}

    // Getters and Setters
    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }
}
