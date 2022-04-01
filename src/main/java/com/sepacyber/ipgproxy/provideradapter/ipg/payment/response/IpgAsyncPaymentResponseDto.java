package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

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
    private IpgCardResponse card;
    private String timestamp;

}
