package com.sepacyber.services.sidecar.configsidecar.domain.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sepacyber.services.sidecar.configsidecar.domain.model.TenantConfigAsyncEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Optional;


@Slf4j
public class TenantConfigAsyncEventManager implements MessageListener {

    private static final Gson gson = new Gson();
    private final ChannelTopic topic;
    private final TenantConfigManager tenantConfigManager;

    public TenantConfigAsyncEventManager(ChannelTopic topic, TenantConfigManager tenantConfigManager) {

        this.topic = topic;
        this.tenantConfigManager = tenantConfigManager;

    }

    /* validates if a given string represents a valid json object */
    public static boolean isValidJSONString(String jsonInString) {

        try {
            gson.fromJson(jsonInString, Map.class);
            return true;
        } catch (JsonSyntaxException ex) {
            return false;
        }

    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        final String tenantConfigEvent = Optional.of(message).map(m -> m.toString()).orElse(null);
        final String channel = Optional.of(message).map(m -> m.getChannel().toString()).orElse(null);

        log.info("TenantConfigAsyncEventManager : received message channel {}  message {}", channel, tenantConfigEvent);

        /* make sure that the channel is correct  */
        if (!StringUtils.hasText(channel) && !channel.trim().equalsIgnoreCase(topic.getTopic())) {
            log.info("TenantConfigAsyncEventManager , unknown message format or invalid topic channel , received message : {} , channel {} ", tenantConfigEvent, channel);
            return; //exit
        }

        TenantConfigAsyncEvent event = gson.fromJson(tenantConfigEvent, TenantConfigAsyncEvent.class);
        log.info("TenantConfigAsyncEventManager : received tenant config event {} ", tenantConfigEvent);

        if (!isValidJSONString(tenantConfigEvent)) {
            log.error("TenantConfigAsyncEventManager : received invalid json for tenant config event {} ", tenantConfigEvent);
            return;
        }

        //check if tenanted is specified
        if (!StringUtils.hasText(event.getTenantId())) {
            log.error("TenantConfigAsyncEventManager : received invalid tenant config event , tenantId can't be null {} ", tenantConfigEvent);
            return;
        }

        if (!StringUtils.hasText(event.getMetaData())) {
            log.error("TenantConfigAsyncEventManager : received invalid tenant config event , metadata can't be null {} ", tenantConfigEvent);
            return;
        }

        if (!isValidJSONString(event.getMetaData())) {
            log.error("TenantConfigAsyncEventManager : received invalid tenant config event , invalid json value for metadata {} ", tenantConfigEvent);
            return;
        }

        try {

            tenantConfigManager.saveAndCache(event);

            log.info("TenantConfigAsyncEventManager : completed processing tenant config event {} ", tenantConfigEvent);

        } catch (Exception e) {
            log.error("TenantConfigAsyncEventManager : error processing tenant config event {}  error {} ", tenantConfigEvent, e);
        }

    }

}
