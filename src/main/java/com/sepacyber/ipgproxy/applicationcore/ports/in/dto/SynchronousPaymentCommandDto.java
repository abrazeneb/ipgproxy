package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SynchronousPaymentCommandDto extends AbstractPaymentCommandDto {
    private static final long serialVersionUID = -1332472943724078727L;
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
    private CardCommandDto card;
}
