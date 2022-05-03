package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPaymentRefundRequest extends IpgExistingPaymentActionBaseRequest{
    private static final long serialVersionUID = 3640695618036829670L;

    private String paymentType;
    private Long paymentId;
    private Double amount;
}
