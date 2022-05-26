package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.PaymentCardResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractPaymentActionResponse extends AbstractPaymentResponse {
    private static final long serialVersionUID = 942118733999582203L;
    private String paymentId;
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
