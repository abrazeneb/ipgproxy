package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentWithTokenRequest implements Serializable {

    private static final long serialVersionUID = 3104870602479732483L;

    private Double amount;
    private String currency;
    private IpgTokenPaymentCard card;
    private IpgTokenPaymentCustomer customer;
    private String merchantRedirectUrl;
    private String redirectMethod;
    private Double installment;
    private Map<String, String> paymentAdditionalData;
    private Long accountId;
    private Long terminalId;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class IpgTokenPaymentCard {
        private String cvv;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class IpgTokenPaymentCustomer {
        private String ip;
    }
}
