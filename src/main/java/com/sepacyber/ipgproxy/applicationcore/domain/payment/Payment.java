package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.AggregateRoot;

import java.util.Date;


public class Payment extends AggregateRoot  {
    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private Long accountId;
    private Long terminalId;

    // paymentId??

    private Order order;
    private Business business;

    private Card card;
    private Customer customer;

    private Date createdDate;
}
