package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenizationResponse implements Serializable {
    private static final long serialVersionUID = -4308276522518985855L;
    private Long memberId;
    private String registrationId;
    private String paymentBrand;
    private String paymentMode;
    private String timestamp;
}
