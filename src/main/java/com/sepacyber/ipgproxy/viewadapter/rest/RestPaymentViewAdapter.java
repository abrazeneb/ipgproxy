package com.sepacyber.ipgproxy.viewadapter.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AbstractPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.application.service.CoreBean;
import com.sepacyber.ipgproxy.viewadapter.PaymentCommand;
import com.sepacyber.ipgproxy.viewadapter.PaymentViewAdapter;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestPaymentCommand;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
@CoreBean
public class RestPaymentViewAdapter implements PaymentViewAdapter {
    private final ObjectMapper objectMapper;
    private final PaymentUseCase paymentUseCase;

    @Override
    public PaymentResponse processPayment(PaymentCommand paymentRequestDto) {
        try {
            AbstractPaymentCommandDto command = objectMapper.readValue( ((RestPaymentCommand)paymentRequestDto).getData(), AbstractPaymentCommandDto.class);
            if(command instanceof SynchronousPaymentCommandDto) {
                return PaymentResponse.builder()
                        .data(objectMapper.writeValueAsString(
                                paymentUseCase.paySynchronous((SynchronousPaymentCommandDto) command)
                        ))
                        .build();
            }
            if(command instanceof AsyncPaymentCommandDto) {
                return PaymentResponse.builder()
                        .data(objectMapper.writeValueAsString(
                                paymentUseCase.payAsync((AsyncPaymentCommandDto) command)
                        ))
                        .build();
            }
            if(command instanceof ThreeDSecurPaymentCommandDto) {
                return PaymentResponse.builder()
                        .data(objectMapper.writeValueAsString(
                                paymentUseCase.pay3DSecure((ThreeDSecurPaymentCommandDto) command)
                        ))
                        .build();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
