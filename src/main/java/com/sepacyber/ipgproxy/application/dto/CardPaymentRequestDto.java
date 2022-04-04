package com.sepacyber.ipgproxy.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardPaymentRequestDto implements Serializable {
    private static final long serialVersionUID = -7386611585973460668L;

    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String orderDescriptor;
    private ShippingAddress shipping;
    private Customer customer;
    private Card card;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private String merchantRedirectUrl;
    private String notificationUrl;
    private String recurringType;
    private Double tmpl_amount;
    private String tmpl_currency;
    private Boolean createRegistration;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ShippingAddress implements Serializable {

        private static final long serialVersionUID = 8146342246740707664L;
        private String country;
        private String city;
        private String state;
        private String postcode;
        private String street1;
        private String telnocc;
        private String phone;
        private String email;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Customer implements Serializable {

        private static final long serialVersionUID = -3649915172023934060L;
        private Long customerId;
        private String telnocc;
        private String phone;
        private String email;
        private String givenName;
        private String surname;
        private String ip;
        private String birthDate;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Card implements Serializable {

        private static final long serialVersionUID = 3422889931659967612L;
        private String numbercc;
        private String expiryMonth;
        private String expiryYear;
        private String cvv;

    }
}
