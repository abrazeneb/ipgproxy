package com.sepacyber.ipgproxy.application.ports.in.responses;

import com.sepacyber.ipgproxy.application.dto.PaymentRedirectDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayWithCardResponse  implements Serializable {
    private static final long serialVersionUID = 5870273999667264684L;

    private String paymentId;
    private String paymentBrand;
    private String paymentType;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String currency;
    private String tmplCurrency;
    private String tmplAmount;
    private PaymentRedirectDto redirect;
    private CardResponse card;
}
