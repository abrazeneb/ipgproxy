package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPaymentCaptureRequest extends IpgExistingPaymentActionBaseRequest {
    private static final long serialVersionUID = 9208778230243083902L;
    private String paymentType;
    private Long paymentId;
    private Double amount;
}
