package com.sepacyber.ipgproxy.application.ports.out;

import com.sepacyber.ipgproxy.application.ports.in.command.AsyncPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.command.SynchronousPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.command.ThreeDSecurPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.result.AsynchronousPaymentResult;
import com.sepacyber.ipgproxy.application.ports.in.result.SynchronousPaymentResult;
import com.sepacyber.ipgproxy.application.ports.in.result.ThreeDSecurePaymentResult;

public interface CardPaymentPort {
    AsynchronousPaymentResult payAsync(AsyncPaymentCommand asyncPaymentCommand);
    SynchronousPaymentResult paySync(SynchronousPaymentCommand synchronousPaymentCommand);
    ThreeDSecurePaymentResult pay3DSecure(ThreeDSecurPaymentCommand threeDSecurPaymentCommand);
}
