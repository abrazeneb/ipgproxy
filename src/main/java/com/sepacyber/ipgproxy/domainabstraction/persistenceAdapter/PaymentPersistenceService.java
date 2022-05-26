package com.sepacyber.ipgproxy.domainabstraction.persistenceAdapter;

import com.sepacyber.ipgproxy.applicationcore.domain.payment.Payment;
import com.sepacyber.ipgproxy.applicationcore.domain.payment.PaymentStatus;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentPersistencePort;
import com.sepacyber.ipgproxy.domainabstraction.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentPersistenceService implements PaymentPersistencePort {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
       return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    @Override
    public void bulkUpdatePaymentStatus(List<ExistingPaymentActionResponse> existingPaymentActionResponses) {

        existingPaymentActionResponses.stream()
                .forEach(existingPaymentActionResponse -> {
                    Payment payment =paymentRepository.findFirstByPaymentId(existingPaymentActionResponse.getPaymentId());
                    if(payment.getPaymentStatus().name().equalsIgnoreCase(existingPaymentActionResponse.getStatus())) {
                        payment.setPaymentStatus(PaymentStatus.valueOf(existingPaymentActionResponse.getStatus()));
                        paymentRepository.save(payment);
                    }
                });
    }
}
