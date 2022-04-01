package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationDto implements Serializable {

    private static final long serialVersionUID = -8705921699496882791L;
    private Long partnerId;
    private Long memberId;
    private String sKey;
    private Long accountId;
    private Long terminalId;
    private String checksum;
}
