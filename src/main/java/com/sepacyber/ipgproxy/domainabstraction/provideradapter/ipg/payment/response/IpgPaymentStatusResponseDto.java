package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPaymentStatusResponseDto extends IpgBaseResponseDto {
    private static final long serialVersionUID = -6974926602050926306L;

    private String paymentId;
    private String status;
    private String paymentBrand;
    private String paymentMode;
    private String amount;
    private String firstName;
    private String lastName;
    private String currency;
    @JsonProperty("tmpl_amount")
    private String tmplAmount;
    @JsonProperty("tmpl_currency")
    private String tmplCurrency;
    private String merchantTransactionId;
    private String eci;
    private PaymentCardResponse card;
    private String timestamp;
    private String transactionStatus;
    private String remark;
    private String descriptor;


}
