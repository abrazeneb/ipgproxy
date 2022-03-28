package com.sepacyber.ipgproxy.integrationhandler.sepawallet.rest;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.shared.integrationpayload.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class WalletTransactionHandler implements Notification.Handler<TransactionDto> {

    @Override
    public void handle(TransactionDto notification) {
        //TODO implement
    }

    @Override
    public boolean matches(TransactionDto notification) {
        return Notification.Handler.super.matches(notification);
    }
}
