package com.sepacyber.ipgproxy.provideradapter.ipg;

import com.sepacyber.ipgproxy.provideradapter.ipg.dto.IpgPaymentRequestDto;
import com.sepacyber.ipgproxy.provideradapter.ipg.dto.IpgPaymentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${ipg.provider.base.name:IpgPaymentApiClient}",
url = "${ipg.provider.base.url:https://tp.sepa-cyber.com}/transactionServices/REST/v1")
public interface IpgPaymentApiClient {
    @PostMapping("/payments")
    ResponseEntity<IpgPaymentResponseDto> pay(
            @RequestHeader(value = "AuthToken") final String token,
            @RequestBody final IpgPaymentRequestDto requestDto);

}
