package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@javax.persistence.Entity
@Table(name = "order")
public class Order implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne
    private Payment payment;
}
