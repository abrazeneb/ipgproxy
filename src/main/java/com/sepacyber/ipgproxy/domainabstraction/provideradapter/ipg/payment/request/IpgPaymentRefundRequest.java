package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentRefundRequest implements Serializable {
    private static final long serialVersionUID = 3640695618036829670L;

    private AuthenticationDto authentication;
    private String paymentType;
    private Long paymentId;
    private Double amount;
}
