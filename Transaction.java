package com.bank.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @Column(name = "Transaction_ID", length = 20)
    private String transactionId;

    @Column(name = "Amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "Transaction_Date")
    private Timestamp transactionDate;

    @Column(name = "Transaction_Mode", length = 255)
    private String transactionMode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_No", nullable = false)
    private Account account;

    public Transaction() {}

    // Getters and Setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Timestamp getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }

    public String getTransactionMode() { return transactionMode; }
    public void setTransactionMode(String transactionMode) { this.transactionMode = transactionMode; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
