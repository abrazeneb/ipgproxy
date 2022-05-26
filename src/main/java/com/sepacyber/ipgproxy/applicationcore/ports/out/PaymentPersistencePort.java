package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.domain.payment.Payment;
import com.sepacyber.ipgproxy.applicationcore.domain.payment.PaymentStatus;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;

import java.util.List;

public interface PaymentPersistencePort {

    Payment save(Payment payment);
    List<Payment> getPaymentsByStatus(PaymentStatus status);
    void bulkUpdatePaymentStatus(List<ExistingPaymentActionResponse> paymentActionResponses);
}
