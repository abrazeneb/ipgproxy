package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.AggregateRoot;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Table(name = "payment")
public class Payment extends AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "merchantTransactionId")
    private String merchantTransactionId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "currency")
    private String currency;
    @Column(name = "paymentBrand")
    private String paymentBrand;
    @Column(name = "paymentMode")
    private String paymentMode;
    @Column(name = "paymentType")
    private String paymentType;
    @Column(name = "accountId")
    private Long accountId;
    @Column(name = "terminalId")
    private Long terminalId;

    @OneToOne(mappedBy = "payment")
    private Order order;
    @OneToOne(mappedBy = "payment")
    private Business business;
    @OneToOne(mappedBy = "payment")
    private Card card;
    @OneToOne(mappedBy = "payment")
    private Customer customer;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;



}
