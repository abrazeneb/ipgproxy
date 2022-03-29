package com.sepacyber.ipgproxy.application.ports.in;

import com.sepacyber.ipgproxy.application.ports.in.responses.GetAuthTokenResponse;

public interface AuthUseCases {

    public GetAuthTokenResponse getAuthToken(GetAuthTokenCommand command);
}
