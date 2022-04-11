package com.sepacyber.ipgproxy.application.ports.in.command;

import lombok.Data;

import java.util.Map;

@Data
public class ThreeDSecurPaymentCommand {
    private static final long serialVersionUID = 952810596026829096L;
    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private String merchantRedirectUrl;
    private String orderDescriptor;
    private CommandShippingAddress shipping;
    private CommandCustomer customer;
    private String notificationUrl;
    private String recurringType;
    private Double tmpl_amount;
    private String tmpl_currency;
    private Boolean createRegistration;
    private String paymentId;
    private String registrationId;
   private CommandDeviceDetail deviceDetails;
    private CommandCard card;
    private String attemptThreeD;
    private String paymentProvider;
    private String virtualPrivateAddress;
    private Map<String, String> paymentAdditionalData;
    private Long accountId;
    private Long terminalId;
}
