package com.sepacyber.ipgproxy.provideradapter.ipg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentRequestDto implements Serializable {
    private static final long serialVersionUID = 3847017387618139364L;

    private AuthenticationDto authentication;
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
    private Double createRegistration;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ShippingAddress implements Serializable {

        private static final long serialVersionUID = -6422970862012994655L;
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

        private static final long serialVersionUID = 4019594936981535772L;
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
        //customer ->
        //Customer assets
        //
        private static final long serialVersionUID = 4019594936981535772L;
        private String numbercc;
        private String expiryMonth;
        private String expiryYear;
        private String cvv;
    }
}
