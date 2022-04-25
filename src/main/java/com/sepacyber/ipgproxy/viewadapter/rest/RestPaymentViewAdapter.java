package com.sepacyber.ipgproxy.viewadapter.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.application.service.CoreBean;
import com.sepacyber.ipgproxy.viewadapter.ActionOnExistingPaymentCommand;
import com.sepacyber.ipgproxy.viewadapter.PaymentCommand;
import com.sepacyber.ipgproxy.viewadapter.PaymentViewAdapter;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestActionOnExistingPaymentCommand;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestPaymentCommand;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
@CoreBean
public class RestPaymentViewAdapter implements PaymentViewAdapter {
    private final ObjectMapper objectMapper;
    private final PaymentUseCase paymentUseCase;
    @Override
    public PaymentResponse processPayment(PaymentCommand paymentRequestDto) {
        try {
            AbstractPaymentCommandDto command = ((RestPaymentCommand)paymentRequestDto).getData();
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

    @Override
    public ExistingPaymentActionResponse takeActionOnExistingPayment(final String transactionId, final ActionOnExistingPaymentCommand actionOnExistingPaymentCommand) {
        AbstractActionOnPaymentCommandDto command = ((RestActionOnExistingPaymentCommand)actionOnExistingPaymentCommand).getData();
        if(command instanceof PaymentStatusCommandDto) {
            return paymentUseCase.getPaymentStatus(transactionId, (PaymentStatusCommandDto) command);
        }
        if(command instanceof PaymentCaptureCommandDto) {
            return paymentUseCase.capturePayment(transactionId, (PaymentCaptureCommandDto) command);
        }
        if(command instanceof PaymentReversalCommandDto) {
            return paymentUseCase.reversePayment(transactionId, (PaymentReversalCommandDto) command);
        }
        throw new RuntimeException("Error processing action request");
    }

    @Override
    public List<ExistingPaymentActionResponse> getPaymentStatusList(RestActionOnExistingPaymentCommand paymentTransactionBulkQueryCommandDto) {
        return paymentUseCase.getPaymentStatusList((PaymentTransactionBulkQueryCommandDto)paymentTransactionBulkQueryCommandDto.getData());
    }
}
