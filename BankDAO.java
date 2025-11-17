package com.bank.dao;

import com.bank.model.Bank;

public class BankDAO extends GenericDAO<Bank, String> {
    public BankDAO() 
    {
        super(Bank.class);
    }
}
