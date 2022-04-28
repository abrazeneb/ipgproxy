package com.sepacyber.ipgproxy.applicationcore.ports.in;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AbstractPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AbstractPaymentResponse;

public interface PaymentUseCase {
    AbstractPaymentResponse processPayment(AbstractPaymentCommandDto command);
}
