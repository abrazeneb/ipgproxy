package com.sepacyber.ipgproxy.infrastructure.feign;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.sepacyber.ipgproxy.domainabstraction.integrationhandler")
@Import(FeignClientsConfiguration.class)
public class IntegrationHandlerFeignConfiguration {

    @Bean
    Logger.Level integrationHandlerFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
