package com.bank.dao;

import com.bank.model.Transaction;

public class TransactionDAO extends GenericDAO<Transaction, String> {
    public TransactionDAO() {
        super(Transaction.class);
    }
}
