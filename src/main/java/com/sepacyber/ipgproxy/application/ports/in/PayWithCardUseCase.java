package com.sepacyber.ipgproxy.application.ports.in;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.application.ports.in.responses.PayWithCardResponse;

public interface PayWithCardUseCase {
    PayWithCardResponse payWithCard(PayWithCardCommand payWithCardCommand);
}
