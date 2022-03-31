package com.sepacyber.ipgproxy.application.ports.in;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.result.PayWithCardCommandResponse;

public interface PayWithCardUseCase {
    PayWithCardCommandResponse payWithCard(String authToken, PayWithCardCommand payWithCardCommand);
}
