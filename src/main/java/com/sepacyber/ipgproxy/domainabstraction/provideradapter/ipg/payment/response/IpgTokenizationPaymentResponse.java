package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgTokenizationPaymentResponse extends IpgBaseResponseDto {
    private static final long serialVersionUID = -6780259160549888376L;

    private String registrationId;
    private String memberId;
    private String paymentBrand;
    private String paymentMode;
    private String timestamp;


}
