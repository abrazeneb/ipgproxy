package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import com.sepacyber.ipgproxy.application.ports.in.GetAuthTokenCommand;
import com.sepacyber.ipgproxy.application.ports.in.RegenerateAuthTokenCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.GetAuthTokenCommandResponse;
import com.sepacyber.ipgproxy.application.ports.out.AuthPort;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IpgAuthService implements AuthPort {

    private final IpgAuthApiClient client;
    private final MapperFacade mapper;

    @Override
    public GetAuthTokenCommandResponse getAuthToken(GetAuthTokenCommand command) {
        var request = mapper.map(command, AuthTokenRequest.class);
        var result = client.getAuthToken(request);
        return mapper.map(result.getBody(), GetAuthTokenCommandResponse.class);
    }

    @Override
    public GetAuthTokenCommandResponse regenerateAuthToken(RegenerateAuthTokenCommand command) {
        var request = mapper.map(command, RegenerateAuthTokenRequest.class);
        var result = client.regenerateAuthToken(request);
        return mapper.map(result.getBody(), GetAuthTokenCommandResponse.class);
    }


}
