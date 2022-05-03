package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPaymentReversalRequest extends IpgExistingPaymentActionBaseRequest {

    private static final long serialVersionUID = -6422970862012994655L;

    private String paymentType;
    private Long paymentId;
}
