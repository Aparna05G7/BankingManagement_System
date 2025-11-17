package com.bank.dao;

import com.bank.model.Employee;

public class EmployeeDAO extends GenericDAO<Employee, String> {
    public EmployeeDAO() {
        super(Employee.class);
    }
}
