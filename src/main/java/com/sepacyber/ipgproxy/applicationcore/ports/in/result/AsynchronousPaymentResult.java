package com.sepacyber.ipgproxy.applicationcore.ports.in.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsynchronousPaymentResult implements Serializable {
    private static final long serialVersionUID = -1082669989318920381L;
    private String paymentId;
    private String status;
    private String paymentBrand;
    private String paymentMode;
    private String firstName;
    private String lastName;
    private String amount;
    private String descriptor;
    private String currency;
    private PaymentCardResult card;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String tmpl_currency;
    private String tmpl_amount;
}
