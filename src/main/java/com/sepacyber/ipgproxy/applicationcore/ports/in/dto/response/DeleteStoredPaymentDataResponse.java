package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteStoredPaymentDataResponse implements Serializable {
    private static final long serialVersionUID = -5556175934795293340L;
    private String registrationId;
    private String timestamp;
}
