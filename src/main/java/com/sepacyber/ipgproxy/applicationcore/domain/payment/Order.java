package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@Getter
@Embeddable
public class Order{
    @Column(name = "order_id")
    private String orderId;

    @SuppressWarnings("unused")
    protected Order() {
    }

    public Order(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
