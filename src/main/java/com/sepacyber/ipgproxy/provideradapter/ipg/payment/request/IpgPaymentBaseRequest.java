package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class IpgPaymentBaseRequest  implements Serializable {
    private static final long serialVersionUID = -5055405477580209608L;

    private AuthenticationDto authentication;
    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private String merchantRedirectUrl;
    private String notificationUrl;
    private IpgShippingAddress shipping;
    private IpgCustomer customer;
}
