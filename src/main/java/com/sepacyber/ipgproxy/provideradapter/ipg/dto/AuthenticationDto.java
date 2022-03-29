package com.sepacyber.ipgproxy.provideradapter.ipg.dto;

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
    private Long memberId;
    private Long accountId;
    private Long terminalId;
    private String checksum;
}
