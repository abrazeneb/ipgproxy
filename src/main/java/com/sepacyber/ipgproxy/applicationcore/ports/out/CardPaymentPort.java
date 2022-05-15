package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AsynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ExistingPaymentActionResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.SynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ThreeDSecurePaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;

import java.util.List;

public interface CardPaymentPort {
    AsynchronousPaymentResponse payAsync(AsyncPaymentCommandDto asyncPaymentCommand, OrganizationDto organizationDto);
    SynchronousPaymentResponse paySync(SynchronousPaymentCommandDto synchronousPaymentCommand, OrganizationDto organizationDto);
    ThreeDSecurePaymentResponse pay3DSecure(ThreeDSecurePaymentCommandDto threeDSecurPaymentCommand, OrganizationDto organizationDto);
    ExistingPaymentActionResponse getPaymentStatus(final String transactionId, final PaymentStatusCommandDto paymentStatusCommandDto, OrganizationDto organizationDto);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto, OrganizationDto organizationDto);
    ExistingPaymentActionResponse capturePayment(final String transactionId, final PaymentCaptureCommandDto captureCommandDto, OrganizationDto organizationDto);
    ExistingPaymentActionResponse refundPayment(final String transactionId, final PaymentRefundCommandDto captureCommandDto, OrganizationDto organizationDto);
    ExistingPaymentActionResponse reversePayment(final String transactionId, final PaymentReversalCommandDto reversalCommandDto, OrganizationDto organizationDto);
}
