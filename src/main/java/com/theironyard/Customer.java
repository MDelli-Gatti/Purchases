package com.theironyard;

import javax.persistence.*;

/**
 * Created by michaeldelli-gatti on 6/22/16.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
