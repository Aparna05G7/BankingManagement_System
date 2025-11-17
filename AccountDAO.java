package com.bank.dao;

import com.bank.model.Account;

public class AccountDAO extends GenericDAO<Account, String> {
    public AccountDAO() {
        super(Account.class);
    }
}
