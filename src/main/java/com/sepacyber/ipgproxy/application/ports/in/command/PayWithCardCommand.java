package com.sepacyber.ipgproxy.application.ports.in.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayWithCardCommand {
    private static final long serialVersionUID = -1857255447116994574L;

    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String orderDescriptor;
    private ShippingAddress shipping;
    private Customer customer;
    private CommandCard card;
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

        private static final long serialVersionUID = -7598944911317883991L;
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

        private static final long serialVersionUID = -7287232475033060675L;
        private Long customerId;
        private String telnocc;
        private String phone;
        private String email;
        private String givenName;
        private String surname;
        private String ip;
        private String birthDate;

    }
}
