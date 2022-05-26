package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgDeleteStoredPaymentResponse extends IpgBaseResponseDto {
    private static final long serialVersionUID = -3564685047585907459L;
    private String registrationId;
    private String timestamp;
}
