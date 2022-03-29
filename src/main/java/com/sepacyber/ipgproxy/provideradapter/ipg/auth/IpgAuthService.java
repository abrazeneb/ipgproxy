package com.sepacyber.ipgproxy.provideradapter.ipg.auth;

import com.sepacyber.ipgproxy.application.ports.out.AuthPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IpgAuthService implements AuthPort {

    @Override
    public String getAuthToken() {
         // TODO method param to ipg request param
        // send request to ipg
        return null;
    }

}
