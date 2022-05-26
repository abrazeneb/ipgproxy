package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.*;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayWithStoredTokenCommandDto {

    private long tenantId;
    private String organizationId;
    private Double amount;
    private String currency;
    private String paymentType;
    private CustomerCommandDto customer;
    private CardCommandDto card;
    private String merchantRedirectUrl;
    private Integer installment;
    private String redirectMethod;


}
