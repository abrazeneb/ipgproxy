package com.sepacyber.ipgproxy.application.ports.out;

import com.sepacyber.ipgproxy.application.dto.CardPaymentRequestDto;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.PayWithCardCommandResult;

public interface CardPaymentPort {
    PayWithCardCommandResult pay(PayWithCardCommand payWithCardCommand);
}
