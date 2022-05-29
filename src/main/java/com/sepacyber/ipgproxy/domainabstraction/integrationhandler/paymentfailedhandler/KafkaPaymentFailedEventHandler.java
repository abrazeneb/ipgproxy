package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.paymentfailedhandler;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.applicationcore.ports.out.event.PaymentFailedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class KafkaPaymentFailedEventHandler implements Notification.Handler<PaymentFailedEvent>{

    private final KafkaTemplate<String, PaymentFailedEvent> kafkaTemplate;

    public KafkaPaymentFailedEventHandler(@Qualifier("paymentFailedEventKafkaTemplate") KafkaTemplate<String, PaymentFailedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${spring.cloud.stream.bindings.payment-failed-out.destination}")
    private String paymentFailedTopic;

    @Override
    public void handle(PaymentFailedEvent event) {
        log.info("Sending paymentFailedEvent to kafka topic: {}", event);

        var futureResult = kafkaTemplate.send(paymentFailedTopic, event);

        futureResult.addCallback(new ListenableFutureCallback<SendResult<String, PaymentFailedEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error sending paymentFailedEvent to kafka topic: {}", ex.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, PaymentFailedEvent> result) {
                var resultMetadata = result.getRecordMetadata();
                log.info("Sent paymentFailedEvent to kafka topic: {} with serializedValueSize: {} with offset: {}", resultMetadata.topic(), resultMetadata.serializedValueSize(), resultMetadata.offset());
            }
        });
    }
}
