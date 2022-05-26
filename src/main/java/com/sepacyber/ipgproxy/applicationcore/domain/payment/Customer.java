package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Embeddable
public class Customer {

    @Column(name = "email")
    private String email;
    @Column(name = "given_name")
    private String givenName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "ip")
    private String ip;
    @Column(name = "telnocc")
    private String telnocc;
    @Column(name = "phone")
    private String phone;

    @SuppressWarnings("unused")
    protected Customer() {
    }

    public Customer(String email, String givenName, String surname, String ip, String telnocc, String phone) {
        this.email = email;
        this.givenName = givenName;
        this.surname = surname;
        this.ip = ip;
        this.telnocc = telnocc;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return email.equals(customer.email) && givenName.equals(customer.givenName) && surname.equals(customer.surname) && ip.equals(customer.ip) && telnocc.equals(customer.telnocc) && phone.equals(customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, givenName, surname, ip, telnocc, phone);
    }
}
