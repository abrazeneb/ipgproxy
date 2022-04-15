package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.*;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpgSyncPaymentRequestDto extends IpgPaymentBaseRequest{
    private static final long serialVersionUID = 3847017387618139364L;

    private String orderDescriptor;
    private String recurringType;
    private Double tmpl_amount;
    private String tmpl_currency;
    private boolean createRegistration;
    private IpgCard card;
    private DeviceDetails deviceDetails;
}
