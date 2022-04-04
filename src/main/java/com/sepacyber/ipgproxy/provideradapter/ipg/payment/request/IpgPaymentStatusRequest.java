package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentStatusRequest implements Serializable {

    private static final long serialVersionUID = -6422970862012994655L;

    private AuthenticationDto authentication;
    private String paymentType;
    private String idType;
}
