package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgQueryPaymentInstallmentsRequest extends IpgOtherActionsBaseRequest {
    private static final long serialVersionUID = -7661340270028321602L;
    private String registrationId;
}
