package com.sepacyber.ipgproxy.viewadapter;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentResponse;

public interface PaymentViewAdapter {
    PaymentResponse processPayment(PaymentCommand paymentRequestDto);
}
