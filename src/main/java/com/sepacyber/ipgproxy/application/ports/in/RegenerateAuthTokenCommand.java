package com.sepacyber.ipgproxy.application.ports.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegenerateAuthTokenCommand {
    private long ipgPartnerId;
    private String authToken;
}
