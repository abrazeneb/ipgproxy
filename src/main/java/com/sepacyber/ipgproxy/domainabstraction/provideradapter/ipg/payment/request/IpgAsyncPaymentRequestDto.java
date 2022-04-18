package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpgAsyncPaymentRequestDto extends IpgPaymentBaseRequest {
    private static final long serialVersionUID = 3847017387618139364L;
    private Double tmpl_amount;
    private String tmpl_currency;
}
