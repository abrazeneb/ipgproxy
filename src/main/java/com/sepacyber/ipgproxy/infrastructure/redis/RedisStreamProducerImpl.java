package com.sepacyber.ipgproxy.infrastructure.redis;

import com.sepacyber.ipgproxy.domainabstraction.integrationhandler.RedisStreamProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisStreamProducerImpl<T> implements RedisStreamProducer<T> {

    @Value("${config.sidecar.event-topic:config-sidecar_tenant_config_event_channel}")
    private String topic;

    private final RedisTemplate<String, T> redisTemplate;

    public void publish(String streamName, T event) {
        ObjectRecord<String, T> record = StreamRecords.newRecord()
                .in(streamName)
                .ofObject(event)
                .withId(RecordId.autoGenerate());

        RecordId recordId = redisTemplate.opsForStream().add(record);

        log.info("Event produced:[{}] ", event);
        log.info("Redis Stream RecordId: {}", recordId);
    }

    @Scheduled(fixedRate = 3000)
    public void publish() {
        this.redisTemplate.convertAndSend(topic, "test");
    }
}
