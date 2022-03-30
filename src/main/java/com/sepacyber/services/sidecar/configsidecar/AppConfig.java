package com.sepacyber.services.sidecar.configsidecar;

import com.sepacyber.services.sidecar.configsidecar.domain.entity.redis.TenantConfigCacheEntity;
import com.sepacyber.services.sidecar.configsidecar.domain.model.TenantConfigAsyncEvent;
import com.sepacyber.services.sidecar.configsidecar.domain.service.TenantConfigAsyncEventManager;
import com.sepacyber.services.sidecar.configsidecar.domain.service.TenantConfigManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Value("${app.service.id}")
    private String serviceId;

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.sepacyber.services.sidecar.configsidecar.domain.entity.sql");
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);

        return new LettuceConnectionFactory(configuration);
    }

    @Bean("redisTemplate")
    public RedisTemplate<String, TenantConfigCacheEntity> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, TenantConfigCacheEntity> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);

        return template;
    }

    @Bean
    MessageListenerAdapter messageListener(ChannelTopic listenerChannelTopic, TenantConfigManager tenantConfigManager) {

        return new MessageListenerAdapter(new TenantConfigAsyncEventManager(listenerChannelTopic, tenantConfigManager));
    }

    @Bean
    RedisMessageListenerContainer redisContainer(MessageListenerAdapter messageListener, ChannelTopic listenerChannelTopic, RedisConnectionFactory redisConnectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(redisConnectionFactory);

        container.addMessageListener(messageListener, listenerChannelTopic);

        return container;
    }


    @Bean
    ChannelTopic listenerChannelTopic() {
        String asyncMessageChannelPostfix = "tenant_config_event_channel";
        return new ChannelTopic(this.serviceId.concat("_").concat(asyncMessageChannelPostfix));
    }




    /* bean will be used by integration testing process only*/
    @Bean("publisherRedisConnectionFactory")
    RedisConnectionFactory publisherRedisConnectionFactory() {

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);

        return new LettuceConnectionFactory(configuration);
    }

    /* bean will be used by integration testing process only*/
    @Bean("publisherRedisTemplate")
    public RedisTemplate<String, TenantConfigAsyncEvent> publisherRedisTemplate(RedisConnectionFactory publisherRedisConnectionFactory) {

        RedisTemplate<String, TenantConfigAsyncEvent> template = new RedisTemplate<>();

        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(TenantConfigAsyncEvent.class));
        template.setConnectionFactory(publisherRedisConnectionFactory);

        return template;
    }

}
