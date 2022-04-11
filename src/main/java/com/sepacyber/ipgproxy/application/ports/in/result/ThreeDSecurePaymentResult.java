package com.sepacyber.ipgproxy.application.ports.in.result;

import com.sepacyber.ipgproxy.provideradapter.ipg.payment.response.IpgCardResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreeDSecurePaymentResult implements Serializable {
    private static final long serialVersionUID = -3077355140909730026L;
    private String paymentId;
    private String paymentBrand;
    private String paymentType;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private IpgCardResponse card;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String currency;
    private String tmplCurrency;
    private String tmplAmount;
    private ThreeDSecureRedirectResult redirect;
}
