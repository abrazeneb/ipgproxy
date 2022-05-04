package com.sepacyber.ipgproxy.infrastructure.kafka;

import com.sepacyber.ipgproxy.domainabstraction.integrationhandler.KafkaPaymentEventBinder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

//TODO: change to functional way

// this takes care of binding input and output channels
@EnableBinding(KafkaPaymentEventBinder.class)
public class PaymentEventStreamConfig {
}
