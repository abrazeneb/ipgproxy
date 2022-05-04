package com.sepacyber.ipgproxy.domainabstraction.integrationhandler;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaPaymentEventBinder {
    String PAYMENT_PROCESSED_IN = "payment-processed-in";
    String PAYMENT_PROCESSED_OUT = "payment-processed-out";

    //TODO: change to functional api model
    @Input(PAYMENT_PROCESSED_IN)
    SubscribableChannel consumer();

    @Input(PAYMENT_PROCESSED_OUT)
    MessageChannel producer();

}
