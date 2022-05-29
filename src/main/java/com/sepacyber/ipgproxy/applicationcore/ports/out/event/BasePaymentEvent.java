package com.sepacyber.ipgproxy.applicationcore.ports.out.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BasePaymentEvent {

    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private Long accountId;
    private Long terminalId;

    private UUID orderId;
    private PaymentProcessedEvent.Organization organization;

    private PaymentProcessedEvent.Card card;
    private PaymentProcessedEvent.Customer customer;

    private long timestamp;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Card {
        private String number;
        private String expiryMonth;
        private String expiryYear;
        private String cvv;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Customer {
        private String email;
        private String givenName;
        private String surname;
        private String ip;
        private String telnocc;
        private String phone;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Organization {
        private String id;
        private String legalName;
        private String tradingName;
        private long tenantId;
        private String tenantName;
    }
}