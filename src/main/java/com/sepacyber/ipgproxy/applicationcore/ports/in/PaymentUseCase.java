package com.sepacyber.ipgproxy.applicationcore.ports.in;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AbstractPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;

import java.util.List;

public interface PaymentUseCase {
    AbstractPaymentResponse processPayment(AbstractPaymentCommandDto command);
    ExistingPaymentActionResponse getPaymentStatus(final String transactionId, final PaymentStatusCommandDto paymentStatusCommand);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto);
    ExistingPaymentActionResponse capturePayment(final String transactionId, final PaymentCaptureCommandDto captureCommandDto);
    ExistingPaymentActionResponse reversePayment(final String transactionId, final PaymentReversalCommandDto reversalCommandDto);
}
