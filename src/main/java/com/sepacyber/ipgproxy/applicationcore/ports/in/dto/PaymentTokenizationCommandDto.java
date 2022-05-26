package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PaymentTokenizationCommandDto extends AbstractPaymentCommandDto {
    private static final long serialVersionUID = -6780259160549888376L;
    private PayWithCardCommandDto.ShippingAddress shipping;
    private CommandShippingAddress customer;
    private CardCommandDto card;
    private String paymentBrand;
    private String paymentMode;
    private boolean createRegistration;


}
