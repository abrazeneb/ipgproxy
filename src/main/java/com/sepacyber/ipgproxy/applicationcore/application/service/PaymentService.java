package com.sepacyber.ipgproxy.applicationcore.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AbstractPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurePaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AbstractPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.BusinessServicePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

@Slf4j
@RequiredArgsConstructor
@CoreBean
public class PaymentService implements PaymentUseCase {

    private final BusinessServicePort businessServicePort;
    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;
    private final MapperFacade mapper;

    //TODO: handle PaymentFailedEvent, Exceptions

    @Override
    public AbstractPaymentResponse processPayment(AbstractPaymentCommandDto command){
        var businessAdditionalData = businessServicePort.getBusinessAdditionalData(command.getBusinessId());

        AbstractPaymentResponse response = null;

        if(command instanceof AsyncPaymentCommandDto){
            response = cardPaymentPort.payAsync((AsyncPaymentCommandDto) command, businessAdditionalData);
        }
        else if(command instanceof SynchronousPaymentCommandDto){
            response = cardPaymentPort.paySync((SynchronousPaymentCommandDto) command, businessAdditionalData);
        }
        else if(command instanceof ThreeDSecurePaymentCommandDto){
            response = cardPaymentPort.pay3DSecure((ThreeDSecurePaymentCommandDto) command,businessAdditionalData);
        }

        notifyPaymentProcessed(command);

        return response;
    }


    private void notifyPaymentProcessed(AbstractPaymentCommandDto paymentCommandDto){
        var paymentProcessedEvent = mapper.map(paymentCommandDto, PaymentProcessedEvent.class);
        paymentProcessedEvent.setProcessedAt(System.currentTimeMillis());
        pipeline.send(paymentProcessedEvent);
    }





}
