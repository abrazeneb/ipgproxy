package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name = "card")
public class Card implements Entity {
    @Column(name = "number")
    private String number;
    @Column(name = "expiryMonth")
    private String expiryMonth;
    @Column(name = "expiryYear")
    private String expiryYear;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "holder")
    private String holder;
    @OneToOne
    private Payment payment;
}
