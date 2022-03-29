package com.sepacyber.ipgproxy.provideradapter.ipg.dto;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentResponseDto extends IpgBaseResponseDto {
    private static final long serialVersionUID = -6974926602050926306L;

    private String paymentId;
    private String paymentBrand;
    private String paymentType;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private Card card;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String currency;
    private String tmplCurrency;
    private String tmplAmount;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Card implements Serializable {

        private static final long serialVersionUID = 1915074784035395178L;
        private String bin;
        private String last4Digits;
        private String holder;
        private String expiryMonth;
        private String expiryYear;
    }
}
