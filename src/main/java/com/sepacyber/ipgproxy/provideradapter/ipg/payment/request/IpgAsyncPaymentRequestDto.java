package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpgAsyncPaymentRequestDto extends IpgPaymentBaseRequest {
    private static final long serialVersionUID = 3847017387618139364L;
    private Double tmpl_amount;
    private String tmpl_currency;
}
