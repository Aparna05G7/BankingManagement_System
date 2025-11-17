package com.bank.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @Column(name = "Card_ID", length = 20)
    private String cardId;

    @Column(name = "Card_Type", nullable = false, length = 100)
    private String cardType;

    @Column(name = "Card_HolderName", nullable = false, length = 100)
    private String cardHolderName;

    @Temporal(TemporalType.DATE)
    @Column(name = "Expiry_Date", nullable = false)
    private Date expiryDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "Issue_Date", nullable = false)
    private Date issueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_No", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    public Card() {}

    // Getters and Setters
    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getCardHolderName() { return cardHolderName; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
