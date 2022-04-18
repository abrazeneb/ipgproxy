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
public class IpgShippingAddress implements Serializable {

    private static final long serialVersionUID = -6422970862012994655L;
    private String country;
    private String city;
    private String state;
    private String postcode;
    private String street1;
    private String telnocc;
    private String phone;
    private String email;
}
