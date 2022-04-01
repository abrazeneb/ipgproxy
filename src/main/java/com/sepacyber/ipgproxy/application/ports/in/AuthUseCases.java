package com.sepacyber.ipgproxy.application.ports.in;

import com.sepacyber.ipgproxy.application.ports.in.responses.GetAuthTokenCommandResponse;

public interface AuthUseCases {
    public GetAuthTokenCommandResponse getAuthToken(GetAuthTokenCommand command);
    public GetAuthTokenCommandResponse regenerateAuthToken(RegenerateAuthTokenCommand command);
}
