package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthTokenRequest {
    private long partnerId;
    private String sKey;
    private String username;
}
