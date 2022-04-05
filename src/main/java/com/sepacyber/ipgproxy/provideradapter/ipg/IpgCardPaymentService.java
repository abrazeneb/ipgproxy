package com.sepacyber.ipgproxy.provideradapter.ipg;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.PayWithCardResponse;
import com.sepacyber.ipgproxy.application.ports.in.result.PayWithCardCommandResponse;
import com.sepacyber.ipgproxy.application.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.provideradapter.ipg.payment.request.AuthenticationDto;
import com.sepacyber.ipgproxy.provideradapter.ipg.payment.request.IpgSyncPaymentRequestDto;
import com.sepacyber.ipgproxy.provideradapter.ipg.payment.response.IpgPaymentResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IpgCardPaymentService  implements CardPaymentPort {

    private final IpgPaymentApiClient ipgPaymentApiClient;
    private final MapperFacade mapper;

    @Override
    public PayWithCardResponse pay(PayWithCardCommand payWithCardCommand) {
        log.debug("Processing ipg card payment");
        IpgSyncPaymentRequestDto requestDto = mapper.map(payWithCardCommand, IpgSyncPaymentRequestDto.class);
        AuthenticationDto authenticationDto = mapper.map(payWithCardCommand, AuthenticationDto.class);
        requestDto.setAuthentication(authenticationDto);
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.pay(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), PayWithCardResponse.class);
    }

    @Override
    public PayWithCardCommandResponse payAsync(PayWithCardCommand payWithCardCommand) {
       //Add mapping here to convert from in port dto to out port dto
        log.debug("Processing ipg card payment");
        IpgSyncPaymentRequestDto requestDto = mapper.map(payWithCardCommand, IpgSyncPaymentRequestDto.class);
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.pay(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), PayWithCardCommandResponse.class);
    }
}
