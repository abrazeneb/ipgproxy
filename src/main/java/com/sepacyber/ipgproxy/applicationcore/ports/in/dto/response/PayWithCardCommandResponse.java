package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayWithCardCommandResponse {
    private static final long serialVersionUID = -7847578029070982326L;
    private String paymentId;
    private String paymentBrand;
    private String paymentType;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private CardResponse card;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String currency;
    private String tmplCurrency;
    private String tmplAmount;

}
