package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.PaymentCardResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractPaymentResponse implements Serializable {
    private static final long serialVersionUID = 1823301801884710772L;
    private String paymentId;
    private String paymentBrand;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private PaymentCardResponse card;
    private String timestamp;
    private String currency;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String tmplCurrency;
    private String tmplAmount;

}
