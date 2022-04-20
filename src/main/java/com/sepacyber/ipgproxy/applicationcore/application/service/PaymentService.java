package com.sepacyber.ipgproxy.applicationcore.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AsynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.SynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ThreeDSecurePaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@CoreBean
public class PaymentService implements PaymentUseCase {

    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;
    private final MapperFacade mapper;

    @Override
    public AsynchronousPaymentResponse payAsync(AsyncPaymentCommandDto asyncPaymentCommand) {

        var response = cardPaymentPort.payAsync(asyncPaymentCommand);

        var paymentProcessedEvent = mapper.map(asyncPaymentCommand, PaymentProcessedEvent.class);
        paymentProcessedEvent.setProcessedAt(System.currentTimeMillis());
        pipeline.send(paymentProcessedEvent);

        return response;
    }

    @Override
    public SynchronousPaymentResponse paySynchronous(SynchronousPaymentCommandDto synchronousPaymentCommand) {
        return cardPaymentPort.paySync(synchronousPaymentCommand);
    }

    @Override
    public ThreeDSecurePaymentResponse pay3DSecure(ThreeDSecurPaymentCommandDto threeDSecurPaymentCommand) {
        return cardPaymentPort.pay3DSecure(threeDSecurPaymentCommand);
    }


/*    private void notifyPaymentProcessed(){
        pipeline.send(new PaymentProcessedEvent());
    }*/


}
