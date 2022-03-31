package com.sepacyber.ipgproxy.application.ports.out;

import com.sepacyber.ipgproxy.application.ports.in.GetAuthTokenCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.GetAuthTokenCommandResponse;

public interface AuthPort {

    public GetAuthTokenCommandResponse getAuthToken(GetAuthTokenCommand command);
}
