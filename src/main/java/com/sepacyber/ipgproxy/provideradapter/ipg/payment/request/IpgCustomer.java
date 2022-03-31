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
public class IpgCustomer implements Serializable {

    private static final long serialVersionUID = 4019594936981535772L;
    private Long customerId;
    private String telnocc;
    private String phone;
    private String email;
    private String givenName;
    private String surname;
    private String ip;
    private String birthDate;
}
