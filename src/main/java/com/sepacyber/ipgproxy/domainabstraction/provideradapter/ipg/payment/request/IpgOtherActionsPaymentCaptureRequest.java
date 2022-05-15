package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgOtherActionsPaymentCaptureRequest extends IpgOtherActionsBaseRequest {
    private static final long serialVersionUID = 9208778230243083902L;
    private String paymentType;
    private Long paymentId;
    private Double amount;
}
