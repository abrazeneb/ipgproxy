package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "customer")
public class Customer implements Entity {
    @Column(name = "email")
    private String email;
    @Column(name = "givenName")
    private String givenName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "ip")
    private String ip;
    @Column(name = "telnocc")
    private String telnocc;
    @Column(name = "phone")
    private String phone;
    @OneToOne
    private Payment payment;
}
