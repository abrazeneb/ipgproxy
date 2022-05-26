package com.sepacyber.ipgproxy.domainabstraction.repository;

import com.sepacyber.ipgproxy.applicationcore.domain.payment.Payment;
import com.sepacyber.ipgproxy.applicationcore.domain.payment.PaymentStatus;
import com.sepacyber.ipgproxy.shared.model.PaymentId;

import java.util.List;

public interface PaymentRepository  extends BaseRepository<Payment, PaymentId>{
    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);
    Payment findFirstByPaymentId(final String paymentId);
}
