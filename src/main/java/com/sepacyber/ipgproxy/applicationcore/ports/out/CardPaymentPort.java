package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.AsynchronousPaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.SynchronousPaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.ThreeDSecurePaymentResult;

public interface CardPaymentPort {
    AsynchronousPaymentResult payAsync(AsyncPaymentCommandDto asyncPaymentCommand);
    SynchronousPaymentResult paySync(SynchronousPaymentCommandDto synchronousPaymentCommand);
    ThreeDSecurePaymentResult pay3DSecure(ThreeDSecurPaymentCommandDto threeDSecurPaymentCommand);
}
