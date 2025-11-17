package com.bank.dao;

import com.bank.model.Branch;

public class BranchDAO extends GenericDAO<Branch, String> {
    public BranchDAO() {
        super(Branch.class);
    }
}