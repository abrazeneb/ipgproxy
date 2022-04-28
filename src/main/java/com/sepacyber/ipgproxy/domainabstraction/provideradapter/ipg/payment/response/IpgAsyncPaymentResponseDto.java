package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class IpgAsyncPaymentResponseDto extends IpgBaseResponseDto {
    private static final long serialVersionUID = 4006959194882608628L;

    private Integer amount;
    private String paymentMode;
    private String transactionStatus;
    private String paymentBrand;
    private String tmpl_currency;
    private String remark;
    private String descriptor;
    private String paymentType;
    private Integer paymentId;
    private String merchantTransactionId;
    private String currency;
    private Integer tmpl_amount;
    private PaymentCardResponse card;
    private String timestamp;

}
