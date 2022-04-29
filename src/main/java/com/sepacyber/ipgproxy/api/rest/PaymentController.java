package com.sepacyber.ipgproxy.api.rest;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PaymentTransactionBulkQueryCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentCardResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentStatusBulkResponse;
import com.sepacyber.ipgproxy.viewadapter.PaymentViewAdapter;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestActionOnExistingPaymentCommand;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestPaymentCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentViewAdapter paymentViewAdapter;

    @PostMapping
    public PaymentCardResponse.PaymentResponse pay(@RequestBody RestPaymentCommand restPaymentCommand,
                                                   HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restPaymentCommand );
        return paymentViewAdapter.processPayment(restPaymentCommand);
    }

    @PostMapping("/{paymentId}")
    public ExistingPaymentActionResponse paymentAction(@PathVariable("paymentId") final String paymentId,
                                                       final @RequestBody RestActionOnExistingPaymentCommand restActionOnExistingPaymentCommand,
                                                       HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restActionOnExistingPaymentCommand );
        return paymentViewAdapter.takeActionOnExistingPayment(paymentId, restActionOnExistingPaymentCommand);
    }

    @PostMapping("/status/list")
    public PaymentStatusBulkResponse getPaymentStatusList(final @RequestBody PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto,
                                                          HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", paymentTransactionBulkQueryCommandDto );
        return PaymentStatusBulkResponse.builder()
                .payments(paymentViewAdapter.getPaymentStatusList(paymentTransactionBulkQueryCommandDto))
                .build();
    }
}
