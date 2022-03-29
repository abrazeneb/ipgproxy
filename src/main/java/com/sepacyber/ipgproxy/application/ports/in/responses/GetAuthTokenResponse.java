package com.sepacyber.ipgproxy.application.ports.in.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthTokenResponse {
    private String authToken;
}
