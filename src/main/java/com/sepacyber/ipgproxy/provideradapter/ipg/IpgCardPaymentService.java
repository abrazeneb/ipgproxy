package com.sepacyber.ipgproxy.provideradapter.ipg;

import com.sepacyber.ipgproxy.application.ports.in.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardCommandResult;
import com.sepacyber.ipgproxy.application.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.provideradapter.ipg.dto.IpgPaymentRequestDto;
import com.sepacyber.ipgproxy.provideradapter.ipg.dto.IpgPaymentResponseDto;
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
    public PayWithCardCommandResult pay(PayWithCardCommand payWithCardCommand) {
       //Add mapping here to convert from in port dto to out port dto
        log.debug("Processing ipg card payment");
        IpgPaymentRequestDto requestDto = mapper.map(payWithCardCommand, IpgPaymentRequestDto.class);
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.pay(null, requestDto);
        log.debug("Received response from ipg client {}", response);

        return mapper.map(response.getBody(), PayWithCardCommandResult.class);
    }
}
