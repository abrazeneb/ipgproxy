package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.paymentprocessedhandler;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaPaymentProcessedEventHandler implements Notification.Handler<PaymentProcessedEvent> {

    private final KafkaTemplate<String, PaymentProcessedEvent> kafkaTemplate;

    @Value("${spring.cloud.stream.bindings.payment-processed-out.destination}")
    private String paymentProcessedTopic;


    @Override
    public void handle(PaymentProcessedEvent event) {
        log.info("Payment processed event received: {}", event);

        var futureResult = kafkaTemplate.send(paymentProcessedTopic, event);

        futureResult.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error sending Payment processed event to kafka: {}", ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, PaymentProcessedEvent> result) {
                var resultMetadata = result.getRecordMetadata();
                log.info("Payment processed event sent to topic: {} with serializedValueSize: {} with offset: {}", resultMetadata.topic(), resultMetadata.serializedValueSize(), resultMetadata.offset());
            }
        });
    }
}
