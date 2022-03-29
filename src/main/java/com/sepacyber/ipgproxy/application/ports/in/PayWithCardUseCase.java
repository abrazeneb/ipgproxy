package com.sepacyber.ipgproxy.application.ports.in;

public interface PayWithCardUseCase {
    PayWithCardCommandResult payWithCard(PayWithCardCommand payWithCardCommand);
}
