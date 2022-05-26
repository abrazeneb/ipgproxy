package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgQueryPaymentInstallmentsResponse implements Serializable {
    private static final long serialVersionUID = 3251293432100028440L;
    private IpgResponseCard card;
    private String registrationId;
    private String installment;
}
