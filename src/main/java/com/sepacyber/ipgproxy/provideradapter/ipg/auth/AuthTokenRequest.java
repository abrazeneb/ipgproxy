package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sepacyber.ipgproxy.provideradapter.ipg.dto.AuthenticationDto;
import com.sepacyber.ipgproxy.provideradapter.ipg.dto.MerchantDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthTokenRequest  implements Serializable {

    private static final long serialVersionUID = 5299514896948183035L;
    
    private Authentication authentication;
    private Merchant merchant;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Authentication implements Serializable{
        private static final long serialVersionUID = 4052840677271449897L;
        private long partnerId;

        @JsonProperty("sKey")
        private String sKey;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Merchant implements Serializable{
        private static final long serialVersionUID = -8832447410330125465L;
        private String username;
    }
}


