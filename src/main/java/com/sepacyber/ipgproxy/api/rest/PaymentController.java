package com.sepacyber.ipgproxy.api.rest;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentStatusBulkResponse;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestActionOnExistingPaymentCommand;
import com.sepacyber.ipgproxy.viewadapter.rest.command.RestPaymentCommand;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;
import com.sepacyber.ipgproxy.viewadapter.PaymentViewAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentViewAdapter paymentViewAdapter;

    @PostMapping
    public PaymentResponse pay(@RequestBody RestPaymentCommand restPaymentCommand,
                               HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restPaymentCommand );
        return paymentViewAdapter.processPayment(restPaymentCommand);
    }

    @PostMapping("/{transactionId}")
    public ExistingPaymentActionResponse paymentAction(@PathVariable("transactionId") final String transactionId,
                                                       final @RequestBody RestActionOnExistingPaymentCommand restActionOnExistingPaymentCommand,
                                                       HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restActionOnExistingPaymentCommand );
        return paymentViewAdapter.takeActionOnExistingPayment(transactionId, restActionOnExistingPaymentCommand);
    }

    @PostMapping("/status/list")
    public PaymentStatusBulkResponse getPaymentStatusList(final @RequestBody RestActionOnExistingPaymentCommand restActionOnExistingPaymentCommand,
                                                          HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", restActionOnExistingPaymentCommand );
        return PaymentStatusBulkResponse.builder()
                .payments(paymentViewAdapter.getPaymentStatusList(restActionOnExistingPaymentCommand))
                .build();
    }
}
