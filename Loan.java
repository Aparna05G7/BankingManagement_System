package com.bank.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @Column(name = "Loan_ID", length = 15)
    private String loanId;

    @Column(name = "Loan_Type", nullable = false, length = 30)
    private String loanType;

    @Column(name = "Amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "Interest_Rate", precision = 5, scale = 2, nullable = false)
    private BigDecimal interestRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_ID", nullable = false)
    private Branch branch;

    public Loan() {}

    // Getters and Setters
    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public BigDecimal getInterestRate() { return interestRate; }
    public void setInterestRate(BigDecimal interestRate) { this.interestRate = interestRate; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }
}
