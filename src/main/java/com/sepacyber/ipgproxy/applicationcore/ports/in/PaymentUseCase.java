package com.sepacyber.ipgproxy.applicationcore.ports.in;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.AsynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.SynchronousPaymentResponse;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response.ThreeDSecurePaymentResponse;

public interface PaymentUseCase {
    AsynchronousPaymentResponse payAsync(AsyncPaymentCommandDto asyncPaymentCommand);
    SynchronousPaymentResponse paySynchronous(SynchronousPaymentCommandDto synchronousPaymentCommand);
    ThreeDSecurePaymentResponse pay3DSecure(ThreeDSecurPaymentCommandDto threeDSecurPaymentCommand);
}
