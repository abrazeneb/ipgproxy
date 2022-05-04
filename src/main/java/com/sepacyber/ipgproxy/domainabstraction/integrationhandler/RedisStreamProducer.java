package com.sepacyber.ipgproxy.domainabstraction.integrationhandler;

public interface RedisStreamProducer<T> {
    void publish(String streamName, T event);
}
