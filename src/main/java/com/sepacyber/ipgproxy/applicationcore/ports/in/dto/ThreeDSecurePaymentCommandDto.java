package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@SuperBuilder
public class ThreeDSecurePaymentCommandDto extends AbstractPaymentCommandDto {
    private static final long serialVersionUID = 952810596026829096L;
    private String orderDescriptor;
    private CommandShippingAddress shipping;
    private CustomerCommandDto customer;
    private String notificationUrl;
    private String recurringType;
    private Double tmpl_amount;
    private String tmpl_currency;
    private Boolean createRegistration;
    private String paymentId;
    private String registrationId;
    private CommandDeviceDetail deviceDetails;
    private CardCommandDto card;
    private String attemptThreeD;
    private String paymentProvider;
    private String virtualPrivateAddress;
}
