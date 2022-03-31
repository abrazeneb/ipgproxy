package com.sepacyber.ipgproxy.provideradapter.ipg;

import com.sepacyber.ipgproxy.provideradapter.ipg.payment.request.*;
import com.sepacyber.ipgproxy.provideradapter.ipg.payment.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${ipg.provider.base.name:IpgPaymentApiClient}",
url = "${ipg.provider.base.url:https://tp.sepa-cyber.com}/transactionServices/REST/v1")
public interface IpgPaymentApiClient {
    @PostMapping("/payments")
    ResponseEntity<IpgPaymentResponseDto> pay(
            @RequestHeader(value = "AuthToken") final String token,
            @RequestBody final IpgSyncPaymentRequestDto requestDto);

    @PostMapping("/payments")
    ResponseEntity<IpgAsyncPaymentResponseDto> payAsync(
            @RequestHeader(value = "AuthToken") final String token,
            @RequestBody final IpgAsyncPaymentRequestDto requestDto);

    @PostMapping("/payments/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> paymentStatus(
            @RequestHeader(value = "AuthToken") final String token,
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentStatusRequest requestDto);

    @PostMapping("/payments/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> capturePayment(
            @RequestHeader(value = "AuthToken") final String token,
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentCaptureRequest requestDto);

    @PostMapping("/payments/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> reversePayment(
            @RequestHeader(value = "AuthToken") final String token,
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentReversalRequest requestDto);
    @PostMapping("/getTransactionList")
    ResponseEntity<IpgPaymentTransactionQueryResponse> queryTransactions(
            @RequestHeader(value = "AuthToken") final String token,
            @RequestBody final IpgPaymentTransactionQueryRequest requestDto);


    @PostMapping("/registrations")
    ResponseEntity<IpgAsyncPaymentResponseDto> tokenizeTransaction(
            @RequestHeader(value = "AuthToken") final String token,
            @RequestBody final IpgAsyncPaymentRequestDto requestDto);

    @PostMapping("/registrations/{id}")
    ResponseEntity<IpgPaymentWithTokenResponse> paywithtoken(
            @RequestHeader(value = "AuthToken") final String token,
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentWithTokenRequest requestDto);

    @PostMapping("/getCardsAndAccounts ")
    ResponseEntity<IpgCardsAndAccountsResponse> getCardsAndAccounts (
            @RequestHeader(value = "AuthToken") final String token,
            @RequestBody final AuthenticationDto requestDto);

}
