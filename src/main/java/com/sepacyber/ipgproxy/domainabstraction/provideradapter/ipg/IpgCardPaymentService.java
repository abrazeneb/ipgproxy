package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AsynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.SynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ThreeDSecurePaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.*;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.IpgPaymentResponseDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.IpgAsyncPaymentResponseDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.IpgPaymentStatusResponseDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.IpgPaymentTransactionQueryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ExistingPaymentActionResponse getPaymentStatus(final String transactionId, final PaymentStatusCommandDto paymentStatusCommandDto) {
        log.debug("Processing ipg get payment status");
        IpgPaymentStatusRequest requestDto = mapper.map(paymentStatusCommandDto, IpgPaymentStatusRequest.class);
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.paymentStatus(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), ExistingPaymentActionResponse.class);
    }

    @Override
    public List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto) {
        log.debug("Processing ipg get payment status");
        IpgPaymentTransactionQueryRequest requestDto = mapper.map(paymentTransactionBulkQueryCommandDto, IpgPaymentTransactionQueryRequest.class);
        ResponseEntity<IpgPaymentTransactionQueryResponse> response = ipgPaymentApiClient.queryTransactions(requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.mapAsList(response.getBody().getTransaction(), ExistingPaymentActionResponse.class);
    }

    @Override
    public ExistingPaymentActionResponse capturePayment(final String transactionId, final PaymentCaptureCommandDto captureCommandDto) {
        log.debug("Processing ipg capture payment");
        IpgPaymentCaptureRequest requestDto = mapper.map(captureCommandDto, IpgPaymentCaptureRequest.class);
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.capturePayment(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), ExistingPaymentActionResponse.class);
    }

    @Override
    public ExistingPaymentActionResponse reversePayment(final String transactionId, final PaymentReversalCommandDto reversalCommandDto) {
        log.debug("Processing ipg capture payment");
        IpgPaymentReversalRequest requestDto = mapper.map(reversalCommandDto, IpgPaymentReversalRequest.class);
        ResponseEntity<IpgPaymentStatusResponseDto> response = ipgPaymentApiClient.reversePayment(transactionId, requestDto);
        log.debug("Received response from ipg client {}", response);
        return mapper.map(response.getBody(), ExistingPaymentActionResponse.class);
    }
}
