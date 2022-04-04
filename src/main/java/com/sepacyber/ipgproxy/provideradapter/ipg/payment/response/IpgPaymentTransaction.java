package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentTransaction implements Serializable {
    private static final long serialVersionUID = -6644159644424724870L;
    private String amount;
    private String currency;
    private String systemPaymentId;
    private String merchantTransactionId;
    private String transactionStatus;
    private String captureamount;
    private String refundamount;
    private String chargebackamount;
    private String payoutamount;
    private String date;
    private String transactionDate;
    private String remark;
    private Customer customer;
    private IpgCardResponse card;
    private String transactionReceiptImg;
    private String bankReferenceId;
    private String terminalid;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Customer implements Serializable {

        private static final long serialVersionUID = -4373621095190209119L;
        private String givenName;
        private String surname;
        private String phone;
        private String email;
        private String telnocc;
        private String country;
        private String city;
        private String street;
    }
}
