package com.sepacyber.ipgproxy.viewadapter;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;

public interface PaymentViewAdapter {
    PaymentResponse processPayment(PaymentCommand paymentRequestDto);
    ExistingPaymentActionResponse takeActionOnExistingPayment(ActionOnExistingPaymentCommand actionOnExistingPaymentCommand);
}
