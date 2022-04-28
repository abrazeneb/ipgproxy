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
public class PaymentCardResponse implements Serializable {

    private static final long serialVersionUID = 1915074784035395178L;
    private String bin;
    private String last4Digits;
    private String holder;
    private String expiryMonth;
    private String expiryYear;
}
