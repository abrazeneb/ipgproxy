package com.sepacyber.ipgproxy.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.application.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.application.ports.in.command.AsyncPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.command.SynchronousPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.command.ThreeDSecurPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.result.AsynchronousPaymentResult;
import com.sepacyber.ipgproxy.application.ports.in.result.SynchronousPaymentResult;
import com.sepacyber.ipgproxy.application.ports.in.result.ThreeDSecurePaymentResult;
import com.sepacyber.ipgproxy.application.ports.out.CardPaymentPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CoreBean
public class PaymentService implements PaymentUseCase {

    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;

    public AsynchronousPaymentResult payAsync(AsyncPaymentCommand asyncPaymentCommand) {
        return cardPaymentPort.payAsync(asyncPaymentCommand);
    }

    @Override
    public SynchronousPaymentResult paySynchronous(SynchronousPaymentCommand synchronousPaymentCommand) {
        return cardPaymentPort.paySync(synchronousPaymentCommand);
    }

    @Override
    public ThreeDSecurePaymentResult pay3DSecure(ThreeDSecurPaymentCommand threeDSecurPaymentCommand) {
        return cardPaymentPort.pay3DSecure(threeDSecurPaymentCommand);
    }


}
