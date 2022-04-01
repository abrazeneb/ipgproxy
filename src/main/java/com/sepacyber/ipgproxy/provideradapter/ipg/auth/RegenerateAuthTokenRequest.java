package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegenerateAuthTokenRequest{

    private Authentication authentication;
    private String authToken;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Authentication{
        private long partnerId;
    }
}
