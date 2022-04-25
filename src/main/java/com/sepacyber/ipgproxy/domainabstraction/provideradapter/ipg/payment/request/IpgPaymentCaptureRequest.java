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
public class IpgPaymentCaptureRequest implements Serializable {
    private static final long serialVersionUID = 9208778230243083902L;
    private String paymentType;
    private Long paymentId;
    private Double amount;
}
