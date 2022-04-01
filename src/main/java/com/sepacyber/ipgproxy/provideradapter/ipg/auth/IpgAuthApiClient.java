package com.sepacyber.ipgproxy.provideradapter.ipg.auth;


import com.sepacyber.ipgproxy.provideradapter.ipg.IpgFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "IpgAuthApiClient",
        url = "${ipg.provider.base.url:https://tp.sepa-cyber.com}/transactionServices/REST/v1",
        configuration = IpgFeignConfiguration.class)
public interface IpgAuthApiClient {
    @PostMapping(value="/authToken")
    ResponseEntity<AuthTokenResponse> getAuthToken(AuthTokenRequest request);

    @PostMapping("/regenerateToken")
    ResponseEntity<AuthTokenResponse> regenerateAuthToken(RegenerateAuthTokenRequest request);
}
