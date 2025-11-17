package com.bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "Employee_ID", length = 10)
    private String employeeId;

    @Column(name = "Employee_Name", nullable = false, length = 100)
    private String employeeName;

    @Column(name = "Phone_No", length = 15)
    private String phoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_ID", nullable = false)
    private Branch branch;

    public Employee() {}

    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }
}
