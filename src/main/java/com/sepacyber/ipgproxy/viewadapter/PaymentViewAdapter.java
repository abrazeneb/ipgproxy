package com.sepacyber.ipgproxy.viewadapter;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.PaymentCardResponse;

public interface PaymentViewAdapter {
    PaymentCardResponse.PaymentResponse processPayment(PaymentCommand paymentRequestDto);
}
