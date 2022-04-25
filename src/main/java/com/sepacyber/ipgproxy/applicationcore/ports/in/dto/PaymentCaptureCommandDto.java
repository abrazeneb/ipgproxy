package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

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
public class PaymentCaptureCommandDto extends AbstractActionOnPaymentCommandDto {
    private static final long serialVersionUID = -9066120264819960596L;
    private String paymentType;
    private Long paymentId;
    private Double amount;
}
