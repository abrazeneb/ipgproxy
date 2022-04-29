package com.sepacyber.ipgproxy.viewadapter;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PaymentTransactionBulkQueryCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentViewAdapter {
    PaymentResponse processPayment(PaymentCommand paymentRequestDto);
    ExistingPaymentActionResponse takeActionOnExistingPayment(final String transactionId, final ActionOnExistingPaymentCommand actionOnExistingPaymentCommand);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto);
}
