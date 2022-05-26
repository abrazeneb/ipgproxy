package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Embeddable
public class Card {

    @Column(name = "card_number")
    private String number;
    @Column(name = "expiry_month")
    private String expiryMonth;
    @Column(name = "expiry_year")
    private String expiryYear;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "holder")
    private String holder;

    @SuppressWarnings("unused")
    protected Card() {
    }

    public Card(String number, String expiryMonth, String expiryYear, String cvv, String holder) {
        this.number = number;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvv = cvv;
        this.holder = holder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number.equals(card.number) && expiryMonth.equals(card.expiryMonth) && expiryYear.equals(card.expiryYear) && cvv.equals(card.cvv) && Objects.equals(holder, card.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, expiryMonth, expiryYear, cvv, holder);
    }
}
