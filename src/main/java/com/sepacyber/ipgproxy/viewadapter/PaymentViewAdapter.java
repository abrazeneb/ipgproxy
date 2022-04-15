package com.sepacyber.ipgproxy.viewadapter;

import com.sepacyber.ipgproxy.applicationcore.ports.in.result.PaymentResult;

public interface PaymentViewAdapter {
    PaymentResult processPayment(PaymentCommand paymentRequestDto);
}
