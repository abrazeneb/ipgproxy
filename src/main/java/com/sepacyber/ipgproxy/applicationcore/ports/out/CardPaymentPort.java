package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AsynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.SynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ThreeDSecurePaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.BusinessWithAdditionalDataDto;

import java.util.List;

public interface CardPaymentPort {
    AsynchronousPaymentResponse payAsync(AsyncPaymentCommandDto asyncPaymentCommand, BusinessWithAdditionalDataDto businessAdditionalData);
    SynchronousPaymentResponse paySync(SynchronousPaymentCommandDto synchronousPaymentCommand, BusinessWithAdditionalDataDto businessAdditionalData);
    ThreeDSecurePaymentResponse pay3DSecure(ThreeDSecurePaymentCommandDto threeDSecurPaymentCommand, BusinessWithAdditionalDataDto businessAdditionalData);
    ExistingPaymentActionResponse getPaymentStatus(final String transactionId, final PaymentStatusCommandDto paymentStatusCommandDto, BusinessWithAdditionalDataDto businessWithAdditionalDataDto);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto, BusinessWithAdditionalDataDto businessWithAdditionalDataDto);
    ExistingPaymentActionResponse capturePayment(final String transactionId, final PaymentCaptureCommandDto captureCommandDto, BusinessWithAdditionalDataDto businessWithAdditionalDataDto);
    ExistingPaymentActionResponse reversePayment(final String transactionId, final PaymentReversalCommandDto reversalCommandDto, BusinessWithAdditionalDataDto businessWithAdditionalDataDto);
}
