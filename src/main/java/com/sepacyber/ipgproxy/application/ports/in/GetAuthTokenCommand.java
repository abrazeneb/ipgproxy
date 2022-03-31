package com.sepacyber.ipgproxy.application.ports.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAuthTokenCommand {
    private long ipgPartnerId;
    private String ipgSecureKey;
    private String ipgUsername;
}
