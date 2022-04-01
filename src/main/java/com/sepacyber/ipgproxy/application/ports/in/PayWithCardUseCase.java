package com.sepacyber.ipgproxy.application.ports.in;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.PayWithCardResponse;
import com.sepacyber.ipgproxy.application.ports.in.result.PayWithCardCommandResponse;

public interface PayWithCardUseCase {
    PayWithCardResponse payWithCard(String authToken, PayWithCardCommand payWithCardCommand);
}
