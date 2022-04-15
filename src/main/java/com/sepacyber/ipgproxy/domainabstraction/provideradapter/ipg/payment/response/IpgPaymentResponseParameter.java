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
public class IpgPaymentResponseParameter implements Serializable {
    private static final long serialVersionUID = -5204367760078451112L;
    private String name;
    private String value;
}
