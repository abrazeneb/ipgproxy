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
public class IpgCard implements Serializable {

    private static final long serialVersionUID = 4019594936981535772L;
    private String numbercc;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
}
