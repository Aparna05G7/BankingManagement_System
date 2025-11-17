package com.bank.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "Customer_ID", length = 15)
    private String customerId;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "Address", nullable = false, length = 255)
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Loan> loans = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards = new HashSet<>();

    public Customer() {}

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
