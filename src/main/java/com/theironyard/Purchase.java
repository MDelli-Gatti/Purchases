package com.theironyard;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by michaeldelli-gatti on 6/22/16.
 */
public class Purchase {
    @Id
    @GeneratedValue
    int customerId;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    String cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {
    }

    public Purchase(int customerId, String date, String creditCard, String cvv, String category, Customer customer) {
        this.customerId = customerId;
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }
}
