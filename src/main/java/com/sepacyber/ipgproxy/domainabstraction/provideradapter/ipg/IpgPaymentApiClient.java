package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.*;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${ipg.provider.base.name:IpgPaymentApiClient}",
url = "${ipg.provider.base.url:https://wso2-mi-staging.local.sepa-cyber.com}/vendor/ipg")
public interface IpgPaymentApiClient {

    @PostMapping("/syncPay")
    ResponseEntity<IpgPaymentResponseDto> paySync(
            @RequestBody final IpgSyncPaymentRequestDto requestDto);

    @PostMapping("/payments")
    ResponseEntity<IpgAsyncPaymentResponseDto> payAsync(
            @RequestBody final IpgAsyncPaymentRequestDto requestDto);

    @PostMapping("/getStatus/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> paymentStatus(
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentStatusRequest requestDto);

    @PostMapping("/capture/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> capturePayment(
            @PathVariable("id") String id,
            @RequestBody final IpgOtherActionsPaymentCaptureRequest requestDto);

    @PostMapping("/cancel/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> reversePayment(
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentReversalRequest requestDto);

    @PostMapping("/refund/{id}")
    ResponseEntity<IpgPaymentStatusResponseDto> refundPayment(
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentRefundRequest requestDto);

    @PostMapping("/getTransactionList")
    ResponseEntity<IpgPaymentTransactionQueryResponse> queryTransactions(
            @RequestBody final IpgPaymentTransactionQueryRequest requestDto);

    @PostMapping("/registrations")
    ResponseEntity<IpgAsyncPaymentResponseDto> tokenizeTransaction(
            @RequestBody final IpgAsyncPaymentRequestDto requestDto);

    @PostMapping("/registrations/{id}")
    ResponseEntity<IpgPaymentWithTokenResponse> payWithToken(
            @PathVariable("id") String id,
            @RequestBody final IpgPaymentWithTokenRequest requestDto);

    @PostMapping("/getCardsAndAccounts ")
    ResponseEntity<IpgCardsAndAccountsResponse> getCardsAndAccounts (
            @RequestBody final AuthenticationDto requestDto);

    @PostMapping("/payments/register ")
    ResponseEntity<IpgTokenizationPaymentResponse> registerPayment (
            @RequestBody final IpgStandalonePaymentStoreRequest requestDto);

    @PostMapping("/payments/fromStoredToken")
    ResponseEntity<IpgPayWithTokenResponse> payFromStoredToken (
            @RequestBody final IpgPayWithStoredTokenRequest requestDto);

    @PostMapping("/payments/delete")
    ResponseEntity<IpgDeleteStoredPaymentResponse> deleteStoredPaymentData (
            @RequestBody final IpgDeleteStoredPaymentDataRequest requestDto);

    @PostMapping("/payments/installments")
    ResponseEntity<IpgQueryPaymentInstallmentsResponse> queryPaymentInstallments (
            @RequestBody final IpgQueryPaymentInstallmentsRequest requestDto);

}
