package com.sepacyber.ipgproxy.application.ports.out;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.result.PayWithCardCommandResponse;

public interface CardPaymentPort {
    PayWithCardCommandResponse pay(String authToken, PayWithCardCommand payWithCardCommand);
    PayWithCardCommandResponse payAsync(PayWithCardCommand payWithCardCommand);
}
