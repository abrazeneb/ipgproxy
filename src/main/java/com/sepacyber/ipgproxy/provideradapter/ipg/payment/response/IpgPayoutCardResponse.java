package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class IpgPayoutCardResponse extends IpgBaseResponseDto{
    private static final long serialVersionUID = 3196458371101144146L;

    private String paymentId;
    private String status;
    private String paymentBrand;
    private String paymentMode;
    private String amount;
    private String currency;
    private String timestamp;
    private String merchantTransactionId;
    private String remark;
    private String transactionStatus;
}
