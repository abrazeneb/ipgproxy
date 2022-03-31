package com.sepacyber.ipgproxy.api;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PayWithCardUseCase payWithCardUseCase;

    @RequestMapping("/card")
    public void payWithCard(@RequestBody PayWithCardCommand payWithCardCommand) {
        log.debug("Precessing pay with card request for request {}", payWithCardCommand );
        payWithCardUseCase.payWithCard(null, payWithCardCommand);
    }
}
