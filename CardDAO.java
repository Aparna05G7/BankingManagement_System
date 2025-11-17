package com.bank.dao;

import com.bank.model.Card;

public class CardDAO extends GenericDAO<Card, String> {
    public CardDAO() {
        super(Card.class);
    }
}
