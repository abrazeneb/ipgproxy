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
public class PaymentReversalCommandDto extends AbstractActionOnPaymentCommandDto {

    private static final long serialVersionUID = -5060265581173496893L;

    private String paymentType;
    private Long paymentId;
}
