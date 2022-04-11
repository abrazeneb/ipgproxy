package com.sepacyber.ipgproxy.api;

import com.sepacyber.ipgproxy.api.dto.AsyncPaymentDto;
import com.sepacyber.ipgproxy.api.dto.SynchronousPaymentDto;
import com.sepacyber.ipgproxy.api.dto.ThreeDSecurPaymentDto;
import com.sepacyber.ipgproxy.application.ports.in.PaymentUseCase;
import com.sepacyber.ipgproxy.application.ports.in.command.AsyncPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.command.CommandCustomer;
import com.sepacyber.ipgproxy.application.ports.in.command.SynchronousPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.command.ThreeDSecurPaymentCommand;
import com.sepacyber.ipgproxy.application.ports.in.result.AsynchronousPaymentResult;
import com.sepacyber.ipgproxy.application.ports.in.result.SynchronousPaymentResult;
import com.sepacyber.ipgproxy.application.ports.in.result.ThreeDSecurePaymentResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentUseCase paymentUseCase;
    private final MapperFacade mapper;

    @PostMapping("/synchronous")
    public SynchronousPaymentResult syncPay(@RequestBody SynchronousPaymentDto synchronousPaymentDto,
                                            HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", synchronousPaymentDto );
        CommandCustomer customer= synchronousPaymentDto.getCustomer();
        customer.setIp(request.getRemoteAddr());
        SynchronousPaymentCommand synchronousPaymentCommand = mapper.map(synchronousPaymentDto, SynchronousPaymentCommand.class);
        synchronousPaymentDto.setCustomer(customer);
        return paymentUseCase.paySynchronous(synchronousPaymentCommand);
    }

    @PostMapping("/asynchronous")
    public AsynchronousPaymentResult asyncPay(@RequestBody AsyncPaymentDto asyncPaymentDto,
                                              HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", asyncPaymentDto );
        AsyncPaymentCommand asyncPaymentCommand = mapper.map(asyncPaymentDto, AsyncPaymentCommand.class);
        CommandCustomer customer= asyncPaymentCommand.getCustomer();
        customer.setIp(request.getRemoteAddr());
        asyncPaymentCommand.setCustomer(customer);
        return paymentUseCase.payAsync(asyncPaymentCommand);
    }

    @PostMapping("/3dSecur")
    public ThreeDSecurePaymentResult tokenizePayment(@RequestBody ThreeDSecurPaymentDto threeDSecurPaymentDto,
                                                     HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", threeDSecurPaymentDto );
        CommandCustomer customer= threeDSecurPaymentDto.getCustomer();
        customer.setIp(request.getRemoteAddr());
        ThreeDSecurPaymentCommand threeDSecurPaymentCommand = mapper.map(threeDSecurPaymentDto, ThreeDSecurPaymentCommand.class);
        threeDSecurPaymentCommand.setCustomer(customer);
        return paymentUseCase.pay3DSecure(threeDSecurPaymentCommand);
    }
}
