package com.sepacyber.ipgproxy.domainabstraction.integrationhandler;

import com.sepacyber.ipgproxy.applicationcore.ports.out.PaymentProcessedEvent;
import com.sepacyber.ipgproxy.shared.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisStreamProducer<T> {

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
}
