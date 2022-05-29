package com.sepacyber.ipgproxy.applicationcore.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.applicationcore.domain.payment.Payment;
import com.sepacyber.ipgproxy.applicationcore.domain.payment.PaymentStatus;
import com.sepacyber.ipgproxy.applicationcore.domain.payment.Payment;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.*;
import com.sepacyber.ipgproxy.applicationcore.ports.out.BusinessServicePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.event.PaymentFailedEvent;
import com.sepacyber.ipgproxy.applicationcore.ports.out.event.PaymentProcessedEvent;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentPersistencePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import com.sepacyber.ipgproxy.shared.exception.AbstractIpgException;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorCode;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import feign.FeignException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@CoreBean
public class PaymentService implements PaymentUseCase {

    private final BusinessServicePort businessServicePort;
    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;
    private final MapperFacade mapper;
    private final PaymentPersistencePort paymentPersistencePort;
    //TODO: handle PaymentFailedEvent, Exceptions

    @Override
    public AbstractPaymentResponse processPayment(AbstractPaymentCommandDto command){
        var organizationDto = businessServicePort.getOrganization(command.getTenantId(), command.getOrganizationId());
        try{
            AbstractPaymentResponse response = null;

            if(command instanceof AsyncPaymentCommandDto){
                response = cardPaymentPort.payAsync((AsyncPaymentCommandDto) command, organizationDto);
            }
            else if(command instanceof SynchronousPaymentCommandDto){
                response = cardPaymentPort.paySync((SynchronousPaymentCommandDto) command, organizationDto);
                notifyPaymentProcessed(command, organizationDto);
            }
            else if(command instanceof ThreeDSecurePaymentCommandDto){
                response = cardPaymentPort.pay3DSecure((ThreeDSecurePaymentCommandDto) command,organizationDto);
            }
            else if(command instanceof PaymentTokenizationCommandDto){
                response = cardPaymentPort.tokenizePayment((PaymentTokenizationCommandDto) command,organizationDto);
            }
            //Persist response
            paymentPersistencePort.save(mapper.map(response, Payment.class));
            return response;
        }catch (Exception e){
            notifyPaymentFailed(command, organizationDto, e);
            throw e;
        }
    }

    @Override
    public ExistingPaymentActionResponse processActionOnExistingPayment(AbstractActionOnPaymentCommandDto actionOnPaymentCommandDto) {

        try{

            var organizationDto = businessServicePort.getOrganization(actionOnPaymentCommandDto.getTenantId(), actionOnPaymentCommandDto.getOrganizationId());

            if(actionOnPaymentCommandDto instanceof PaymentStatusCommandDto) {
                ExistingPaymentActionResponse paymentStatus = cardPaymentPort.getPaymentStatus(actionOnPaymentCommandDto.getPaymentId(), (PaymentStatusCommandDto) actionOnPaymentCommandDto, organizationDto);
                paymentPersistencePort.bulkUpdatePaymentStatus(Collections.singletonList(paymentStatus));
                return paymentStatus;
            }
            if(actionOnPaymentCommandDto instanceof PaymentCaptureCommandDto) {
                return cardPaymentPort.capturePayment(actionOnPaymentCommandDto.getPaymentId(), (PaymentCaptureCommandDto) actionOnPaymentCommandDto, organizationDto);
            }
            if(actionOnPaymentCommandDto instanceof PaymentReversalCommandDto) {
                return cardPaymentPort.reversePayment(actionOnPaymentCommandDto.getPaymentId(), (PaymentReversalCommandDto) actionOnPaymentCommandDto, organizationDto);
            }
            if(actionOnPaymentCommandDto instanceof PaymentRefundCommandDto) {
                return cardPaymentPort.refundPayment(actionOnPaymentCommandDto.getPaymentId(), (PaymentRefundCommandDto) actionOnPaymentCommandDto, organizationDto);
            }
        }catch(Exception e) {
            // TODO: notify action failed?

            throw e;
        }


        throw new AbstractIpgException(ErrorDto.builder().code(ErrorCode.UNKNOWN_PROCESSING_ACTION).message("Error processing action request").build());
    }

