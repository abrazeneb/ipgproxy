package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;

import com.sepacyber.ipgproxy.application.ports.in.command.CommandCard;
import com.sepacyber.ipgproxy.application.ports.in.command.CommandCustomer;
import com.sepacyber.ipgproxy.application.ports.in.command.CommandDeviceDetail;
import com.sepacyber.ipgproxy.application.ports.in.command.CommandShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ipg3DPaymentRequest implements Serializable {
    private static final long serialVersionUID = 2854914801239496908L;
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
