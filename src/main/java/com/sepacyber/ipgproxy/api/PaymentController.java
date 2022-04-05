package com.sepacyber.ipgproxy.api;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardUseCase;
import com.sepacyber.ipgproxy.application.ports.in.responses.PayWithCardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PayWithCardUseCase payWithCardUseCase;

    @PostMapping("/card")
    public PayWithCardResponse payWithCard(@RequestBody PayWithCardCommand payWithCardCommand,
                                           HttpServletRequest request) {
        log.debug("Precessing pay with card request for request {}", payWithCardCommand );
        PayWithCardCommand.Customer customer= payWithCardCommand.getCustomer();
        customer.setIp(request.getRemoteAddr());
        payWithCardCommand.setCustomer(customer);
        return payWithCardUseCase.payWithCard(payWithCardCommand);
    }
}
