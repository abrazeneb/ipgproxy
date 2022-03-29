package com.sepacyber.ipgproxy.application.ports.in;

import com.sepacyber.ipgproxy.provideradapter.ipg.dto.IpgPaymentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayWithCardCommandResult {
    private static final long serialVersionUID = -7847578029070982326L;
    private String paymentId;
    private String paymentBrand;
    private String paymentType;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private IpgPaymentResponseDto.Card card;
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
