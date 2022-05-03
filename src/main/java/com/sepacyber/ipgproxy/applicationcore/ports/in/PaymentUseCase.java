package com.sepacyber.ipgproxy.applicationcore.ports.in;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AbstractPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;

import java.util.List;

public interface PaymentUseCase {
    AbstractPaymentResponse processPayment(AbstractPaymentCommandDto command);
    ExistingPaymentActionResponse processActionOnExistingPayment(final AbstractActionOnPaymentCommandDto actionOnPaymentCommandDto);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto);
}
