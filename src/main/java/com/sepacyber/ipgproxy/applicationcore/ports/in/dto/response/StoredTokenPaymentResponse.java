package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoredTokenPaymentResponse implements Serializable {
    private static final long serialVersionUID = 1863198248966356157L;
    private String paymentId;
    private String paymentType;
    private String timestamp;
}
