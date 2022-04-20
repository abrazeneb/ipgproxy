package com.sepacyber.ipgproxy.applicationcore.ports.out;

import an.awesome.pipelinr.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProcessedEvent implements Notification {

    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private Long accountId;
    private Long terminalId;

    private UUID orderId;
    private UUID businessId;

    private Card card;
    private Customer customer;

    private long processedAt;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Card {
        private String number;
        private String expiryMonth;
        private String expiryYear;
        private String cvv;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Customer {
        private String email;
        private String givenName;
        private String surname;
        private String ip;
        private String telnocc;
        private String phone;
    }
}
