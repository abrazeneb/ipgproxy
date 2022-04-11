package com.sepacyber.ipgproxy.application.ports.in.command;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class AsyncPaymentCommand {
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
    private Map<String, String> paymentAdditionalData;
    private Long accountId;
    private Long terminalId;
}
