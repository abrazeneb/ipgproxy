package com.sepacyber.ipgproxy.viewadapter.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.*;
import com.sepacyber.ipgproxy.applicationcore.application.service.CoreBean;
import com.sepacyber.ipgproxy.viewadapter.*;
import com.sepacyber.ipgproxy.viewadapter.rest.command.*;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
@CoreBean
public class RestPaymentViewAdapter implements PaymentViewAdapter {
    private final ObjectMapper objectMapper;
    private final PaymentUseCase paymentUseCase;
    private final MapperFacade mapper;

    @Override
    public PaymentCardResponse.PaymentResponse processPayment(PaymentCommand paymentRequestDto) {
        try {
            AbstractPaymentCommandDto command = ((RestPaymentCommand)paymentRequestDto).getData();
            return PaymentCardResponse.PaymentResponse.builder()
                    .data(objectMapper.writeValueAsString(
                       paymentUseCase.processPayment(command)
                    ))
                    .build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ExistingPaymentActionResponse takeActionOnExistingPayment(final ActionOnExistingPaymentCommand actionOnExistingPaymentCommand) {
        return paymentUseCase.processActionOnExistingPayment(((RestActionOnExistingPaymentCommand)actionOnExistingPaymentCommand).getData());
    }

    @Override
    public List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto) {
        return paymentUseCase.getPaymentStatusList(paymentTransactionBulkQueryCommandDto);
    }

    @Override
    public StoredTokenPaymentResponse payWithStoredData(PaymentWithStoredDataCommand restPaymentWithStoredDataCommand) {
        return paymentUseCase.payWithStoredToken(mapper.map((RestPaymentWithStoredDataCommand)restPaymentWithStoredDataCommand, PayWithStoredTokenCommandDto.class));
    }

    @Override
    public DeleteStoredPaymentDataResponse deletePaymentWithStoredData(DeleteStoredPaymentDataCommand deleteStoredPaymentData) {
        return paymentUseCase.deleteStoredPaymentData(mapper.map((RestDeleteStoredPaymentData)deleteStoredPaymentData, DeleteStoredPaymentDataCommandDto.class));
    }

    @Override
    public QueryPaymentInstallmentsResponse queryPaymentInstallments(QueryPaymentInstallmentsCommand paymentInstallmentsCommand) {
        return paymentUseCase.queryPaymentInstallments(mapper.map((RestQueryPaymentInstallmentsCommand)paymentInstallmentsCommand, QueryPaymentInstallmentsCommandDto.class));
    }
}