    @Override
    public List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto) {
        var businessAdditionalData = businessServicePort.getOrganization(paymentTransactionBulkQueryCommandDto.getTenantId(), paymentTransactionBulkQueryCommandDto.getOrganizationId());
        List<ExistingPaymentActionResponse> paymentStatusList = cardPaymentPort.getPaymentStatusList(paymentTransactionBulkQueryCommandDto, businessAdditionalData);
        paymentPersistencePort.bulkUpdatePaymentStatus(paymentStatusList);
        return paymentStatusList;
    }

    @Override
    public StoredTokenPaymentResponse payWithStoredToken(PayWithStoredTokenCommandDto payWithStoredTokenCommandDto) {
        var businessAdditionalData = businessServicePort.getOrganization(payWithStoredTokenCommandDto.getTenantId(), payWithStoredTokenCommandDto.getOrganizationId());
        return cardPaymentPort.payWithStoredData(payWithStoredTokenCommandDto, businessAdditionalData);
    }

    @Override
    public DeleteStoredPaymentDataResponse deleteStoredPaymentData(DeleteStoredPaymentDataCommandDto deleteStoredPaymentDataCommandDto) {
        var businessAdditionalData = businessServicePort.getOrganization(deleteStoredPaymentDataCommandDto.getTenantId(), deleteStoredPaymentDataCommandDto.getOrganizationId());
        return cardPaymentPort.deleteStoredPaymentData(deleteStoredPaymentDataCommandDto, businessAdditionalData);
    }

    @Override
    public QueryPaymentInstallmentsResponse queryPaymentInstallments(QueryPaymentInstallmentsCommandDto queryPaymentInstallmentsCommandDto) {
        var businessAdditionalData = businessServicePort.getOrganization(queryPaymentInstallmentsCommandDto.getTenantId(), queryPaymentInstallmentsCommandDto.getOrganizationId());
        return cardPaymentPort.queryPaymentInstallments(queryPaymentInstallmentsCommandDto, businessAdditionalData);
    }

    @Scheduled(cron="${application.status.poll.schedule: '*/10 * * * * *' }")
    @Override
    public void pollPaymentStatus(){
        List<Payment> pendingPayments = paymentPersistencePort.getPaymentsByStatus(PaymentStatus.PENDING);
        pendingPayments.stream()
                .collect(groupingBy(Payment::getBusiness))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .forEach(payment -> {
                    List<ExistingPaymentActionResponse> paymentStatusList =
                            getPaymentStatusList(PaymentTransactionBulkQueryCommandDto.builder()
                            .tenantId(payment.getBusiness().getTenantId())
                            .organizationId(payment.getBusiness().getOrganizationId())
                            .build());
                    paymentPersistencePort.bulkUpdatePaymentStatus(paymentStatusList);
                });
    }

    private void notifyPaymentProcessed(AbstractPaymentCommandDto paymentCommandDto, OrganizationDto organizationDto){
        var paymentProcessedEvent = mapper.map(paymentCommandDto, PaymentProcessedEvent.class);
        paymentProcessedEvent.setOrganization(mapper.map(organizationDto, PaymentProcessedEvent.Organization.class));
        paymentProcessedEvent.setTimestamp(System.currentTimeMillis());
        pipeline.send(paymentProcessedEvent);
    }

    private void notifyPaymentFailed(AbstractPaymentCommandDto paymentCommandDto, OrganizationDto organizationDto, Exception exception){
        var paymentFailedEvent = mapper.map(paymentCommandDto, PaymentFailedEvent.class);

        if(!isNull(organizationDto)){
            paymentFailedEvent.setOrganization(mapper.map(organizationDto, PaymentFailedEvent.Organization.class));
        }

        paymentFailedEvent.setTimestamp(System.currentTimeMillis());

        if(exception instanceof AbstractIpgException){
            paymentFailedEvent.setError(((AbstractIpgException) exception).getError());
        } else if(exception instanceof FeignException){
            paymentFailedEvent.setError(ErrorDto.builder().code(ErrorCode.FEIGN_CLIENT_EXCEPTION).message(exception.getMessage()).build());
        } else{
            paymentFailedEvent.setError(ErrorDto.builder().code(ErrorCode.RUNTIME_ERROR).message(exception.getMessage()).build());
        }

        pipeline.send(paymentFailedEvent);
    }
}
