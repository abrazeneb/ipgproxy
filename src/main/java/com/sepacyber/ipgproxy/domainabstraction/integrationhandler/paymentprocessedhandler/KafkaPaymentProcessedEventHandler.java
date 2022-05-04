package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.paymentprocessedhandler;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import com.sepacyber.ipgproxy.domainabstraction.integrationhandler.KafkaPaymentEventBinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaPaymentProcessedEventHandler implements Notification.Handler<PaymentProcessedEvent> {

    private final KafkaPaymentEventBinder kafkaPaymentEventBinder;

    @Override
    public void handle(PaymentProcessedEvent event) {
        log.info("Payment processed event received: {}", event);

        MessageChannel channel = kafkaPaymentEventBinder.producer();
        channel.send(MessageBuilder.withPayload(event)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
