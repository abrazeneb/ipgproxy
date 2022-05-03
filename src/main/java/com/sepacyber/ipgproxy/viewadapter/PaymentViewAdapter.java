package com.sepacyber.ipgproxy.viewadapter;


import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PaymentTransactionBulkQueryCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentCardResponse;

import java.util.List;
public interface PaymentViewAdapter {
    PaymentCardResponse.PaymentResponse processPayment(PaymentCommand paymentRequestDto);
    ExistingPaymentActionResponse takeActionOnExistingPayment(final ActionOnExistingPaymentCommand actionOnExistingPaymentCommand);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto);
}
