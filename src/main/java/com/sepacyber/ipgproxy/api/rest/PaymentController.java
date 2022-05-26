package com.sepacyber.ipgproxy.api.rest;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PaymentTransactionBulkQueryCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.*;
import com.sepacyber.ipgproxy.viewadapter.PaymentViewAdapter;
import com.sepacyber.ipgproxy.viewadapter.rest.command.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentViewAdapter paymentViewAdapter;

    @PostMapping
    public PaymentCardResponse.PaymentResponse pay(@RequestBody RestPaymentCommand restPaymentCommand,
                                                   HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restPaymentCommand );
        return paymentViewAdapter.processPayment(restPaymentCommand);
    }

    @PostMapping("/existing")
    public ExistingPaymentActionResponse paymentAction(final @RequestBody RestActionOnExistingPaymentCommand restActionOnExistingPaymentCommand,
                                                       HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restActionOnExistingPaymentCommand );
        return paymentViewAdapter.takeActionOnExistingPayment(restActionOnExistingPaymentCommand);
    }

    @PostMapping("/status/list")
    public PaymentStatusBulkResponse getPaymentStatusList(final @RequestBody PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto,
                                                          HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", paymentTransactionBulkQueryCommandDto );
        return PaymentStatusBulkResponse.builder()
                .payments(paymentViewAdapter.getPaymentStatusList(paymentTransactionBulkQueryCommandDto))
                .build();
    }

    @PostMapping("/withStoredData")
    public StoredTokenPaymentResponse payWithStoredData(final @RequestBody RestPaymentWithStoredDataCommand restPaymentWithStoredDataCommand,
                                                        HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restPaymentWithStoredDataCommand );
        return paymentViewAdapter.payWithStoredData(restPaymentWithStoredDataCommand);
    }

    @DeleteMapping("/storedData")
    public DeleteStoredPaymentDataResponse deleteStoredPaymentData(final @RequestBody RestDeleteStoredPaymentData restDeleteStoredPaymentData,
                                                                   HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restDeleteStoredPaymentData );
        return paymentViewAdapter.deletePaymentWithStoredData(restDeleteStoredPaymentData);
    }

    @PostMapping("/query")
    public QueryPaymentInstallmentsResponse queryPaymentInstallements(final @RequestBody RestQueryPaymentInstallmentsCommand restQueryPaymentInstallmentsCommand,
                                                                   HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restQueryPaymentInstallmentsCommand );
        return paymentViewAdapter.queryPaymentInstallments(restQueryPaymentInstallmentsCommand);
    }

}
