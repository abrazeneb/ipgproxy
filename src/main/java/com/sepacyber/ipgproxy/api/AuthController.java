package com.sepacyber.ipgproxy.api;

import com.sepacyber.ipgproxy.application.ports.in.AuthUseCases;
import com.sepacyber.ipgproxy.application.ports.in.GetAuthTokenCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.GetAuthTokenCommandResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCases authUseCases;

    @PostMapping("/auth-token")
    public GetAuthTokenCommandResponse getAuthToken(@RequestBody GetAuthTokenCommand command){
        log.info("Processing auth-token request, for request {}", command);
        return authUseCases.getAuthToken(command);
    }
}
