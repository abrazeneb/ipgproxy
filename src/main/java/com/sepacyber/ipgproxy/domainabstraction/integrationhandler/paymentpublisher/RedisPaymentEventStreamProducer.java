package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.paymentpublisher;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import com.sepacyber.ipgproxy.domainabstraction.integrationhandler.RedisStreamProducer;
import com.sepacyber.ipgproxy.shared.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisPaymentEventStreamProducer implements Notification.Handler<PaymentProcessedEvent> {

    private final RedisStreamProducer<PaymentProcessedEvent> redisStreamProducer;

    @Override
    public void handle(PaymentProcessedEvent event) {
        log.info("PaymentProcessedEvent received: {}", event);
        redisStreamProducer.publish(Constants.IPG_PAYMENT_STREAM_NAME, event);
    }


    /*private final RedisTemplate<String, PaymentProcessedEvent> redisTemplate;

    @Override
    public void handle(PaymentProcessedEvent paymentEvent) {


        ObjectRecord<String, PaymentProcessedEvent> record = StreamRecords.newRecord()
                .in(Constants.IPG_PAYMENT_STREAM_NAME)
                .ofObject(paymentEvent)
                .withId(RecordId.autoGenerate());

        RecordId recordId = redisTemplate.opsForStream().add(record);

        log.info("Payment Event produced:[{}] ", paymentEvent);
        log.info("Redis Stream RecordId: {}", recordId);
    }*/


}
