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
public class IpgPayoutCardRequest implements Serializable {

    private static final long serialVersionUID = -862200092162605446L;

    private AuthenticationDto authentication;
    private String merchantTransactionId;
    private Double amount;
    private Long paymentId;
    private Merchant merchant;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Merchant implements Serializable {

        private static final long serialVersionUID = 6044034394205055579L;

            private String email;
    }

}
