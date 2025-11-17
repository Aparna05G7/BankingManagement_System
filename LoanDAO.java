package com.bank.dao;

import com.bank.model.Loan;

public class LoanDAO extends GenericDAO<Loan, String> {
    public LoanDAO() {
        super(Loan.class);
    }
}
