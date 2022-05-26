package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.*;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.*;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.*;
import com.sepacyber.ipgproxy.infrastructure.ipg.IpgPropertiesConfig;
import com.sepacyber.ipgproxy.shared.exception.IntegrationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class IpgCardPaymentService  implements CardPaymentPort {

    private final IpgPaymentApiClient ipgPaymentApiClient;
    private final MapperFacade mapper;
    private final IpgPropertiesConfig ipgPropertiesConfig;

    @Override
    public SynchronousPaymentResponse paySync(SynchronousPaymentCommandDto payWithCardCommand, OrganizationDto organizationDto) {
        log.debug("Processing ipg card payment");
        IpgSyncPaymentRequestDto requestDto = mapper.map(payWithCardCommand, IpgSyncPaymentRequestDto.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.paySync(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), SynchronousPaymentResponse.class);
    }

    @Override
    public AsynchronousPaymentResponse payAsync(AsyncPaymentCommandDto synchronousPaymentCommand, OrganizationDto organizationDto) {
       //Add mapping here to convert from in po
        //
        // rt dto to out port dto
        log.debug("Processing ipg card payment");
        IpgAsyncPaymentRequestDto requestDto = mapper.map(synchronousPaymentCommand, IpgAsyncPaymentRequestDto.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgAsyncPaymentResponseDto> response = ipgPaymentApiClient.payAsync(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), AsynchronousPaymentResponse.class);
    }

    @Override
    public ThreeDSecurePaymentResponse pay3DSecure(ThreeDSecurePaymentCommandDto threeDSecurePaymentCommand, OrganizationDto organizationDto) {
        log.debug("Processing ipg card payment");
        IpgSyncPaymentRequestDto requestDto = mapper.map(threeDSecurePaymentCommand, IpgSyncPaymentRequestDto.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentResponseDto> response = ipgPaymentApiClient.paySync(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), ThreeDSecurePaymentResponse.class);
    }

    @Override
    public ExistingPaymentActionResponse getPaymentStatus(final String transactionId, final PaymentStatusCommandDto paymentStatusCommandDto, OrganizationDto organizationDto) {
        log.debug("Processing ipg get payment status");
        IpgPaymentStatusRequest requestDto = mapper.map(paymentStatusCommandDto, IpgPaymentStatusRequest.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.paymentStatus(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), ExistingPaymentActionResponse.class);
    }

    @Override
    public List<ExistingPaymentActionResponse> getPaymentStatusList(
            PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto,
            OrganizationDto organizationDto) {
        log.debug("Processing ipg get payment status");
        IpgPaymentTransactionQueryRequest requestDto = mapper.map(paymentTransactionBulkQueryCommandDto,
                IpgPaymentTransactionQueryRequest.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentTransactionQueryResponse> response = ipgPaymentApiClient.queryTransactions(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.mapAsList(getResponse(response).getTransaction(), ExistingPaymentActionResponse.class);
    }

    //Capture and Refund depending on value on paymentType
    @Override
    public ExistingPaymentActionResponse capturePayment(final String transactionId,
                                                        final PaymentCaptureCommandDto captureCommandDto,
                                                        OrganizationDto organizationDto) {
        log.debug("Processing ipg capture payment");
        IpgOtherActionsPaymentCaptureRequest requestDto = mapper.map(captureCommandDto, IpgOtherActionsPaymentCaptureRequest.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.capturePayment(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), ExistingPaymentActionResponse.class);
    }

    @Override
    public ExistingPaymentActionResponse refundPayment(String transactionId, PaymentRefundCommandDto refundCommandDto, OrganizationDto organizationDto) {
        log.debug("Processing ipg capture payment");
        IpgPaymentRefundRequest requestDto = mapper.map(refundCommandDto, IpgPaymentRefundRequest.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.refundPayment(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), ExistingPaymentActionResponse.class);
    }

    @Override
    public ExistingPaymentActionResponse reversePayment(final String transactionId,
                                                        final PaymentReversalCommandDto reversalCommandDto,
                                                        OrganizationDto organizationDto) {
        log.debug("Processing ipg capture payment");
        IpgPaymentReversalRequest requestDto = mapper.map(reversalCommandDto, IpgPaymentReversalRequest.class);
        if (nonNull(requestDto.getPaymentAdditionalData())) {
            requestDto.getPaymentAdditionalData().putAll(organizationDto.getAdditionalData());
        } else {
            requestDto.setPaymentAdditionalData(organizationDto.getAdditionalData());
        }
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.reversePayment(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), ExistingPaymentActionResponse.class);
    }

    @Override
    public TokenizationResponse tokenizePayment(PaymentTokenizationCommandDto paymentTokenizationCommandDto,
                                                final OrganizationDto businessWithAdditionalDataDto) {

        IpgStandalonePaymentStoreRequest request = mapper.map(paymentTokenizationCommandDto, IpgStandalonePaymentStoreRequest.class);
        request.setPaymentAdditionalData(businessWithAdditionalDataDto.getAdditionalData());
        ResponseEntity<IpgTokenizationPaymentResponse> response = ipgPaymentApiClient.registerPayment(request);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), TokenizationResponse.class);
    }

    @Override
    public StoredTokenPaymentResponse payWithStoredData(PayWithStoredTokenCommandDto payWithStoredTokenRequest, OrganizationDto businessWithAdditionalDataDto) {
        IpgPayWithStoredTokenRequest request = mapper.map(payWithStoredTokenRequest, IpgPayWithStoredTokenRequest.class);
        request.setPaymentAdditionalData(businessWithAdditionalDataDto.getAdditionalData());
        ResponseEntity<IpgPayWithTokenResponse> response = ipgPaymentApiClient.payFromStoredToken(request);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), StoredTokenPaymentResponse.class);
    }

    @Override
    public DeleteStoredPaymentDataResponse deleteStoredPaymentData(DeleteStoredPaymentDataCommandDto deleteStoredPaymentDataCommandDto, OrganizationDto businessWithAdditionalDataDto) {
        IpgDeleteStoredPaymentDataRequest request = mapper.map(deleteStoredPaymentDataCommandDto, IpgDeleteStoredPaymentDataRequest.class);
        request.setPaymentAdditionalData(businessWithAdditionalDataDto.getAdditionalData());
        ResponseEntity<IpgDeleteStoredPaymentResponse> response = ipgPaymentApiClient.deleteStoredPaymentData(request);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(getResponse(response), DeleteStoredPaymentDataResponse.class);
    }

    @Override
    public QueryPaymentInstallmentsResponse queryPaymentInstallments(QueryPaymentInstallmentsCommandDto queryPaymentInstallmentsCommandDto, OrganizationDto businessWithAdditionalDataDto) {
        IpgQueryPaymentInstallmentsRequest request = mapper.map(queryPaymentInstallmentsCommandDto, IpgQueryPaymentInstallmentsRequest.class);
        request.setPaymentAdditionalData(businessWithAdditionalDataDto.getAdditionalData());
        ResponseEntity<IpgQueryPaymentInstallmentsResponse> response = ipgPaymentApiClient.queryPaymentInstallments(request);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response, QueryPaymentInstallmentsResponse.class);
    }

    private <T extends IpgBaseResponseDto> T getResponse(ResponseEntity<T> responseEntity, String... params) {
        if (isNull(responseEntity) || !responseEntity.getStatusCode().is2xxSuccessful()
                || isNull(responseEntity.getBody()) ) {
            throw new IntegrationException("Response is not successful."
                    + ", with params: " + String.join(",", params),
                    nonNull(responseEntity) ? responseEntity.getStatusCodeValue() : 400);
        }

        IpgBaseResponseDto responseBody = responseEntity.getBody();
        if(!ipgPropertiesConfig.getSuccessResponseCodes().contains(responseBody.getResult().getCode())) {
            throw new IntegrationException(responseBody.getResult().getDescription()
                    + ", with params: " + String.join(",", params),
                    nonNull(responseEntity) ? responseEntity.getStatusCodeValue() : 400);
        }
        return (T) responseBody;
    }
}
