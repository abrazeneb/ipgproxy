package com.sepacyber.ipgproxy.applicationcore.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AbstractPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.BusinessServicePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

import java.util.List;

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
        var organizationDto = businessServicePort.getOrganization(command.getTenantId(), command.getOrganizationId());

        AbstractPaymentResponse response = null;

        if(command instanceof AsyncPaymentCommandDto){
            response = cardPaymentPort.payAsync((AsyncPaymentCommandDto) command, organizationDto);
        }
        else if(command instanceof SynchronousPaymentCommandDto){
            response = cardPaymentPort.paySync((SynchronousPaymentCommandDto) command, organizationDto);
        }
        else if(command instanceof ThreeDSecurePaymentCommandDto){
            response = cardPaymentPort.pay3DSecure((ThreeDSecurePaymentCommandDto) command,organizationDto);
        }

        notifyPaymentProcessed(command, organizationDto);

        return response;
    }

    @Override
    public ExistingPaymentActionResponse processActionOnExistingPayment(AbstractActionOnPaymentCommandDto actionOnPaymentCommandDto) {
        var businessAdditionalData = businessServicePort.getOrganization(actionOnPaymentCommandDto.getTenantId(), actionOnPaymentCommandDto.getOrganizationId());
        if(actionOnPaymentCommandDto instanceof PaymentStatusCommandDto) {
            return cardPaymentPort.getPaymentStatus(actionOnPaymentCommandDto.getPaymentId(), (PaymentStatusCommandDto) actionOnPaymentCommandDto, businessAdditionalData);
        }
        if(actionOnPaymentCommandDto instanceof PaymentCaptureCommandDto) {
            return cardPaymentPort.capturePayment(actionOnPaymentCommandDto.getPaymentId(), (PaymentCaptureCommandDto) actionOnPaymentCommandDto, businessAdditionalData);
        }
        if(actionOnPaymentCommandDto instanceof PaymentReversalCommandDto) {
            return cardPaymentPort.reversePayment(actionOnPaymentCommandDto.getPaymentId(), (PaymentReversalCommandDto) actionOnPaymentCommandDto, businessAdditionalData);
        }
        if(actionOnPaymentCommandDto instanceof PaymentRefundCommandDto) {
            return cardPaymentPort.refundPayment(actionOnPaymentCommandDto.getPaymentId(), (PaymentRefundCommandDto) actionOnPaymentCommandDto, businessAdditionalData);
        }
        throw new RuntimeException("Error processing action request");
    }

    @Override
    public List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto) {
        var businessAdditionalData = businessServicePort.getOrganization(paymentTransactionBulkQueryCommandDto.getTenantId(), paymentTransactionBulkQueryCommandDto.getOrganizationId());
        return cardPaymentPort.getPaymentStatusList(paymentTransactionBulkQueryCommandDto, businessAdditionalData);
    }

    private void notifyPaymentProcessed(AbstractPaymentCommandDto paymentCommandDto, OrganizationDto organizationDto){
        var paymentProcessedEvent = mapper.map(paymentCommandDto, PaymentProcessedEvent.class);
        paymentProcessedEvent.setOrganization(mapper.map(organizationDto, PaymentProcessedEvent.Organization.class));
        paymentProcessedEvent.setProcessedAt(System.currentTimeMillis());
        pipeline.send(paymentProcessedEvent);
    }
}
