package com.sepacyber.ipgproxy.applicationcore.application.service;

import an.awesome.pipelinr.Pipeline;
import com.sepacyber.ipgproxy.applicationcore.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AsyncPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.SynchronousPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.ThreeDSecurPaymentCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.AsynchronousPaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.SynchronousPaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.in.result.ThreeDSecurePaymentResult;
import com.sepacyber.ipgproxy.applicationcore.ports.out.CardPaymentPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@CoreBean
public class PaymentService implements PaymentUseCase {

    private final CardPaymentPort cardPaymentPort;
    private final Pipeline pipeline;

    @Override
    public AsynchronousPaymentResult payAsync(AsyncPaymentCommandDto asyncPaymentCommand) {
        return cardPaymentPort.payAsync(asyncPaymentCommand);
    }

    @Override
    public SynchronousPaymentResult paySynchronous(SynchronousPaymentCommandDto synchronousPaymentCommand) {
        return cardPaymentPort.paySync(synchronousPaymentCommand);
    }

    @Override
    public ThreeDSecurePaymentResult pay3DSecure(ThreeDSecurPaymentCommandDto threeDSecurPaymentCommand) {
        return cardPaymentPort.pay3DSecure(threeDSecurPaymentCommand);
    }


}
