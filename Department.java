package com.bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name = "Dept_ID", length = 20)
    private String deptId;

    @Column(name = "Dept_Name", nullable = false, length = 100)
    private String deptName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_ID", nullable = false)
    private Branch branch;

    public Department() {}

    // Getters and Setters
    public String getDeptId() { return deptId; }
    public void setDeptId(String deptId) { this.deptId = deptId; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }
}
