package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sepacyber.ipgproxy.provideradapter.ipg.payment.response.IpgBaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AuthTokenResponse extends IpgBaseResponseDto {

    @JsonProperty("LoginName")
    private String loginName;
    @JsonProperty("AuthToken")
    private String authToken;
    private long partnerId;
    private long memberId;
    private String timestamp;
}
