package com.sepacyber.ipgproxy.application.ports.in.command;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SynchronousPaymentCommand implements Serializable {

    private static final long serialVersionUID = -1332472943724078727L;
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
    private CommandCard card;
    private Map<String, String> paymentAdditionalData;
    private Long accountId;
    private Long terminalId;
}
