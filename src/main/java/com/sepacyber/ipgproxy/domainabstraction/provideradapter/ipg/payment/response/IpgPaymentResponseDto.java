package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPaymentResponseDto extends IpgBaseResponseDto {
    private static final long serialVersionUID = -6974926602050926306L;

    private String paymentId;
    private String paymentBrand;
    private String paymentType;
    private String paymentMode;
    private String amount;
    private String descriptor;
    private PaymentCardResponse card;
    private String timestamp;
    private String transactionStatus;
    private String merchantTransactionId;
    private String remark;
    private String currency;
    private String tmplCurrency;
    private String tmplAmount;
    private IpgPaymentRedirect redirect;


}
