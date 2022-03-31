package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import com.sepacyber.ipgproxy.provideradapter.ipg.payment.response.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenResponse {
    private String LoginName;
    private String AuthToken;
    private long partnerId;
    private long memberId;
    private String timestamp;
    private Result result;
}
