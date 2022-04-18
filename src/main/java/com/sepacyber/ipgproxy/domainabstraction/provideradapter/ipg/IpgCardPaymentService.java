package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AsynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.SynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ThreeDSecurePaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.IpgPaymentResponseDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.IpgAsyncPaymentRequestDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.IpgSyncPaymentRequestDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.IpgAsyncPaymentResponseDto;
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
    public SynchronousPaymentResponse paySync(SynchronousPaymentCommandDto payWithCardCommand) {
        log.debug("Processing ipg card payment");
        IpgSyncPaymentRequestDto requestDto = mapper.map(payWithCardCommand, IpgSyncPaymentRequestDto.class);
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.paySync(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), SynchronousPaymentResponse.class);
    }

    @Override
    public AsynchronousPaymentResponse payAsync(AsyncPaymentCommandDto synchronousPaymentCommand) {
       //Add mapping here to convert from in port dto to out port dto
        log.debug("Processing ipg card payment");
        IpgAsyncPaymentRequestDto requestDto = mapper.map(synchronousPaymentCommand, IpgAsyncPaymentRequestDto.class);
        ResponseEntity<IpgAsyncPaymentResponseDto> response = ipgPaymentApiClient.payAsync(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), AsynchronousPaymentResponse.class);
    }

    @Override
    public ThreeDSecurePaymentResponse pay3DSecure(ThreeDSecurPaymentCommandDto threeDSecurPaymentCommand) {
        log.debug("Processing ipg card payment");
        IpgSyncPaymentRequestDto requestDto = mapper.map(threeDSecurPaymentCommand, IpgSyncPaymentRequestDto.class);
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.paySync(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), ThreeDSecurePaymentResponse.class);
    }
}
