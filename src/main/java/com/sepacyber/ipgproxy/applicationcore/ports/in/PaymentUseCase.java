package com.sepacyber.ipgproxy.applicationcore.ports.in;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.AsynchronousPaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.SynchronousPaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.ThreeDSecurePaymentResult;

public interface PaymentUseCase {
    AsynchronousPaymentResult payAsync(AsyncPaymentCommandDto asyncPaymentCommand);
    SynchronousPaymentResult paySynchronous(SynchronousPaymentCommandDto synchronousPaymentCommand);
    ThreeDSecurePaymentResult pay3DSecure(ThreeDSecurPaymentCommandDto threeDSecurPaymentCommand);
}
