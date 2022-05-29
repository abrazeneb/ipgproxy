package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.paymentprocessedhandler;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.applicationcore.ports.out.event.PaymentProcessedEvent;
import com.sepacyber.ipgproxy.domainabstraction.integrationhandler.RedisStreamProducer;
import com.sepacyber.ipgproxy.shared.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisPaymentProcessedEventHandler implements Notification.Handler<PaymentProcessedEvent> {

    private final RedisStreamProducer<PaymentProcessedEvent> redisStreamProducer;

    @Override
    public void handle(PaymentProcessedEvent event) {
        log.info("PaymentProcessedEvent received: {}", event);
        redisStreamProducer.publish(Constants.IPG_PAYMENT_PROCESSED_STREAM_NAME, event);
    }
}
