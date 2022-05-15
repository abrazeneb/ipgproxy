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
public class IpgStandalonePaymentStoreRequest extends IpgOtherActionsBaseRequest {
    private static final long serialVersionUID = -2169866764358841438L;

    private IpgShippingAddress shipping;
    private IpgCustomer customer;
    private IpgCard card;
    private String paymentBrand;
    private String paymentMode;
    private boolean createRegistration;

}
