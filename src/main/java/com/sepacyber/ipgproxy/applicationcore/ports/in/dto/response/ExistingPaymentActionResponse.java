package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExistingPaymentActionResponse implements Serializable {
    private static final long serialVersionUID = 3656768601597785556L;
    private String paymentId;
    private String status;
    private String paymentBrand;
    private String paymentMode;
    private String firstName;
    private String lastName;
    private String amount;
    private String descriptor;
    private String currency;
    private PaymentCardResponse card;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String tmpl_currency;
    private String tmpl_amount;
}
