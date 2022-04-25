package com.sepacyber.ipgproxy.api.rest;

import com.sepacyber.ipgproxy.viewadapter.rest.command.RestPaymentCommand;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;
import com.sepacyber.ipgproxy.viewadapter.PaymentViewAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
}
