package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class AsyncPaymentCommandDto extends AbstractPaymentCommandDto {
    private static final long serialVersionUID = 983462198019530894L;
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
}
