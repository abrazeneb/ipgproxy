package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.*;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.IpgPayWithStoredTokenRequest;

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
    TokenizationResponse tokenizePayment(final PaymentTokenizationCommandDto paymentTokenizationCommandDto, final OrganizationDto businessWithAdditionalDataDto);
    StoredTokenPaymentResponse payWithStoredData(final PayWithStoredTokenCommandDto payWithStoredTokenRequest, final OrganizationDto businessWithAdditionalDataDto);
    DeleteStoredPaymentDataResponse deleteStoredPaymentData(final DeleteStoredPaymentDataCommandDto deleteStoredPaymentDataCommandDto, final OrganizationDto businessWithAdditionalDataDto);
    QueryPaymentInstallmentsResponse queryPaymentInstallments(final QueryPaymentInstallmentsCommandDto queryPaymentInstallmentsCommandDto, final OrganizationDto businessWithAdditionalDataDto);
}
