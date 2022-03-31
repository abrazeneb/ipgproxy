package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sepacyber.ipgproxy.provideradapter.ipg.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenResponse {

    @JsonProperty("LoginName")
    private String loginName;
    @JsonProperty("AuthToken")
    private String authToken;
    private long partnerId;
    private long memberId;
    private String timestamp;
    private Result result;
}
