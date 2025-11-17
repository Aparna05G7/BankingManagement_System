package com.bank.dao;

import com.bank.model.Department;

public class DepartmentDAO extends GenericDAO<Department, String> {
    public DepartmentDAO() {
        super(Department.class);
    }
}

