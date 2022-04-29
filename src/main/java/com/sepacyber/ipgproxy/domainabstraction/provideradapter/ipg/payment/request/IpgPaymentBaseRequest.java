package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpgPaymentBaseRequest  implements Serializable {
    private static final long serialVersionUID = -5055405477580209608L;

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
    private Map<String, Object> paymentAdditionalData;
    private Long accountId;
    private Long terminalId;
}
