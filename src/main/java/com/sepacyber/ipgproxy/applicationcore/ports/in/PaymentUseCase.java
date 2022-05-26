package com.sepacyber.ipgproxy.applicationcore.ports.in;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.*;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.*;

import java.util.List;

public interface PaymentUseCase {
    AbstractPaymentResponse processPayment(AbstractPaymentCommandDto command);
    ExistingPaymentActionResponse processActionOnExistingPayment(final AbstractActionOnPaymentCommandDto actionOnPaymentCommandDto);
    List<ExistingPaymentActionResponse> getPaymentStatusList(PaymentTransactionBulkQueryCommandDto paymentTransactionBulkQueryCommandDto);
    StoredTokenPaymentResponse payWithStoredToken(PayWithStoredTokenCommandDto payWithStoredTokenCommandDto);
    DeleteStoredPaymentDataResponse deleteStoredPaymentData(DeleteStoredPaymentDataCommandDto deleteStoredPaymentDataCommandDto);
    QueryPaymentInstallmentsResponse queryPaymentInstallments(QueryPaymentInstallmentsCommandDto queryPaymentInstallmentsCommandDto);
    void pollPaymentStatus();
}
