package com.sepacyber.ipgproxy.infrastructure.kafka;

import com.sepacyber.ipgproxy.applicationcore.ports.out.event.PaymentFailedEvent;
import com.sepacyber.ipgproxy.applicationcore.ports.out.event.PaymentProcessedEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.cloud.stream.kafka.streams.binder.brokers}")
    private String bootstrapServer;

    @Bean(name = "paymentProcessedEventKafkaTemplate")
    public KafkaTemplate<String, PaymentProcessedEvent> paymentProcessedEventKafkaTemplate() {
        return new KafkaTemplate<>(paymentProcessedProducerFactory());
    }

    @Bean(name = "paymentFailedEventKafkaTemplate")
    public KafkaTemplate<String, PaymentFailedEvent> paymentFailedEventKafkaTemplate() {
        return new KafkaTemplate<>(paymentFailedProducerFactory());
    }

    @Bean
    public ProducerFactory<String, PaymentProcessedEvent> paymentProcessedProducerFactory() {
        return new DefaultKafkaProducerFactory<>(jsonConfigs());
    }

    @Bean
    public ProducerFactory<String, PaymentFailedEvent> paymentFailedProducerFactory() {
        return new DefaultKafkaProducerFactory<>(jsonConfigs());
    }

    private Map<String, Object> jsonConfigs(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configs;
    }
}
