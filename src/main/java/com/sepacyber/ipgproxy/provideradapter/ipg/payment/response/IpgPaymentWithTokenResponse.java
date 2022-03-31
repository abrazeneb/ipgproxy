package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class IpgPaymentWithTokenResponse  extends IpgBaseResponseDto {
    private static final long serialVersionUID = -8055811504602753840L;
    private Long paymentId;
    private String paymentType;
    private LocalDateTime timestamp;
}
