package com.bank.dao;

import com.bank.model.Customer;
public class CustomerDAO extends GenericDAO<Customer, String> {
    public CustomerDAO() {
        super(Customer.class);
    }
}