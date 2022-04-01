package com.sepacyber.ipgproxy.application.service;

import com.sepacyber.ipgproxy.application.ports.in.AuthUseCases;
import com.sepacyber.ipgproxy.application.ports.in.GetAuthTokenCommand;
import com.sepacyber.ipgproxy.application.ports.in.RegenerateAuthTokenCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.GetAuthTokenCommandResponse;
import com.sepacyber.ipgproxy.application.ports.out.AuthPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthUseCasesImpl implements AuthUseCases {

    private final AuthPort authPort;

    @Override
    public GetAuthTokenCommandResponse getAuthToken(GetAuthTokenCommand command) {
        return authPort.getAuthToken(command);
    }

    @Override
    public GetAuthTokenCommandResponse regenerateAuthToken(RegenerateAuthTokenCommand command) {
        return authPort.regenerateAuthToken(command);
    }


}
