package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentRedirect implements Serializable {
    private static final long serialVersionUID = 6135410875501188611L;
    private String url;
    private String method;
    private String target;
    private List<IpgPaymentResponseParameter> parameters;
}
